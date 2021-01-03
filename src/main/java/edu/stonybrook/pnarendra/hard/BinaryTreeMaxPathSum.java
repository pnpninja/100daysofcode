package edu.stonybrook.pnarendra.hard;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

class AnswerNode {
	int val;
	int leftSum;
	int rightSum;
	
}
public class BinaryTreeMaxPathSum {
	int maxPathSum;
	
	public int maxPathSum(TreeNode root) {
		this.maxPathSum = Integer.MIN_VALUE;
        getData(root);
        return this.maxPathSum;
        
    }
	
	private int getData(TreeNode root) {
		if (root == null) return 0;

	    // max sum on the left and right sub-trees of node
	    int left_gain = Math.max(getData(root.left), 0);
	    int right_gain = Math.max(getData(root.right), 0);

	    // the price to start a new path where `node` is a highest node
	    int price_newpath = root.val + left_gain + right_gain;

	    // update max_sum if it's better to start a new path
	    maxPathSum = Math.max(maxPathSum, price_newpath);

	    // for recursion :
	    // return the max gain if continue the same path
	    return root.val + Math.max(left_gain, right_gain);
	}

}
