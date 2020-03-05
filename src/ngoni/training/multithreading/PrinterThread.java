package ngoni.training.multithreading;

public class PrinterThread extends Thread {

	String name;
	
	public PrinterThread( String name) {
		this.name = name;
	}
	
	
	public void run() {
		System.out.println("Starting Thread " + name);
		try {
			for(int i = 0; i < 10000; i++) {
				System.out.println("Thread " + name + "iterated " + i + "times");
				Thread.sleep(100);
			}
		}catch (Exception e) {
			System.out.println("There was a massive error. Exiting thread " + name);
			e.printStackTrace();
		}
		System.out.println("Ending Thread" + name);
	}
	
	@Override
	public void interrupt() {
		System.out.println("Thread " + name + " interrupted.");
		super.interrupt();
	}
	
}
