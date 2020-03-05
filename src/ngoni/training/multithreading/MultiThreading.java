package ngoni.training.multithreading;

public class MultiThreading {

	// try using as little autocomplete as possible
	// This class is intended to be an exploration of using multiple threads in java
	
	public static void main(String[] args) {
		ThreadRunnable runnable = new ThreadRunnable();
		runnable.run();
	}
	
}
