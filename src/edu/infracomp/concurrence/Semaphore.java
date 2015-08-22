package edu.infracomp.concurrence;

public class Semaphore {
	
	private static int limit;
	
	private static int counter;
	
	public Semaphore(int limit) {
		this.limit = limit;
		counter = 0;
	}
	
	public synchronized void p() throws InterruptedException {
		if(counter == limit) wait();
		counter++;
		notify();
	}
	
	public synchronized void v() throws InterruptedException {
		if(counter == 0) wait();
		counter--;
		notify();
	}

}
