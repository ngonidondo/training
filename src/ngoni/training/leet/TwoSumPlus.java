package ngoni.training.leet;

import java.util.Arrays;

public class TwoSumPlus {

	/*
	 * Complexity/Space analysis
	 *This one O(nlogn)
	 * mergesort nlogn time
	 * binary search logn run n time nlogn
	 * get the indicies n time.
	 * 
	 * 
	 * There is a solution that can be completed in O(n) time.
	 * If you ever forget about this see if you can figure it out.
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
		
		int[] result = new int[2];
		if(nums == null || nums.length == 0) {
			return result;
		}
		int[] sortedNums = mergesort(nums);
		//binary
		Integer firstNum = null;
		Integer otherNum = null;
		for(int i=0; i < sortedNums.length; i++) {
			otherNum = target - sortedNums[i];
			if(binarySearch(sortedNums, otherNum)) {
				firstNum = sortedNums[i];
				break;
			}
		}
		
		if(firstNum != null) {
			result[0] = -1;
			result[1] = -1;
			for(int i=0; i < nums.length; i++) {
				if(nums[i] == firstNum && result[0] == -1) {
					result[0] = i;
				}
				if(nums[i] == otherNum && i!=result[0]) {
					result[1] = i;
				}
				if( result[0] != -1 && result[1] != -1) {
					break;
				}
			}
		}
		// if found get the index of both values. n time max
		
		return result;
    }
	
	public boolean binarySearch(int[] searchList, int searchVal) {
		if(searchList.length == 0) {
			return false;
		}
		if(searchList.length == 1  && searchList[0] != searchVal) {
			return false;
		}
		if(searchList[0] == searchVal) {
			return true;
		}
		
		int[] sublist1 = new int[searchList.length/2];
		int[] sublist2 = new int[searchList.length/2 + searchList.length % 2];
		
		for(int i=0; i < searchList.length/2; i++) {
			sublist1[i] = searchList[i];
		}
		for(int i=searchList.length/2; i < searchList.length; i++) {
			sublist2[i-searchList.length/2] = searchList[i];
		}
		
		
		if(sublist2.length > 0 && searchVal >= sublist2[0]) {
			return binarySearch(sublist2, searchVal);
		}else {
			return binarySearch(sublist1, searchVal);
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
	
    public static void main(String[] args){
    		TwoSumPlus sln = new TwoSumPlus();
        
        int[] nums= {2, 7, 11, 15, 4, 10,6};
        System.out.println(Arrays.toString(sln.twoSum(nums, 16)));
        
    }
	
	
}
