package DynamicProgramming;

public class UniqueWaysCoinChange {

	/**
	 * https://leetcode.com/problems/coin-change-2/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		System.out.println(getUniqueWays(amount, coins));
		System.out.println(getUniqueWays2(amount, coins));
	}

	/**
	 * Time Complexity ::O(CA) Space Complexity :: O(CA)
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int getUniqueWays(int amount, int[] coins) {
		int numberOfCoins = coins.length;
		int[][] dp = new int[numberOfCoins + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= numberOfCoins; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				int withoutThisCoin = dp[i - 1][j];
				int withThisCoin = coins[i - 1] <= j ? dp[i][j - coins[i - 1]] : 0;
				dp[i][j] = withoutThisCoin + withThisCoin;
			}
		}

		return dp[numberOfCoins][amount];
	}
	
	/**
	 * Time Complexity ::O(CA) Space Complexity :: O(A)
	 * 
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int getUniqueWays2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
	}
}
