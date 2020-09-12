package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeBoundary {
	List<Integer> answer;
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        this.answer = new ArrayList<Integer>();
        if(root == null) {
        	return this.answer;
        }
        
        if(root.left == null && root.right == null){
            this.answer.add(root.val);
            return this.answer;
        }
        if(root.left == null) {
        	this.answer.add(root.val);
        }else {
        	this.getLeftElements(root);
        	this.answer.remove(this.answer.size() - 1);
        }
        this.getBottomElements(root);
        if(root.right != null) {
        	this.answer.remove(this.answer.size() - 1);
        	this.getRightElements(root);
        	this.answer.remove(this.answer.size() - 1);
        }
        return answer;
    }
	
	public void getLeftElements(TreeNode root) {
		if(root != null) {
			this.answer.add(root.val);
			if(root.left != null) {
				getLeftElements(root.left);
			}else {
				getLeftElements(root.right);
			}
		}
	}
	
	public void getRightElements(TreeNode root) {
		if(root != null) {
			if(root.right != null) {
				getRightElements(root.right);
			}else {
				getRightElements(root.left);
			}
			this.answer.add(root.val);
		}
	}
	
	public void getBottomElements(TreeNode root) {
		if(root != null) {
			if(root.left == null && root.right == null) {
				this.answer.add(root.val);
			}else {
				getBottomElements(root.left);
				getBottomElements(root.right);
			}
		}
	}
}
