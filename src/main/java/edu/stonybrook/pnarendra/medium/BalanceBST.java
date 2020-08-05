package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1382
// https://leetcode.com/problems/balance-a-binary-search-tree/
public class BalanceBST {
	
	List<TreeNode> inOrderTraverser;
	
	public TreeNode balanceBST(TreeNode root) {
        this.inOrderTraverser = new ArrayList<TreeNode>();
        inOrder(root);
        TreeNode[] temp = new TreeNode[this.inOrderTraverser.size()];
        for(int i = 0; i < this.inOrderTraverser.size(); i ++) {
        	temp[i] = this.inOrderTraverser.get(i);
        }
        return buildTreeRecursive(temp, 0, temp.length - 1);
    }
	
	private void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}else {
			inOrder(root.left);
			this.inOrderTraverser.add(root);
			inOrder(root.right);
			
		}
	}
	
	private TreeNode buildTreeRecursive(TreeNode[] temp, int start, int end) {
		if(start == end) {
			temp[start].left = null;
			temp[start].right = null;
			return temp[start];
		}else if(start + 1 == end) {
			temp[start].left = null;
			temp[start].right = temp[end];
			temp[end].left = null;
			temp[end].right = null;		
			return temp[start];
		}else {
			int mid = (start + end) / 2;
			temp[mid].left = buildTreeRecursive(temp, start, mid - 1);
			temp[mid].right = buildTreeRecursive(temp, mid + 1, end);
			return temp[mid];
			
		}
	}

}
