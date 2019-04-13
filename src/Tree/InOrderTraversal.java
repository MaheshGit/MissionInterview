package Tree;

import java.util.Stack;

public class InOrderTraversal {
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
		inOrderRecursively(root);
		System.out.println();
		inOrderIterativeTraversal(root);
	}

	public static void inOrderRecursively(TreeNode root) {
		if (root == null)
			return;
		if (root.getLeft() != null)
			inOrderRecursively(root.getLeft());
		System.out.print(root.getData() + ", ");
		if (root.getRight() != null)
			inOrderRecursively(root.getRight());
	}

	public static void inOrderIterativeTraversal(TreeNode root) {

		if (root == null)
			return;
		else {
			Stack<TreeNode> s = new Stack<TreeNode>();
			while (root != null || !s.isEmpty()) {
				if (root != null) {
					s.push(root);
					root = root.getLeft();
				} else {
					root = s.pop();
					System.out.print(root.getData() + ", ");
					root = root.getRight();
				}
			}
		}
	}


}
