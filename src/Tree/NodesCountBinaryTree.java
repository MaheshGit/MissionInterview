package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodesCountBinaryTree {

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
		 * Vertical Order Traversal 4 2 1 5 3
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
		System.out.println("Node count is :::::"+ getNodesCountInBinaryTreeRecursive(root));
		System.out.println("Node count is :::::"+ getNodesCountInBinaryTreeIterative(root));
	}
	
    public static int getNodesCountInBinaryTreeRecursive(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            int countl = getNodesCountInBinaryTreeRecursive(root.getLeft());
            int countr = getNodesCountInBinaryTreeRecursive(root.getRight());
            return countl + countr + 1;
        }
    }
    
	public static int getNodesCountInBinaryTreeIterative(TreeNode root) {
		int nodeCount = 0;
		if (root == null)
			return nodeCount;
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
					q.poll();
					nodeCount++;
				}
			}
		}
		return nodeCount;
	}

}
