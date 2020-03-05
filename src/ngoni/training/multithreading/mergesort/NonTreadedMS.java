package ngoni.training.multithreading.mergesort;

import java.util.Date;

/*
 * Implementation of a Merge sort nothing exciting to see here. 
 */


public class NonTreadedMS {
	
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
	
	public static void main(String[] args) {

		int[] definedNums = {22785};
		NonTreadedMS mergesort = new NonTreadedMS();
		long starttime = System.currentTimeMillis();
		//System.out.println(mergesort.mergesort(definedNums));
		for (int i : mergesort.mergesort(definedNums)) {
			System.out.println(i);	
		}
		int totaltime= (int) (System.currentTimeMillis()- starttime);
		System.out.println("completed in " +  totaltime + "ms");
	}
	
}
