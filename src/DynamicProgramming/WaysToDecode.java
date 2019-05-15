package DynamicProgramming;

import java.util.Arrays;

public class WaysToDecode {

	/**
	 * https://leetcode.com/problems/decode-ways/
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "230";
		System.out.println(numDecodings(s));
	}
	
    public static int numDecodings(String s) {
        int[] cache = new int[s.length() + 1]; 
        Arrays.fill(cache,-1);
        return helper(s,s.length(), cache);
    }
    
    public static int helper(String s, int k, int[] cache){
        // Base case 1
        if(k == 0) return 1;
        
        // Base case 2
        int index = s.length() - k;
        if(s.charAt(index) == '0') return 0;
        
        // if found cached value return it
        if(cache[k] != -1) return cache[k];
        
        // First Way
        int ways = helper(s, k-1, cache);
        
        // Second way
        if( k >= 2 && Integer.parseInt(s.substring(index,index+2)) <= 26){
            ways += helper(s, k-2, cache);
        }
        
        cache[k] = ways;
        return ways;
    }

}
