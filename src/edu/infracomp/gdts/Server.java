package edu.infracomp.gdts;

public class Server extends Thread {
	
	private Buffer buffer;
	
	public Server(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public Message retrieveMessage() throws InterruptedException {
		Message m = buffer.retrieveMessage(this);
		if(m != null) {
			m.setRead(true);
		}
		return m;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true) {
			try {
				retrieveMessage();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			
		}
	}

}
