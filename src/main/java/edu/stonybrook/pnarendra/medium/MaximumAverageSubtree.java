package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

class Data{
	public double sum;
	public int nosNodes;
	
	public Data() {
		this.sum = 0;
		this.nosNodes = 0;
	}
	
	public Data(int val) {
		this.sum = val;
		this.nosNodes = 1;
	}
	
	public Data(Data left, Data right, int val) {
		this.sum = left.sum + right.sum + val;
		this.nosNodes = left.nosNodes + right.nosNodes + 1;
	}
	
	public double getAvg() {
		if(this.nosNodes == 0) {
			return -1;
		}
		return this.sum/this.nosNodes;
	}
	
}

public class MaximumAverageSubtree {
	
	Data maxVal = null;
	public double maximumAverageSubtree(TreeNode root) {
        this.maxVal = new Data();
        helper(root);
        return this.maxVal.getAvg();
    }
	
	public Data helper(TreeNode root) {
		if(root == null) {
			return new Data();
		}else if(root.left == null && root.right == null) {
			Data temp = new Data(root.val);
			if(temp.getAvg() > this.maxVal.getAvg()) {
				this.maxVal = temp;
			}
			return temp;
		}else {
			Data left = helper(root.left);
			Data right = helper(root.right);
			Data full = new Data(left,right,root.val);
			double leftAvg = left.getAvg();
			double rightAvg = right.getAvg();
			double totalAvg = full.getAvg();
			if(totalAvg >= leftAvg && totalAvg >= rightAvg) {
				if(totalAvg >= this.maxVal.getAvg()) {
					this.maxVal = full;
				}
			}else if(leftAvg >= totalAvg && leftAvg >= rightAvg) {
				if(leftAvg >= this.maxVal.getAvg()) {
					this.maxVal = left;
				}
			}else {
				if(rightAvg >= this.maxVal.getAvg()) {
					this.maxVal = right;
				}
			}
			return full;
			
			
		}
	}
	
	public static void main(String[] args) {
		MaximumAverageSubtree t = new MaximumAverageSubtree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(6);
		root.right = new TreeNode(1);
		System.out.println(t.maximumAverageSubtree(root));
	}

}
