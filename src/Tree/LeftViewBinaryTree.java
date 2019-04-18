package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

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
		 * Left View :: 1 2 4
		 * Right View ::: 1 3 5
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
		printLeftViewBinaryTree(root);
		System.out.println();

	}
	
	public static void printLeftViewBinaryTree(TreeNode root) {
		if (root == null)
			return;
		else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				int count = q.size();
				for (int i = 0; i < count; i++) {
					if (q.peek().getLeft() != null)
						q.offer(q.peek().getLeft());
					if (q.peek().getRight() != null)
						q.offer(q.peek().getRight());
					if(i == 0)
					System.out.print(q.poll().getData() + ", ");
					else
						q.poll();
				}
			}
		}
	}

}
