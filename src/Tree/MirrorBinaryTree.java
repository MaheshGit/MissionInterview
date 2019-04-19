package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinaryTree {

	public static void main(String[] args) {
		
		/*
		 * Tree : 1       Mirror Tree : 1
		 *       / \                   /\
		 *      2  3                  3  2
		 *     /\                        /\ 
		 *    4  5                      5  4
		 * 
		 * Observations :
		 * In Order Traversal Tree: 4 2 5 1 3 
		 * In Order Traversal Mirror Tree: 3 2 5 2 4
		 *  So in order traversal of both trees as reverse of each other 
		 *  
		 *  To convert tree to its mirror swap all left and right nodes
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
		InOrderTraversal.inOrderIterativeTraversal(root);
		System.out.println();
		//mirrorOfBinaryTreeRecursively(root);
		mirrorOfBinaryTreeIteratively(root);
		InOrderTraversal.inOrderIterativeTraversal(root);
		System.out.println();
	}
	
    public static void mirrorOfBinaryTreeRecursively(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        else
        {
        	mirrorOfBinaryTreeRecursively(root.getLeft());
        	mirrorOfBinaryTreeRecursively(root.getRight());
            TreeNode temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
    }
    
	public static void mirrorOfBinaryTreeIteratively(TreeNode root) {
		if (root == null)
			return;
		else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				TreeNode currentRoot = q.poll();
				TreeNode temp = currentRoot.getLeft();
				currentRoot.setLeft(currentRoot.getRight());
				currentRoot.setRight(temp);
				if (currentRoot.getLeft() != null)
					q.offer(currentRoot.getLeft());
				if (currentRoot.getRight() != null)
					q.offer(currentRoot.getRight());
			}
		}
	}
}
