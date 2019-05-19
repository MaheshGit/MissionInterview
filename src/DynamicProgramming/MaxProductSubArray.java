package DynamicProgramming;

public class MaxProductSubArray {

	/**
	 * https://leetcode.com/problems/maximum-product-subarray/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
          int[] a = {2,3,-2,4};
          System.out.println(maxProduct(a));
	}

	/**
	 * TC:::O(n)
	 * SC:::O(1)
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = nums[0];
		int maxSoFar = nums[0];
		int minSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int oldMaxSoFar = maxSoFar;
			maxSoFar = Math.max(minSoFar * nums[i], Math.max(nums[i], maxSoFar * nums[i]));
			minSoFar = Math.min(oldMaxSoFar * nums[i], Math.min(nums[i], minSoFar * nums[i]));
			result = Math.max(result, Math.max(maxSoFar, minSoFar));
		}
		return result;
	}

}
