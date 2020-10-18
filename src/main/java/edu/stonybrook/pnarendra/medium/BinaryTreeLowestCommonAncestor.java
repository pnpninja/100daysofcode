package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeLowestCommonAncestor {
	

	TreeNode found;
	public TreeNode lowestCommonAncestor(TreeNode root, 
			TreeNode p, TreeNode q) {
		found = null;
		lcaHelper(root,p,q);
		return found;
        
    }
	
	private TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		}else if(root.left == null && root.right == null) {
			if(root == p || root == q) {
				return root;
			}else {
				return null;
			}
		}else {
			TreeNode l = lcaHelper(root.left,p,q);
			TreeNode r = lcaHelper(root.right,p,q);
			if(l == null && r == null) {
				if(root == p || root == q){
                    return root;
                }else{
                    return null;
                }
			}else if(l != null && r == null) {
				if(l == p && root == q) {
					found = root;
					return null;
				}else if(l == q && root == p) {
					found = root;
					return null;
				}else {
					return l;
				}
			}else if(l == null && r != null) {
				if(r == p && root == q) {
					found = root;
					return null;
				}else if(r == q && root == p) {
					found = root;
					return null;
				}else {
					return r;
				}
			}else {
				found = root;
                return null;
			}
		}
	}
	
	
	

}
