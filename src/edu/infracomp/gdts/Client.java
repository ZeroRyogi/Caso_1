package edu.infracomp.gdts;

import edu.infracomp.helpers.Sources;

public class Client extends Thread {
	
	private int id;
	
	private Buffer buffer;
	
	public Client(Buffer b) {
		this.buffer = b;
	}
	
	public void publishMessage(Message m) throws InterruptedException {
		while(buffer.isFull()) {
			buffer.addMessage(m);
		}
		buffer.addMessage(m);
	}
	
	@Override
	public void run() {
		int i = 0;
		while(i < 300) {
			try {
				Message m = new Message(0, Sources.CLIENT, "" + Math.random(), this);
				publishMessage(m);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
