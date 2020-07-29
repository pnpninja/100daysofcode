package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 1008
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class BSTFromPreorder {
	public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder,0,preorder.length - 1);
    }
	
	private TreeNode bstFromPreorderHelper(int[] preorder, int start, int end) {
		if(start == end) {
			return new TreeNode(preorder[start]);
		}else{
			boolean beyondEnd = true;
			int nextHighestIndex = -1;
			for(int i = start + 1; i <= end; i++) {
				if(preorder[i] > preorder[start]) {
					beyondEnd = false;
					nextHighestIndex = i;
					break;
				}
			}
			if(beyondEnd) {
				TreeNode temp = new TreeNode(preorder[start]);
				temp.left = bstFromPreorderHelper(preorder, start + 1, end);
				return temp;
			}else {

				if(start + 1 == nextHighestIndex) {
					TreeNode temp = new TreeNode(preorder[start]);
					temp.right = bstFromPreorderHelper(preorder, nextHighestIndex, end);
					return temp;
				}else if(nextHighestIndex == end) {
					TreeNode temp = new TreeNode(preorder[start]);			
					temp.left = bstFromPreorderHelper(preorder, start + 1, nextHighestIndex - 1);
					temp.right = new TreeNode(preorder[nextHighestIndex]);
					return temp;
				}else {
					TreeNode temp = new TreeNode(preorder[start]);
					temp.left = bstFromPreorderHelper(preorder, start + 1, nextHighestIndex - 1);
					temp.right = bstFromPreorderHelper(preorder, nextHighestIndex, end);
					return temp;
				}
				
			}
		}
	}
}
