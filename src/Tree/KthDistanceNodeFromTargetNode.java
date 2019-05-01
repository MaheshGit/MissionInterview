package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KthDistanceNodeFromTargetNode {

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
		printKthDistanceNodeFromTargetNode(root,left1,2);
		System.out.println();
	}

	private static void printKthDistanceNodeFromTargetNode(TreeNode root, TreeNode target, int k) {
        // Create hashmap to map each node with parent
        Map<TreeNode,TreeNode> npMap = new HashMap<TreeNode, TreeNode>();
        mapNodeToParent(npMap, root, null);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        
        Set<TreeNode> s = new HashSet<TreeNode>();
        s.add(target);
        
        int level = 0;
        
        while(!q.isEmpty()){
            
            if(level == k){
                while(!q.isEmpty()){
                	System.out.print(q.poll().getData() + ", ");
                }
            }
            
            int layerSize = q.size();
            
            for(int i = 0; i < layerSize; i++){
                TreeNode currentNode = q.poll();
                if(currentNode.getLeft() != null && !s.contains(currentNode.getLeft())){
                    q.offer(currentNode.getLeft());
                    s.add(currentNode.getLeft());
                }
                    
                if(currentNode.getRight() != null && !s.contains(currentNode.getRight())){
                    q.offer(currentNode.getRight());
                    s.add(currentNode.getRight());
                }
                
                TreeNode parent = npMap.get(currentNode);
                if(parent != null && !s.contains(parent)){
                    q.offer(parent);
                    s.add(parent);
                }
            }
            
            level++;
        }       
	}
	
    // method to map node to parent(DFS)
    private static void mapNodeToParent(Map<TreeNode,TreeNode> npMap, TreeNode root, TreeNode parent){
         if(root == null) return;
         npMap.put(root,parent);
         mapNodeToParent(npMap, root.getLeft(), root);
         mapNodeToParent(npMap, root.getRight(), root);
    }

}
