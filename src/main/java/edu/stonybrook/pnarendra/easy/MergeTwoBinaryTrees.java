package edu.stonybrook.pnarendra.easy;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class MergeTwoBinaryTrees {
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
        	return null;
        }else if(t1!= null && t2 == null) {
        	return t1;
        }else if(t1 == null && t2 != null) {
        	return t2;
        }else {
        	TreeNode temp = new TreeNode(t1.val+t2.val);
        	temp.left = mergeTrees(t1.left,t2.left);
        	temp.right = mergeTrees(t1.right,t2.right);
        	return temp;
        }
    }

}
