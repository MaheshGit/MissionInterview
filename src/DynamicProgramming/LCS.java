package DynamicProgramming;

public class LCS {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "ABCDGHLQR";
		String str2 = "AEDPHR";
		System.out.println(lcs(str1, str2));
	}

	public static int lcs(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int[][] dp = new int[c1.length + 1][c2.length + 1];
		for (int i = 1; i <= c1.length ; i++) {
			for (int j = 1; j <= c2.length ; j++) {
				if (c1[i-1] == c2[j-1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[c1.length][c2.length ];
	}

}
