package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;
// 1038
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
public class BSTToGST {
	int num = 0;
	
	private void bstToGstHelper(TreeNode root) {
		if(root == null) {
			return;
		}else if(root.left == null && root.right == null) {
			if(num == 0) {
				num = root.val;
			}else {
				root.val = root.val + num;
				num = root.val;
			}
		}else {
			bstToGstHelper(root.right);
			root.val = root.val + num;
			num = root.val;
			bstToGstHelper(root.left);
			
		}
	}
	
	public TreeNode bstToGst(TreeNode root) {
		int num = 0;
		bstToGstHelper(root);
		return root;
        
    }

}
