package edu.stonybrook.pnarendra.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import  edu.stonybrook.pnarendra.data_structures.TreeNode;

public class DeleteNodesAndReturnForest {
	
	List<TreeNode> roots;
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.roots = new ArrayList<TreeNode>();
        Set<Integer> toDel = new HashSet<Integer>();
        for(int i = 0; i < to_delete.length; i++) {
        	toDel.add(to_delete[i]);
        }
        processNode(root, toDel);
        if(toDel.contains(root.val)) {
        	addChildrenOfRoot(root);
        }else {
        	this.roots.add(root);
        }
        //this.roots.add(root);
        return this.roots;
        
        
    }
	
	private void processNode(TreeNode root, Set<Integer> toDel) {
		if(root == null) {
			return;
		}else {
			processNode(root.left, toDel);
			processNode(root.right, toDel);
			if(root.left != null && toDel.contains(root.left.val)) {
				TreeNode temp = root.left;
				addChildrenOfRoot(temp);
				root.left = null;
			}
			if(root.right != null && toDel.contains(root.right.val)) {
				TreeNode temp = root.right;
				addChildrenOfRoot(temp);
				root.right = null;
			}
		}
	}
	
	private void addChildrenOfRoot(TreeNode root) {
		if(root.left != null) {
			TreeNode temp = root.left;
			root.left = null;
			this.roots.add(temp);
		}
		
		if(root.right != null) {
			TreeNode temp = root.right;
			root.right = null;
			this.roots.add(temp);
		}
	}

}
