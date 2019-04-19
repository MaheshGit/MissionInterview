package Tree;

public class BoundaryTraversal {

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
		printBoundaryTraversal(root);

	}
	
	/**
	 * 1. Print left nodes expect leaf
	 * 2. Print leaf nodes
	 * 3. Print right nodes expect leaf
	 * @param root
	 */
	public static void printBoundaryTraversal(TreeNode root) {
		printLeftNodesExpectLeaf(root);
		printLeafNodes(root);
		// as root  is already traversed so moving to roots right
		printRightNodesExpectLeaf(root.getRight());
	}

	private static void printRightNodesExpectLeaf(TreeNode root) {
        if (root == null)
        {
            return;
        }
        else if ((root.getLeft() == null) && (root.getRight() == null))
        {
            return;
        }
        else
        {
            System.out.print(root.getData() + " ");
            printRightNodesExpectLeaf(root.getRight());
        }	
	}

	private static void printLeafNodes(TreeNode root) {
        if (root == null)
        {
            return;
        }
        else if ((root.getLeft() == null) && (root.getRight() == null))
        {
        	System.out.print(root.getData() + " ");
        }
        else
        {
            
        	printLeafNodes(root.getLeft());
        	printLeafNodes(root.getRight());
        }				
	}

	private static void printLeftNodesExpectLeaf(TreeNode root) {
        if (root == null)
        {
            return;
        }
        else if ((root.getLeft() == null) && (root.getRight() == null))
        {
            return;
        }
        else
        {
            System.out.print(root.getData() + " ");
            printLeftNodesExpectLeaf(root.getLeft());
        }
	}

}
