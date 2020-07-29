package edu.stonybrook.pnarendra.treealgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class TreeTraversal {
	
	List<Integer> preorder;
	List<Integer> postorder;
	List<Integer> inorder;
	
	public List<Integer> iterativePreorder(TreeNode root){
		List<Integer> preorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			preorder.add(temp.val);
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}			
		}
		return preorder;
	}
	
	public List<Integer> iterativePostorder(TreeNode root){
		List<Integer> postorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.right != null) {
			stack.push(root.right);
		}
		stack.push(root);
		root = root.left;
		while(!stack.isEmpty()) {
			if(root != null) {
				if(root.right != null) {
					stack.push(root.right);
				}
				stack.push(root);
				root = root.left;
			}else {
				TreeNode top = stack.pop();
				if(stack.isEmpty()) {
					postorder.add(top.val);
				}else if(top.right == stack.peek()) {
						TreeNode temp = stack.pop();
						stack.push(top);
						root = temp;
				}else {
					postorder.add(top.val);
				}
			}
		}
		return postorder;
	}
	
	public List<Integer> iterativeInorder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> inorder = new ArrayList<Integer>();
		stack.push(root);
		root = root.left;
		while(!stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}else {
				TreeNode temp = stack.pop();
				inorder.add(temp.val);
				root = temp.right;
				if(root != null) {
					stack.push(root);
					root = root.left;
				}
			}
		}
		return inorder;
	}

	public List<Integer> recursivePreorder(TreeNode root){
		this.preorder = new ArrayList<Integer>();
		recursivePreorderHelper(root);
		return this.preorder;
	}
	
	private void recursivePreorderHelper(TreeNode root) {
		if(root != null) {
			this.preorder.add(root.val);
			recursivePreorderHelper(root.left);
			recursivePreorderHelper(root.right);
		}else {
			return;
		}
	}
	
	public List<Integer> recursivePostorder(TreeNode root){
		this.postorder = new ArrayList<Integer>();
		recursivePostorderHelper(root);
		return this.postorder;
	}
	
	private void recursivePostorderHelper(TreeNode root) {

		if(root != null) {		
			recursivePostorderHelper(root.left);
			recursivePostorderHelper(root.right);
			this.postorder.add(root.val);
		}else {
			return;
		}
	}
	
	public List<Integer> recursiveInorder(TreeNode root){
		this.inorder = new ArrayList<Integer>();
		recursiveInorderHelper(root);
		return this.inorder;
	}
	
	private void recursiveInorderHelper(TreeNode root) {
		if(root != null) {		
			recursiveInorderHelper(root.left);
			this.inorder.add(root.val);
			recursiveInorderHelper(root.right);
		}else {
			return;
		}
	}
	

}
