package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinarySearchTreeIterator {
	
	TreeNode treeRoot;
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        this.treeRoot = root;
        this.stack = new Stack<TreeNode>();
        while(this.treeRoot!=null){
            this.stack.push(this.treeRoot);
            this.treeRoot = this.treeRoot.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode temp = this.stack.pop();
        TreeNode temp2 = temp.right;
        if(temp2!= null){
            while(temp2 != null){
                this.stack.push(temp2);
                temp2 = temp2.left;
            }
        }
        return temp.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

}
