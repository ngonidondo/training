package ngoni.training.leet;

public class MedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//Assuming nums1 is the smaller list. modify this so its the truth.
		//also assuming no repeating vals
		int totalSize= nums1.length + nums2.length;
		int i= nums1.length /2 + nums1.length % 2;
		int j= totalSize/2 - i;
		
		if(nums1[i - 1]  < nums2[j] && nums2[j-1] < nums1[i]) {
			//final case.
		}else if(nums1[i - 1]  >= nums2[j]) {
			
		}else if(nums2[j-1] >= nums1[i]) {
			
		}
		
		
		double ret = 0;
		return  ret;
	}
	
	//flawed intrinsically
	/*
	 * You have a few issues here. but you were thinking along the right lines. 
	 * You need to extrapolate on the concept of what you are trying to do
	 * So in this case taking the property of a median and attemping to find a correllation between
	 * the medians and 2 lists.
	 * I assumed their was a correlation  between the medians of two lists. This was wrong.
	 * but the way that you are comparing the medians is similar to the solution. I think you need to keep extrapolating in this manner.
	 */
	public double oldfindMedianSortedArrays(int[] nums1, int[] nums2) {
		double med1 = (nums1.length % 2 == 0)? Double.valueOf((nums1[nums1.length/2] + nums1[nums1.length/2 -1]))/2 : nums1[nums1.length/2];
		double med2 = (nums2.length % 2 == 0)? Double.valueOf((nums2[nums2.length/2] + nums2[nums2.length/2 -1]))/2 : nums2[nums2.length/2];
			
		if(med1 == med2) {
			return med1;
		}
		
		/* 
		 * 1,3,5,7 2,4,6,8
		 * 4 < 5
		 * 3,5,7 2,4,6
		 * 5 > 4
		 * 5,7 2,4
		 * 6 > 3
		 * if(max l2 < min l1)
		 * 	l1 12 joined median
		 * same opposite way.
		 * otherwise go one level deepers
		 */
		boolean finalStep = false;
		if(nums1.length <= 2 && nums2.length <= 2  ) {
			if(nums1[0] > nums2[nums2.length -1]) {
				int[] nums3 = new int[nums1.length + nums2.length];
				//TODO join the lists get the median
			} else if(nums2[0] > nums1[nums1.length -1]) {
				int[] nums3 = new int[nums1.length + nums2.length];
				//TODO join the lists get the median
			}
			finalStep = true;
		}
		
		int[] sublist1 = new int[nums1.length/2 + nums1.length % 2];
		int[] sublist2 = new int[nums2.length/2 + nums2.length % 2];
		
		if(med1 > med2) {
			if(nums1.length > 2 || (finalStep && nums1.length > 1) ) {
				for(int i=0; i < sublist1.length; i++) {
					sublist1[i] = nums1[i];
				}
			}else {
				sublist1=nums1;
			}
			if(nums1.length > 2 || (finalStep && nums1.length > 1) ) {
				for(int i=0; i < sublist2.length; i++) {
					sublist2[i] = nums2[i + nums2.length/2];
				}
			}else {
				sublist2=nums2;
			}
		} else {
			if(nums1.length > 2 || (finalStep && nums1.length > 1) ) {
				for(int i=0; i < sublist1.length; i++) {
					sublist1[i] = nums1[i + nums1.length/2];
				}
			}else {
				sublist1=nums1;
			}
			if(nums1.length > 2 || (finalStep && nums1.length > 1) ) {
				for(int i=0; i < sublist2.length; i++) {
					sublist2[i] = nums2[i];
				}
			}else {
				sublist2=nums2;
			}
		}
		
		return findMedianSortedArrays(sublist1, sublist2);
	}
	
	public double oldFindMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] sorted = mergeLists(nums1, nums2);
		double retVal = (sorted.length % 2 == 0)? Double.valueOf((sorted[sorted.length/2] + sorted[sorted.length/2 -1]))/2 : sorted[sorted.length/2];
		return retVal;
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
		MedianSortedArrays m = new MedianSortedArrays();
		 int[] nums= {2, 7, 11, 1000};
		 int[] nums2= { 4,6,8, 30};
		 System.out.println(m.oldFindMedianSortedArrays(nums, nums2));
	}
	
	/*
	 * 2,7,11,1000 4,6,8,30
	 * 9 > 7
	 * median or above must not be discarded. lesser 
	 * median or below must not be discarded. greater
	 * 2,7,11 6,8,30
	 * 7 < 8
	 * 2,7 8,30 if 4 0r less this is pointless
	 * 4.5 < 19
	 * 
	 * 1,3,5,7 2,4,6,8
	 * 4 < 5
	 * 3,5,7 2,4,6
	 * 5 > 4
	 * 5,7 2,4
	 * 6 > 3
	 * if(max l2 < min l1)
	 * 	l1 12 joined median
	 * same opposite way.
	 * otherwise go one level deepers
	 */
	
}
