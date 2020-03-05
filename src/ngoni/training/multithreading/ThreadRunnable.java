package ngoni.training.multithreading;

public class ThreadRunnable implements Runnable{

	PrinterThread thread1;
	PrinterThread thread2;
	
	public void run() {
		thread1 = new PrinterThread("1");
		thread2 = new PrinterThread("2");
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread1.interrupt();
		System.out.println(thread1.isAlive());
		thread2.interrupt();
	}
	
}
