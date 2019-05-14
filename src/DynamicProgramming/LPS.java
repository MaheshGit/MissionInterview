package DynamicProgramming;

public class LPS {

	/**
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 * @param args
	 */
	public static void main(String[] args) {
          String s1 = "babad";
          String s2 = "cbbd";
          
          System.out.println(lps(s1));
          System.out.println(lps(s2));
	}
	
	/**
	 * Expend around center 
	 * TC :: O(n^2)
	 * @param s
	 * @return
	 */
	public static String lps(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);	
	}
	
	public static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
	
	// TODO :: Manacher's Algorithm :::: TC O(n)

}
