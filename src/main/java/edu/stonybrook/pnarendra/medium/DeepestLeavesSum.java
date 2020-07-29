package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1302
// https://leetcode.com/problems/deepest-leaves-sum/

public class DeepestLeavesSum {
	int sum;
	int depth;
	public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        depth = 0;
        deepestLeavesSumHelper(root,0);
        return sum;
    }
	
	private void deepestLeavesSumHelper(TreeNode root, int curDepth) {
		if(root == null) {
			return;
		}else if(root.left == null && root.right == null) {
			if(curDepth == depth) {
				sum += root.val;
			}else if(curDepth > depth) {
				sum = root.val;
				depth = curDepth;
			}else {
				
			}
		}else {
			deepestLeavesSumHelper(root.left, curDepth + 1);
			deepestLeavesSumHelper(root.right, curDepth + 1);
		}
	}
	
}
