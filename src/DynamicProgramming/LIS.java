package DynamicProgramming;

import java.util.Arrays;

public class LIS {

	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(a));
		System.out.println(lengthOfLISUsingBinarySearch(a));
	}

	/**
	 * TC : O(n^2)
	 * SC : O(n)
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int maxLen = 1;

		int[] dp = new int[len];
		Arrays.fill(dp, 1);

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
	
	/**
	 * TC : O(nlogn)
	 * SC : O(n)
	 * @param nums
	 * @return
	 */
	public static int lengthOfLISUsingBinarySearch(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
	}

}
