package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class ConvertBSTToDoublyLinkedList {
	 TreeNode first;
     TreeNode last;
	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) return null;

	    helper(root);
	    // close DLL
	    last.right = first;
	    first.left = last;
	    return first;
    }
	
	public void helper(TreeNode root) {
		if(root != null) {
			helper(root.left);
			if(last != null) {
				last.right = root;
				root.left = last;
			}else {
				first = root;
			}
			last = root;
			helper(root.right);
		}
	}
}
