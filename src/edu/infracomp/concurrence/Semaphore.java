package edu.infracomp.concurrence;

public class Semaphore {

	private static int limit;

	private static int counter;

	public Semaphore(int limit) {
		this.limit = limit;
		counter = 0;
	}

	public void pPasivo(Thread t) throws InterruptedException {
		synchronized(t) {
			while(counter == limit) t.wait();
			counter++;
			t.notify();
		}
	}

	public synchronized void vPasivo(Thread t) throws InterruptedException {
		synchronized (t) {
			counter--;
			t.notify();
		}
	}

	public synchronized void pActivo(Thread t) throws InterruptedException {
		while(counter == limit);
		counter++;
	}

	public synchronized void vActivo(Thread t) throws InterruptedException {
		counter--;
	}

}
