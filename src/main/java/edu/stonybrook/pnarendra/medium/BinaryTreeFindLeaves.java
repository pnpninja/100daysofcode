package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeFindLeaves {
	
	Map<Integer,List<Integer>> depthNodes;
	int maxHeight = 0;
 	public List<List<Integer>> findLeaves(TreeNode root) {
        this.depthNodes = new HashMap<Integer, List<Integer>>();
        this.maxHeight = 0;
        getHeight(root);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i = 1; i <= maxHeight; i++) {
        	answer.add(this.depthNodes.get(i));
        }
        return answer;
    }
 	
 	private int getHeight(TreeNode root) {
 		if(root == null) {
 			return 0;
 		}else {
 			int leftHeight = getHeight(root.left);
 			int rightHeight = getHeight(root.right);
 			int curHeight = Math.max(leftHeight, rightHeight) + 1;
 			this.maxHeight = Math.max(this.maxHeight, curHeight);
 			List<Integer> depthNodeList = this.depthNodes.getOrDefault(curHeight, new ArrayList<Integer>());
 			depthNodeList.add(root.val);
 			this.depthNodes.put(curHeight, depthNodeList);
 			return curHeight;
 		}
 	}	

}
