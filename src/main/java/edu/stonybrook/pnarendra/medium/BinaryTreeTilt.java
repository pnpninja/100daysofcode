package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeTilt {
	
	int tiltSum;
	public int findTilt(TreeNode root) {
		tiltSum = 0;
        findTiltHelper(root);
        return tiltSum;
    }
    
    private int findTiltHelper(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftSum = findTiltHelper(root.left);
            int rightSum = findTiltHelper(root.right);
            int temp = leftSum+rightSum+root.val;
            tiltSum+=Math.abs(leftSum - rightSum);
            return temp;
        }
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		new BinaryTreeTilt().findTilt(root);
	}

}
