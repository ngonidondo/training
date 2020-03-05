package ngoni.training.multithreading.mergesort;

public class HybridMS implements Runnable{
	
	int level;
	private int[] numberList;
	
	public HybridMS(int level, int[] unsortedList) {
		this.numberList = new int[unsortedList.length];
		this.numberList = unsortedList;
		this.level=level;
	}
	
	public void run() {
		// Creating 4 threads if the level is 0 otherwise performing normal merging
		if(level == 0) {
			level++;
			//lists of size 1 are already sorted
			if(numberList != null && numberList.length == 1)
				return;
			
			//creating sublists to mergesort
			int[] sublist1 = new int[numberList.length/2];
			int[] sublist2 = new int[numberList.length/2 + numberList.length % 2];
			
			for(int i=0; i < numberList.length/2; i++) {
				sublist1[i] = numberList[i];
			}
			for(int i=numberList.length/2; i < numberList.length; i++) {
				sublist2[i-numberList.length/2] = numberList[i];
			}
			
			//sorting the sublists
			HybridMS subRun1 = new HybridMS(level, sublist1);
			HybridMS subRun2 = new HybridMS(level, sublist2);
			Thread subProcess1 = new Thread(subRun1);
			Thread subProcess2 = new Thread(subRun2);
			
			subProcess1.start();
			subProcess2.start();
			
			try {
				subProcess1.join();
				subProcess2.join();
				
				numberList = mergeLists(subRun1.getNumberList(), subRun2.getNumberList());
			} catch (InterruptedException e) {
				System.out.println("We have failed");
			}
			
			
		} else {
			numberList = mergesort(numberList);
		}
	}
	
	public int[] mergesort(int[] unsortedList) {
		//lists of size 1 are already sorted
		if(unsortedList != null && unsortedList.length == 1)
			return unsortedList;
		
		//creating sublists to mergesort
		int[] sublist1 = new int[unsortedList.length/2];
		int[] sublist2 = new int[unsortedList.length/2 + unsortedList.length % 2];
		
		for(int i=0; i < unsortedList.length/2; i++) {
			sublist1[i] = unsortedList[i];
		}
		for(int i=unsortedList.length/2; i < unsortedList.length; i++) {
			sublist2[i-unsortedList.length/2] = unsortedList[i];
		}
		
		//sorting the sublists
		sublist1 = mergesort(sublist1);
		sublist2 = mergesort(sublist2);
		
		//now sorting the sorted lists
		
		return mergeLists(sublist1, sublist2);
	}
	
	public int[] mergeLists(int[] sublist1, int[] sublist2) {
		int[] result = new int[sublist1.length + sublist2.length];
		int sublist1Index = 0;
		int sublist2Index = 0;
		int resultIndex = 0;
		while(resultIndex < result.length) {
			if(sublist1Index >= sublist1.length){
				result[resultIndex] = sublist2[sublist2Index];
				sublist2Index++;
			}else if(sublist2Index >= sublist2.length) {
				result[resultIndex] = sublist1[sublist1Index];
				sublist1Index++;
			}else if(sublist1[sublist1Index] < sublist2[sublist2Index]) {
				result[resultIndex] = sublist1[sublist1Index];
				sublist1Index++;
			}else {
				result[resultIndex] = sublist2[sublist2Index];
				sublist2Index++;
			}
			resultIndex++;
		}
		return result;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int[] getNumberList() {
		return numberList;
	}

	public void setNumberList(int[] numberList) {
		this.numberList = numberList;
	}

	public static void main(String[] args) {
		int[] definedNums = {22};
		HybridMS hms = new HybridMS(0,definedNums);
		Thread mergesort = new Thread(hms);
		long starttime = System.currentTimeMillis();
		mergesort.run();
		for (int i : hms.getNumberList()) {
			System.out.println(i);	
		}
		int totaltime= (int) (System.currentTimeMillis()- starttime);
		System.out.println("completed in " +  totaltime + "ms");
	}
	
}
