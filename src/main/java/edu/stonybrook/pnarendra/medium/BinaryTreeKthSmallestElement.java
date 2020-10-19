package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeKthSmallestElement {
	
	int answer;
	int iter;
	public int kthSmallest(TreeNode root, int k) {
        answer = 0;
        iter = 0;
        inorder(root,k);
        return answer;
    }
	
	private void inorder(TreeNode root, int k) {
		if(root == null) {
			return;
		}else {
			inorder(root.left,k);
			iter++;
			if(iter == k) {
				answer = root.val;
				return;
			}else {
				inorder(root.right,k);
			}
		}
	}
	
	

}
