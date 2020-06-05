package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1379
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class GetTargetCopy {
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if(original == null) {
			return null;
		}else if(original == target) {
			return cloned;
		}else {
			TreeNode left = getTargetCopy(original.left,cloned.left,target);
			TreeNode right = getTargetCopy(original.right,cloned.right,target);
			if(left == null && right != null) {
				return right;
			}else if(left != null && right == null) {
				return left;
			}else {
				return null;
			}
		}
   }
}
