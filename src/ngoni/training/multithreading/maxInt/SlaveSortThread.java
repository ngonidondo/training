package ngoni.training.multithreading.maxInt;

import java.util.List;

public class SlaveSortThread  implements Runnable{

	protected int[] numbers;
	protected int maxNumber;
	private boolean isAlive;
	
	public SlaveSortThread(int[] numbers) {
		this.numbers = new int[numbers.length];
		this.numbers = numbers;
	}
	
	public SlaveSortThread() {}

	public void run() {
		isAlive=true;
		sortNumbers();
		isAlive=false;
	}
	
	protected void sortNumbers() {
		maxNumber=numbers[0];
		for(int i=0; i < numbers.length; i++) {
			if(numbers[i] > maxNumber) {
				maxNumber=numbers[i];
			}
		}
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	};
}
