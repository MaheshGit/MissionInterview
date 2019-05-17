package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

	/**
	 * https://leetcode.com/problems/unique-binary-search-trees-ii/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<TreeNode> a = generateTrees(3);
		for (int i = 0; i < a.size(); i++)  
        {  
            preorder(a.get(i));  
            System.out.println(); 
        }  
	}

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int rootValue = start; rootValue <= end; rootValue++) {
			List<TreeNode> leftSubTrees = generateTrees(start, rootValue - 1);
			List<TreeNode> rightSubTrees = generateTrees(rootValue + 1, end);

			for (TreeNode leftSubTree : leftSubTrees) {
				for (TreeNode rightSubTree : rightSubTrees) {
					TreeNode root = new TreeNode(rootValue);
					root.left = leftSubTree;
					root.right = rightSubTree;
					trees.add(root);
				}
			}
		}
		return trees;
	}

	static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

}
