package edu.infracomp.gdts;

import java.util.LinkedList;

import edu.infracomp.concurrence.Semaphore;

public class Buffer {

	private int limit;

	private Semaphore semaphoreClients;

	private Semaphore semaphoreServers;

	LinkedList<Message> queue;

	public Buffer(int limit) {
		semaphoreClients = new Semaphore(1);
		semaphoreServers = new Semaphore(1);

		queue = new LinkedList<Message>();
		this.limit = limit;
	}

	public boolean addMessage(Message m) throws InterruptedException {

		boolean agrego = false;

		semaphoreClients.pPasivo(m.getParent());
		if (queue.size() <= limit ) {
			agrego = queue.add(m);
			System.out.println("[INFO] add: " + m.getMsg());
		}
		semaphoreClients.vPasivo(m.getParent());

		if(agrego) {
			m.neutralizeParent();
		}

		else{
			m.getParent().wait();
		}			

		return agrego;

	}

	public Message retrieveMessage(Server s) throws InterruptedException {
		Message m = null;
		semaphoreServers.pActivo(s);
		if (queue.size() <= limit && !queue.isEmpty() ) {
			m = queue.remove();
			m.reviveParent();
			System.out.println("[INFO] removed: " + m);
			notifyAll();
		}
		semaphoreServers.vActivo(s);

		return m;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean isFull() {
		return queue.size() == limit;
	}


}
