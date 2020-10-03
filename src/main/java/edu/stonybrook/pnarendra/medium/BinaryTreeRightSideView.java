package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeRightSideView {

	int level;
	List<Integer> rightView;
	public List<Integer> rightSideView(TreeNode root) {
        this.level = 0;
        this.rightView = new ArrayList<Integer>();
        traverse(root,1);
        return this.rightView;
        
    }
	
	private void traverse(TreeNode root, int level) {
		if(root == null) {
			return;
		}else {
			if(level > this.level) {
				this.rightView.add(root.val);
				this.level = level;
			}
			traverse(root.right,level+1);
			traverse(root.left,level+1);
		}
	}

}
