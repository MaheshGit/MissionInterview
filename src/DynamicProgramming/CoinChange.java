package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

	/**
	 * 
	 * https://leetcode.com/problems/coin-change/
	 * Min Coin Problem ::: coins [1 2 5] Amount ::11 Answer::3[5 5 1] 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println(coinChange(coins,amount));

	}
	
	/**
	 * Bottom- Up DP approach
	 * Time Complexity ::O(AC)
	 * Space COmplexity ::O(A)
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0] = 0;
		int numCoins = coins.length;
		
		for(int i = 1; i <= amount; i++) {
			for(int j = 0; j < numCoins; j++) {
				if(coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

}
