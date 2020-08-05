package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1261
// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
public class FindElements {
	
	TreeNode root;
	
	public FindElements(TreeNode root) {
        //Decontaminate Tree
		this.root = root;
		if(this.root != null) {
			this.root.val = 0;
			decontaminateTree(root.left, 0, true);
			decontaminateTree(root.right, 0, false);
		}
		
    }
	
	private void decontaminateTree(TreeNode root, int parentNodeVal, boolean isLeft) {
		if(root == null) {
			return;
		}else {
			root.val = 2*parentNodeVal + (isLeft ? 1 : 2);
			decontaminateTree(root.left,root.val, true);
			decontaminateTree(root.right,root.val, false);
		}
	}
    
    public boolean find(int target) {
        return findHelper(target, this.root);
    }
    
    private boolean findHelper(int target, TreeNode root) {
    	if(root == null) {
    		return false;
    	}else {
    		if(root.val == target) {
    			return true;
    		}else {
    			boolean leftFound = findHelper(target,root.left);
    			boolean rightFound = findHelper(target,root.right);
    			return leftFound || rightFound;
    		}
    	}
    }


}
