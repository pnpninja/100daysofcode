package edu.stonybrook.pnarendra.medium;

import java.util.HashMap;
import java.util.Map;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeMaxLevelSum {
	Map<Integer, Integer> levelMap;
	int maxSum = Integer.MIN_VALUE;
	int maxLevel = -1;
	public int maxLevelSum(TreeNode root) {
		if(root == null) {
			return 1;
		}
        this.levelMap = new HashMap<Integer, Integer>();
        traverse(root,1);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = -1;
        for(int key : this.levelMap.keySet()) {
        	int temp = this.levelMap.get(key);
        	if(temp > maxSum) {
        		maxSum = temp;
        		maxLevel = key;
        	}
        }
        return maxLevel;
        
    }
	
	private void traverse(TreeNode root, int level) {
		if(root == null) {
			return;
		}else {
			this.levelMap.put(level, this.levelMap.getOrDefault(level, 0) + root.val);
			traverse(root.left,level + 1);
			traverse(root.right, level + 1);
		}
	}
}
