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
		System.out.println(coinChangeTopDown(coins,amount));
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
	
	/**
	 * TopDown DP approach
	 * Time Complexity ::O(AC)
	 * Space COmplexity ::O(A)
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChangeTopDown(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinChangeTD(coins, amount, new int[amount + 1]);
	}
	
	public static int coinChangeTD(int[] coins, int remainder, int[] dp) {
		  
	    /*
	      Base Case 1: If remainder is less then 0 return -1
	    */
	    if (remainder < 0) {
	      return -1;
	    }
	  
	    /*
	      Base Case 2: If remainder is equls to 0 return 0
	    */
	    if (remainder == 0) {
	      return 0;
	    }

	    /**
	     * If we already have answer , return it
	     */
	    if (dp[remainder] != 0) {
	      return dp[remainder];
	    }

	    /*
	      No answer yet. Try each coin as the last coin in the change that
	      we make for the amount
	    */
	    int minimum = Integer.MAX_VALUE;
	    for (int coin : coins) {
	      int changeResult = coinChangeTD(coins, remainder - coin, dp);

	      /*
	        If making change was possible (changeResult >= 0) and 
	        the change result beats our present minimum, add one to
	        that smallest value
	        
	        We accept that coin as the last coin in our change making
	        sequence up to this point since it minimizes the coins we
	        need
	      */
	      if (changeResult >= 0 && changeResult < minimum) {
	        minimum = 1 + changeResult;
	      }
	    }

	    /*
	      If no answer is found (minimum == Integer.MAX_VALUE) then the
	      sub problem answer is just arbitrarily made to be -1, otherwise
	      the sub problem's answer is "minimum"
	    */
	    dp[remainder] = (minimum == Integer.MAX_VALUE) ? -1 : minimum;

	    // Return the sub problem's answer
	    return dp[remainder];
	  }


}
