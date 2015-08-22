package edu.infracomp.main;

import edu.infracomp.gdts.Buffer;
import edu.infracomp.gdts.Client;
import edu.infracomp.gdts.Server;

public class Main {

	private static Buffer buffer;

	private Server s1;
	private Server s2;
	private Server s3;
	private Server s4;

	private Client c1;
	private Client c2;
	private Client c3;
	private Client c4;


	public Main() {
		buffer = new Buffer(1);

		s1 = new Server(buffer);
		s2 = new Server(buffer);
		s3 = new Server(buffer);
		s4 = new Server(buffer);

		c1 = new Client(buffer);
		c2 = new Client(buffer);
		c3 = new Client(buffer);
		c4 = new Client(buffer);
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.startThreads();

	}

	private void startThreads() {
		s1.start();
		s2.start();
		s3.start();
		s4.start();

		c1.start();
		c2.start();
		c3.start();
		c4.start();

	}

}
