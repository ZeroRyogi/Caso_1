package edu.infracomp.gdts;

public class Message {
	
	private int id;
	
	private String source;
	
	private String msg;
	
	private boolean read;
	
	private Client parent;
	
	public Message(int id, String source, String msg, Client parent) {
		
		this.id = id;
		this.source = source;
		this.msg = msg;
		this.parent = parent;
		
		read = false;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isRead() {
	
		return read;
	}

	public void setRead(boolean response) {
		this.read = response;
	}

	public void neutralizeParent() throws InterruptedException {
		parent.wait();
	}
	
	public void reviveParent() {
		parent.notify();
	}
	
	public Client getParent() {
		return parent;
	}

	public void setParent(Client parent) {
		this.parent = parent;
	}

}
