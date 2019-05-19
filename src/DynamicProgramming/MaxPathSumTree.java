package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

import DynamicProgramming.UniqueBinarySearchTrees2.TreeNode;

public class MaxPathSumTree {
	static int maxSum;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        } else if( root.left == null && root.right == null){
            return root.data;
        }          
    
        ArrayList<Integer> list = mspHelper(root);
        return(list.get(1));    
    }
    
    public ArrayList<Integer> mspHelper(TreeNode root){
        if(root == null){
            return new ArrayList<Integer>(Arrays.asList(0,0));
        } 
        
        ArrayList<Integer> leftMaxSumList = mspHelper(root.left);
        int leftMaxSumAsBranch = leftMaxSumList.get(0);
        int leftMaxSumAsPath = leftMaxSumList.get(1);
        
        ArrayList<Integer> rightMaxSumList = mspHelper(root.right);
        int rightMaxSumAsBranch = rightMaxSumList.get(0);
        int rigthMaxSumAsPath = rightMaxSumList.get(1);
        
        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch,rightMaxSumAsBranch);
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + root.data, root.data);
        
        int maxSumWithRoot = Math.max(maxSumAsBranch,leftMaxSumAsBranch + rightMaxSumAsBranch + root.data);
        
        int maxPathSum = Math.max(leftMaxSumAsPath,Math.max(rigthMaxSumAsPath,maxSumWithRoot));
        return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch,maxPathSum));    
    }
    
    public static int maxPathSum2(TreeNode root) {
    	maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }
    
    public static int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxSum = Math.max(maxSum, left + right + node.data);
        return Math.max(left, right) + node.data;
    }


}
