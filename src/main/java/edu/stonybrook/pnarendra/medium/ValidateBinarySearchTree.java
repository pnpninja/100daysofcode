package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 98
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
	List<TreeNode> preOrder;
	
	public boolean isValidBST(TreeNode root) {
       preOrder = new ArrayList<TreeNode>();
       preOrderTraversal(root);
       for(int i = 1; i < preOrder.size(); i++) {
    	   if(preOrder.get(i).val < preOrder.get(i - 1).val) {
    		   return false;
    	   }
       }
       return true;
       
    }
	
	private void preOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}else {
			preOrderTraversal(root.left);
			preOrder.add(root);
			preOrderTraversal(root.right);
		}
	}
	

	
	
	

}
