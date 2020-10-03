package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class DistributeCoinsInABinaryTree {
	int answer;
    public int distributeCoins(TreeNode root) {
        this.answer = 0;
        imbalanceNumber(root);
        return this.answer;
    }
    
    private int imbalanceNumber(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}else {
    		int leftImbalance = imbalanceNumber(root.left);
    		int rightImbalance = imbalanceNumber(root.right);
    		this.answer+=Math.abs(leftImbalance)+Math.abs(rightImbalance);
    		return root.val + leftImbalance + rightImbalance - 1;
    	}
    }
}
