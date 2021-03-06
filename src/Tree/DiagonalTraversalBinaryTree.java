package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class DiagonalTraversalBinaryTree {

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
		 * Diagonal Traversal ::: 1 3 2 5 4
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
		diagonalTraversal(root);
		System.out.println();		
	}
	
	
	/**
	 * While moving right order will be 0 and in left order will be +1
	 * @param root
	 */
	private static void diagonalTraversal(TreeNode root) {
		if (root == null)
			return;
		else {
			TreeMap<Integer, LinkedList<TreeNode>> map = new TreeMap<Integer, LinkedList<TreeNode>>();
			Queue<TreeNode> q1 = new LinkedList<TreeNode>();
			Queue<Integer> q2 = new LinkedList<Integer>();
			q1.offer(root);
			q2.offer(0);
			while (!q1.isEmpty()) {
				TreeNode temp = q1.poll();
				int order = q2.poll();
				LinkedList<TreeNode> list = null;

				if (map.containsKey(order)) {
					list = map.get(order);
				} else {
					list = new LinkedList<TreeNode>();
				}
				list.add(temp);
				map.put(order, list);

				if (temp.getLeft() != null) {
					q1.offer(temp.getLeft());
					// order is +1 as we are moving left
					q2.offer(order + 1);
				}

				if (temp.getRight() != null) {
					q1.offer(temp.getRight());
					// order is same as we are moving right
					q2.offer(order);
				}
			}

			Set<Entry<Integer, LinkedList<TreeNode>>> entries = map.entrySet();
			for (Map.Entry<Integer, LinkedList<TreeNode>> entry : entries) {
				System.out.print("Order " + entry.getKey() + " :::");
				LinkedList<TreeNode> list = entry.getValue();
				for (TreeNode node : list) {
					System.out.print(node.getData() + " ");
				}
				System.out.println();
			}

			// Time COmplexity : O(nlog(n))
			// Space Complexity : O(n)
		}
	}


}
