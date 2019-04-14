package Tree;

import java.util.Stack;

public class PostOrderTraversal {
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
		postOrderRecursively(root);
		System.out.println();
		postOrderIterativeTraversalUsingTwoStacks(root);
		System.out.println();
		postOrderIterativeTraversalUsingOneStack(root);
	}

	public static void postOrderRecursively(TreeNode root) {
		if (root == null)
			return;
		if (root.getLeft() != null)
			postOrderRecursively(root.getLeft());
		if (root.getRight() != null)
			postOrderRecursively(root.getRight());
		System.out.print(root.getData() + ", ");
	}

	/**
	 * 1.Use PreOrder Traversal but instead left traverse right first(Node->Right->Left)
	 * 2. Then reverse all elements and you will get post order traversal
	 * for above example --- Modified PreOrder will be 1 3 2 5 4
	 * and reverse of this will be post order traversal 4 5 2 3 1
	 * @param root
	 */
	public static void postOrderIterativeTraversalUsingTwoStacks(TreeNode root) {

		if (root == null)
			return;
		else {
			Stack<TreeNode> s = new Stack<TreeNode>();
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			while (root != null || !s.isEmpty()) {
				if (root != null) {
					s.push(root);
					s1.push(root);
					root = root.getRight();
				} else {
					root = s.pop();
					root = root.getLeft();
				}
			}
			
			while(!s1.isEmpty()) {
				System.out.print(s1.pop().getData() + ", ");
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 */
	public static void postOrderIterativeTraversalUsingOneStack(TreeNode root) {
		TreeNode currentNode = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (currentNode != null || !s.isEmpty()) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				TreeNode temp = s.peek().getRight();
				if (temp == null) {
					temp = s.pop();
					System.out.print(temp.getData() + ", ");
					while (!s.isEmpty() && s.peek().getRight() == temp) {
						temp = s.pop();
						System.out.print(temp.getData() + ", ");
					}
				} else {
					currentNode = temp;
				}
			}
		}
	}


}
