package dkawalsk_CSCI201L_Lecture_02_09_2017;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String args[]) {
		System.out.println("Starting main method");
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
		MyThread mt3 = new MyThread("C");

		// Thread pools. How many are still running? How many are dead?
		ExecutorService executors = Executors.newCachedThreadPool();
		executors.execute(mt1);
		executors.execute(mt2);
		executors.execute(mt3);
		executors.shutdown(); // I'm not allowing any more threads to be added
								// into this service / thread pool.

		// mt1.start();
		// mt2.start();
		// mt3.start();
		// try {
		// mt1.join();
		// mt2.join(); // guarantee that Ending main method is printed after
		// B0...B19 completes
		// mt3.join(); // join() takes two threads and puts them together... not
		// happening at the same time anymore.
		// } catch (InterruptedException ie) {
		// System.out.println("ie: " + ie.getMessage());
		// }

		while (!executors.isTerminated()) { // can't say that it's terminated
											// unless shutdown() ensure no more
											// threads will be starting in the
											// thread pool
			// This allows the thread execution to run faster... because fewer checks or something?
			Thread.yield();
		}

		System.out.println("Ending main method");
	}
}

class MyThread extends Thread {
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	public void run() {

		for (int i = 0; i < 20; i++) {
			System.out.print(name + i + " ");
		} System.out.println();
		// try {
		// for (int i = 0; i < 20; i++) {
		// System.out.print(name + i + " ");
		// Thread.sleep(500);
		// }
		// System.out.println();
		// } catch (InterruptedException ie) {
		// System.out.println("ie: " + ie.getMessage());
		// }

	}

}