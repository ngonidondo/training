package ngoni.training.multithreading.mergesort;


/*
 * This actually proudced some intresting results. 
 * The intention here was to create a mergesort 
 * and also create a multithreaded mergesort and 
 * have them compete to see which was faster. The assumption
 * being that multithreading would be faster. It wasnt though
 * I forgot about the overhead produced with every thread that
 * I create. So while it was faster in theory in pratice it took
 * far more time than its counterpart.
 * 
 * This might be achievable by trying to do this with a max number of threads alive at a time
 * but thats a test for a later time.
 */

public class ThreadedMS extends Thread{
	
	private int[] numberList;
	
	public ThreadedMS(int[] unsortedList) {
		this.numberList = new int[unsortedList.length];
		this.numberList = unsortedList;
	}
	
	@Override
	public void run(){
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
		ThreadedMS subProcess1 = new ThreadedMS(sublist1);
		ThreadedMS subProcess2 = new ThreadedMS(sublist2);
		
		subProcess1.start();
		subProcess2.start();
		
		try {
			subProcess1.join();
			subProcess2.join();
			//now sorting the sorted lists			
			numberList = mergeLists(subProcess1.getNumberList(), subProcess2.getNumberList());
		}catch(Exception e) {
			System.out.println("Unable to mergesort at this time");
		}
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
	
	public static void main(String[] args) {
		int[] definedNums = {22};
		ThreadedMS mergesort = new ThreadedMS(definedNums);
		long starttime = System.currentTimeMillis();
		mergesort.run();
		for (int i : mergesort.getNumberList()) {
			System.out.println(i);	
		}
		int totaltime= (int) (System.currentTimeMillis()- starttime);
		System.out.println("completed in " +  totaltime + "ms");
	}

	public int[] getNumberList() {
		return numberList;
	}

	public void setNumberList(int[] numberList) {
		this.numberList = numberList;
	}
	
}
