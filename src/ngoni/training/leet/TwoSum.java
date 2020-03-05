package ngoni.training.leet;

import java.util.Arrays;

public class TwoSum {

	/*
	 * Complexity/Space analysis
	 * 
	 * Time.
	 * twoSum() is running in O(n) + recurseSumCheck()
	 * recurseSumcheck runs in O(n-1) + recurseSumCheck()
	 * O(n-1) = O(n) and recurseSumCheck runs a max of n times.
	 * thus time complexity is O(n^2) + O(n) = O(n^2)
	 * 
	 * Similar argument can be made for space
	 * twoSum creates an n-1 var thus taking O(2n space)
	 * recurse sumcheck runs n times taking O(2n-1 space)
	 * thus O(n) space
	 * 
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		if(nums == null || nums.length == 0) {
			return result;
		}
		int[] newNums = new int[nums.length-1];
		for(int i =0; i < nums.length; i++) {
			if(i!= 0 ) {
				newNums[i-1] = nums[i];
			}
		}
        return recurseSumCheck(0, nums[0], newNums, target );
    }
	
	private int[] recurseSumCheck(int indx, int first, int[] nums, int target) {
		int[] result = new int[2];
		if(nums == null || nums.length == 0) {
			return result;
		}
		int[] newNums = new int[nums.length-1];
		for(int i =0; i < nums.length; i++) {
			if(first + nums[i] == target) {
				result[0] = indx;
				result[1] = indx + i + 1;
				return result;
			}
			if(i!= 0 ) {
				newNums[i-1] = nums[i];
			}
		}
		
		return recurseSumCheck(++indx, nums[0], newNums, target );
	}
	
    
    public static void main(String[] args){
    		TwoSum sln = new TwoSum();
        
        int[] nums= {2, 7, 11, 15, 4, 10,6};
        System.out.println(Arrays.toString(sln.twoSum(nums, 16)));
        
    }
	
	
}
