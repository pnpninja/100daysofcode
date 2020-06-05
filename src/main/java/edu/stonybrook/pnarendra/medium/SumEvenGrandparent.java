package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1315
// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/submissions/
public class SumEvenGrandparent {
	int sum;
	public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        sumEvenGrandparentHelper(root);
        return sum;
    }
	
	private void sumEvenGrandparentHelper(TreeNode root) {
		if(root == null) {
			return;
		}else if(root.val%2 != 0){
			sumEvenGrandparentHelper(root.left);
			sumEvenGrandparentHelper(root.right);
		}else {
			goDepths(root, 0); 
			sumEvenGrandparentHelper(root.left);
			sumEvenGrandparentHelper(root.right);
		}
	}
	
	private void goDepths(TreeNode root, int depth) {
		if(root == null) {
			return;
		}else if(depth < 2) {
			goDepths(root.left,depth+1);
			goDepths(root.right,depth+1);
		}else {
			sum += root.val;
		}
	}
}
