package lab5;

class MultiThreaded implements Runnable {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Thread name: " + Thread.currentThread().getName() + " " + i);
		}
	}

}
public class Question1 {

	public static void main(String[] args) {

		MultiThreaded multiThread = new MultiThreaded();
		Thread t1 = new Thread(multiThread, "T1");
		Thread t2 = new Thread(multiThread, "T2");
		Thread t3 = new Thread(multiThread, "T3");
		t1.start();
		t2.start();
		t3.start();

	}

}
