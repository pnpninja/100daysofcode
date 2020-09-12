package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 572
// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
	
	private boolean isEqual(TreeNode s, TreeNode t) {
		if(s == null && t == null) {
			return true;
		}
		
		if(s == null || t == null) {
			return false;
		}
		
		return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
	}
	
	private boolean traverse(TreeNode s, TreeNode t) {
		return s!= null && (isEqual(s,t) || traverse(s.left, t) || traverse(s.right, t));
	}
}
