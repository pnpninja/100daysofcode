package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class DeleteNodeInBST {
	TreeNode parentOfNodeToBeDeleted;
	TreeNode nodeToBeDeleted;
	TreeNode successor;
	TreeNode successorParent;
	public TreeNode deleteNode(TreeNode root, int key) {
        //Find The Node and the parent of the node
		if(root == null) {
			return root;
		}
		if(root.val == key) {
			successor = root.right;
			if(successor == null) {
				root = root.left;
				return root;
			}else {
				if(successor.left == null) {
					successor.left = root.left;
					return successor;
				}else {
					TreeNode parentSuccessor = null;
					while(successor.left != null) {
						parentSuccessor = successor;
						successor = successor.left;
					}
					successor.right = root.right;
					successor.left = root.left;
					parentSuccessor.left = null;
					return successor;
				}
			}
		}
		findNodeToBeDeleted(root,key);
		if(nodeToBeDeleted == null) {
			return root;
		}
		findSuccessor(nodeToBeDeleted);
		if(successor == null) {
			//There is no successor.
			//Make the parent point to 
			if(parentOfNodeToBeDeleted.left == nodeToBeDeleted) {
				parentOfNodeToBeDeleted.left = nodeToBeDeleted.left;
			}else {
				parentOfNodeToBeDeleted.right = nodeToBeDeleted.left;
			}
		}else if(nodeToBeDeleted == successorParent) {
			successor.left = nodeToBeDeleted.left;
			if(parentOfNodeToBeDeleted.left == nodeToBeDeleted) {
				parentOfNodeToBeDeleted.left = successor;
			}else {
				parentOfNodeToBeDeleted.right = successor;
			}
		}else {
			successorParent.left = successor.right;
			successor.left = nodeToBeDeleted.left;
			successor.right = nodeToBeDeleted.right;
			if(parentOfNodeToBeDeleted.left == nodeToBeDeleted) {
				parentOfNodeToBeDeleted.left = successor;
			}else {
				parentOfNodeToBeDeleted.right = successor;
			}
		}
		return root;
		
    }
	
	public void findNodeToBeDeleted(TreeNode root, int key) {
		if(root == null) {
			return;
		}else {
			if(root.left != null && root.left.val == key) {
				parentOfNodeToBeDeleted = root;
				nodeToBeDeleted = root.left;
				return;
			}else if(root.right != null && root.right.val == key) {
				parentOfNodeToBeDeleted = root;
				nodeToBeDeleted = root.right;
				return;
			}else {
				findNodeToBeDeleted(root.left, key);
				findNodeToBeDeleted(root.right, key);
			}
		}
	}
	
	public void findSuccessor(TreeNode root) {
		successorParent = root;
		successor = root.right;
		if(successor == null) {
			return;
		}
		while(successor.left != null) {
			successorParent = successor;
			successor = successor.left;
		}
	}
}
