package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BuildTreeFromInOrderAndPreOrder {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0) {
			return null;
		}
        return buildTreeHelper(preorder,inorder,0,preorder.length - 1, 0,inorder.length - 1);
    }
	
	public TreeNode buildTreeHelper(int[] preorder, int inorder[], 
			int preorderStart, int preorderEnd,
			int inorderStart, int inorderEnd) {
		if(inorderStart == inorderEnd) {
			return new TreeNode(inorder[inorderStart]);
		}else {
			int rootNum = preorder[preorderStart];
			int loc = -1;
			for(int i = inorderStart;i <= inorderEnd; i++) {
				if(inorder[i] == rootNum) {
					loc = i;
					break;
				}
			}
			//root.left == null
			if(loc == inorderStart) {
				TreeNode root = new TreeNode(rootNum);
				root.left = null;
				root.right = buildTreeHelper(preorder,inorder,
						preorderStart+1,preorderEnd,inorderStart+1,inorderEnd);
				return root;
			//root.right == null;
			}else if(loc == inorderEnd) {
				TreeNode root = new TreeNode(rootNum);
				root.right = null;
				root.left = buildTreeHelper(preorder,inorder,
						preorderStart+1,preorderEnd,inorderStart,inorderEnd -1);
				return root;
			}else {
				int nosOnLeft = loc - inorderStart;
				TreeNode root = new TreeNode(rootNum);
				root.left = buildTreeHelper(preorder,inorder,
						preorderStart + 1, preorderStart + nosOnLeft, inorderStart,loc - 1);
				root.right = buildTreeHelper(preorder,inorder,
						preorderStart + nosOnLeft + 1, preorderEnd, loc + 1,inorderEnd);
				return root;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] preorder = {1,2};
		int[] inorder = {2,1};
		new BuildTreeFromInOrderAndPreOrder().buildTree(preorder, inorder);
	}

}
