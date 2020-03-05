package ngoni.training.multithreading.reverseHello;

public class ReverseHello extends Thread{

	private final int maxdepth = 50;
	private int currentDepth;
	
	public ReverseHello(int currentDepth) {
		this.currentDepth=currentDepth;
	}
	
	@Override
	public void run() {
		if(currentDepth <= maxdepth) {
			try {
				ReverseHello deeper = new ReverseHello(currentDepth + 1);
				deeper.start();
			
				deeper.join();
				System.out.println("Hello from thread number: " + currentDepth);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
	}

	public int getCurrentDepth() {
		return currentDepth;
	}

	public void setCurrentDepth(int currentDepth) {
		this.currentDepth = currentDepth;
	}
	
	public static void main(String[] args) {
		ReverseHello deep = new ReverseHello(0);
		deep.start();
	}
	
}
