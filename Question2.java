package lab5;
import java.util.Random;

class RandomizeSum implements Runnable {
	
	private int sum;
	public RandomizeSum(int sum) {
		this.sum = sum;
	}
	
	public int getSum() {
		return sum;
	}
	public void run() {
		getSum(sum);
	}
	
	public int getSum(int sum) {
		Random random = new Random();
		int num = random.nextInt(10)+1;
		System.out.println(Thread.currentThread().getName()+"number: " + num);
		
		synchronized (this) {
			this.sum += num;
		}
		return this.sum;
	}
	
	
}
public class Question2 {
	
	public static void main(String[] args) {
		
		int initialSum = 0;
		RandomizeSum randomSum = new RandomizeSum(initialSum);
		Thread t1 = new Thread(randomSum);
		Thread t2 = new Thread(randomSum);
		Thread t3 = new Thread(randomSum);
		Thread t4 = new Thread(randomSum);
		Thread t5 = new Thread(randomSum);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sum: " + randomSum.getSum());

		}

}
