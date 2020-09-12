package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 285
// https://leetcode.com/problems/inorder-successor-in-bst/
public class InOrderSuccessor {
	List<TreeNode> inOrder;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder = new ArrayList<TreeNode>();
        inOrder(root);
        for(int i = 0; i < inOrder.size(); i++) {
        	TreeNode temp = inOrder.get(i);
        	if(temp == p) {
                if(i == inOrder.size() - 1){
                    return null;
                }else{
                    return inOrder.get(i + 1);
                }        		
        	}
        }
        return null;
        
    }
	
	
	void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}else {
			inOrder(root.left);
			inOrder.add(root);
			inOrder(root.right);
		}
	}
	

	
	

}
