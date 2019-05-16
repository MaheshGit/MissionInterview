package DynamicProgramming;

import java.util.Arrays;

public class WaysToDecode {

	/**
	 * https://leetcode.com/problems/decode-ways/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "12";
		System.out.println(numDecodings(s));
		System.out.println(numDecodingsUsingDP(s));
		System.out.println(numDecodingsDP_Optimized(s));
	}

	/**
	 * Decoding using recursive ways TC ::: O(n) SC ::: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
		int[] cache = new int[s.length() + 1];
		Arrays.fill(cache, -1);
		return helper(s, s.length(), cache);
	}

	public static int helper(String s, int k, int[] cache) {
		// Base case 1
		if (k == 0)
			return 1;

		// Base case 2
		int index = s.length() - k;
		if (s.charAt(index) == '0')
			return 0;

		// if found cached value return it
		if (cache[k] != -1)
			return cache[k];

		// First Way
		int ways = helper(s, k - 1, cache);

		// Second way
		if (k >= 2 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			ways += helper(s, k - 2, cache);
		}

		cache[k] = ways;
		return ways;
	}

	/**
	 * Decoding using DP TC ::: O(n) SC ::: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodingsUsingDP(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	/**
	 * Decoding using DP TC ::: O(n) SC ::: O(1)
	 * 
	 * @param s
	 * @return
	 */
	public static int numDecodingsDP_Optimized(String s) {
		int n = s.length();
		if (n == 0 || s.charAt(0) == '0')
			return 0;

		int a = 1;
		int b = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				a = b;
				b = 0;
			} else {
				if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
					int c = b;
					b = a + b;
					a = c;
				} else {
					a = b;
				}
			}
		}

		return b;
	}
}
