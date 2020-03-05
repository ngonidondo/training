package ngoni.training.multithreading.maxInt;

import java.net.NetworkInterface;

public class MasterSortTread extends SlaveSortThread{

	private int[] masterNumbers;
	
	public MasterSortTread(int[] numbers) {
		super();
		masterNumbers = new int[numbers.length];
		masterNumbers = numbers;	
	}
	
	@Override
	public void run() {
		int numberArraySize = masterNumbers.length/4;
		int[] slave1Numbers = new int[numberArraySize];
		int[] slave2Numbers = new int[numberArraySize];
		int[] slave3Numbers = new int[numberArraySize];
		numbers = new int[numberArraySize+ masterNumbers.length%4];
		
		for (int i = 0; i < numberArraySize; i++) {
			slave1Numbers[i] = masterNumbers[i];
		}
		for (int i = numberArraySize; i < numberArraySize*2; i++) {
			slave2Numbers[i - numberArraySize] = masterNumbers[i];
		}
		for (int i = numberArraySize*2; i < numberArraySize*3; i++) {
			slave3Numbers[i - numberArraySize*2] = masterNumbers[i];
		}
		for (int i = numberArraySize*3; i < masterNumbers.length; i++) {
			numbers[i - numberArraySize*3] = masterNumbers[i];
		}
		SlaveSortThread slave1 = new SlaveSortThread(slave1Numbers);
		SlaveSortThread slave2 = new SlaveSortThread(slave2Numbers);
		SlaveSortThread slave3 = new SlaveSortThread(slave3Numbers);
		
		slave1.run();
		slave2.run();
		slave3.run();
		System.out.println("Starting sorting");
		this.sortNumbers();
		System.out.println("Done sorting");
		try {
			for(int i =0; i<2000; i++) {
				if(slave1.isAlive()) {
					Thread.sleep(500);
				}
			}
			for(int i =0; i<2000; i++) {
				if(slave2.isAlive()) {
					Thread.sleep(500);
				}
			}
			for(int i =0; i<2000; i++) {
				if(slave3.isAlive()) {
					Thread.sleep(500);
				}
			}
			if(slave1.getMaxNumber() > getMaxNumber()) {
				setMaxNumber(slave1.getMaxNumber());
			}
			if(slave2.getMaxNumber() > getMaxNumber()) {
				setMaxNumber(slave2.getMaxNumber());
			}
			if(slave3.getMaxNumber() > getMaxNumber()) {
				setMaxNumber(slave3.getMaxNumber());
			}
			System.out.println("The Max number is " + getMaxNumber());
		}catch (Exception e) {
			System.out.println("Error: Sort Failed");
		}
	}
	
	public static void main(String[] args) {
		int[] definedNums = {1,23,123,2,34,42,55,223,54,33,34,45,545,23,45,65,2,354,23,54,345,23}; 
		SlaveSortThread sorter = new MasterSortTread(definedNums);
		Thread t = new Thread(sorter);
		t.run();
	}

}
