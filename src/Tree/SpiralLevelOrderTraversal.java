package Tree;

import java.util.Stack;

public class SpiralLevelOrderTraversal {

	public static void main(String[] args) {
		/*
		 * Tree : 1 
		 *       / \ 
		 *      2  3 
		 *     /\ 
		 *    4  5
		 * 
		 * Pre Order Traversal : 1 2 4 5 3 
		 * Post Order Traversal : 4 5 2 3 1 
		 * In Order Traversal : 4 2 5 1 3 
		 * Level Order Traversal : 1 2 3 4 5
		 * Boundry Traversal ::: 1 2 4 5 3
		 * Spiral Level Order Traversal ::: 1 3 2 4 5
		 * 
		 */
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode left1_left = new TreeNode(4);
		TreeNode left1_right = new TreeNode(5);
		root.setLeft(left1);
		root.setRight(right1);
		left1.setLeft(left1_left);
		left1.setRight(left1_right);
		printSpiralLevelOrderTraversal(root);
	}

	private static void printSpiralLevelOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		else {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(root);
			
			while(!s1.isEmpty() || !s2.isEmpty()) {
				while(!s1.isEmpty()) {
					TreeNode node = s1.pop();
					System.out.print(node.getData() + " ");
					
					if(node.getLeft() != null) {
						s2.push(node.getLeft());
					}
					
					if(node.getRight() != null) {
						s2.push(node.getRight());
					}
				}
				
				while(!s2.isEmpty()) {
					TreeNode node = s2.pop();
					System.out.print(node.getData() + " ");
					
					if(node.getRight() != null) {
						s1.push(node.getRight());
					}
					
					if(node.getLeft() != null) {
						s1.push(node.getLeft());
					}
				}
			}
		}
		
	}
	
}
