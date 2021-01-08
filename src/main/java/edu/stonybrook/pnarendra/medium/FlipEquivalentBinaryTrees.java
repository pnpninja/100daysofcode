package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class FlipEquivalentBinaryTrees {

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == root2) {
        	return true;
        }
        
        if(root1==null || root2 == null || root2.val != root1.val) {
        	return false;
        }
        
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
