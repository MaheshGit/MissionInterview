package Tree;

public class LCA {

	public static void main(String[] args) {
		/*
		 * Tree : 1 
		 *       / \ 
		 *      2  3 
		 *     /\   /\
		 *    4  5  6 7
		 *    /\
		 *    8 9
		 * Nodes when K = 2 and Target Node = 2::: 8 9 3
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
		right1.setLeft(new TreeNode(6));
		right1.setRight(new TreeNode(7));
		left1_left.setLeft(new TreeNode(8));
		left1_left.setRight(new TreeNode(9));
		//printLCA();
		System.out.println();

	}

}
