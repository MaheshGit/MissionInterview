package Tree;

import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {

		/*
		 * Tree : 1 
		 *       / \ 
		 *      2  3 
		 *     /\ 
		 *    4  5
		 * 
		 * Pre Order Traversal : 1 2 4 5 3 Post Order Traversal : 4 5 2 3 1 In Order
		 * Traversal : 4 2 5 1 3 Level Order Traversal : 1 2 3 4 5
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
		right1.setRight(left1_right);
		preOrderRecursively(root);
		System.out.println();
		preOrderIterativeTraversal(root);
	}

	public static void preOrderRecursively(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + ", ");
		if (root.getLeft() != null)
			preOrderRecursively(root.getLeft());
		if (root.getRight() != null)
			preOrderRecursively(root.getRight());
	}

	public static void preOrderIterativeTraversal(TreeNode root) {

		if (root == null)
			return;
		else {
			Stack<TreeNode> s = new Stack<TreeNode>();
			while (root != null || !s.isEmpty()) {
				if (root != null) {
					System.out.print(root.getData() + ", ");
					s.push(root);
					root = root.getLeft();
				} else {
					root = s.pop();
					root = root.getRight();
				}
			}
		}
	}

}
