package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1305
// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class AddElementsInTwoBST {
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		List<Integer> answer = new ArrayList<Integer>();
		while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
			while(root1 != null) {
				stack1.add(root1);
				root1 = root1.left;
			}
			while(root2 != null) {
				stack2.add(root2);
				root2 = root2.left;
			}
			
			if(!stack1.isEmpty() && !stack2.isEmpty()) {
				if(stack1.peek().val < stack2.peek().val) {
					TreeNode temp = stack1.pop();
					answer.add(temp.val);
					root1 = temp.right;
				}else {
					TreeNode temp = stack2.pop();
					answer.add(temp.val);
					root2 = temp.right;
				}
			}else if(stack1.isEmpty()) {
				TreeNode temp = stack2.pop();
				answer.add(temp.val);
				root2 = temp.right;
			}else {
				TreeNode temp = stack1.pop();
				answer.add(temp.val);
				root1 = temp.right;
			}
		}
		return answer;
       
    }
	
	
	

}
