package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeInorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderTraverse(root, answer);
        return answer;
        
        
    }
	
	private void inorderTraverse(TreeNode root,List<Integer> answer) {
		if(root == null) {
			return;
		}
		
		inorderTraverse(root.left,answer);
		answer.add(root.val);
		inorderTraverse(root.right,answer);
	}

}
