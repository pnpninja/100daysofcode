package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BuildTreeFromPreOrderAndPostOrder {
	
	private List<Integer> createList(int[] array){
		List<Integer> temp = new ArrayList<Integer>();
		for(int t : array) {
			temp.add(t);
		}
		return temp;
	}
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        List<Integer> preorder = createList(pre), postorder = createList(post);
        return buildTree(preorder, postorder);
    }
	
	private TreeNode buildTree(List<Integer> preorder, List<Integer> postorder) {
		if(preorder == null || preorder.size() == 0) {
			return null;
		}else if(preorder.size() == 1) {
			return new TreeNode(preorder.get(0));
		}else {
			//Create root
			TreeNode root = new TreeNode(preorder.get(0));
			//Get location of left root in postorder
			int leftRootLoc = getLeftRootLoc(postorder, preorder.get(1));
			root.left = buildTree(preorder.subList(1, leftRootLoc + 2), postorder.subList(0, leftRootLoc + 1));
			root.right = buildTree(preorder.subList(leftRootLoc + 2, preorder.size()), postorder.subList(leftRootLoc + 1, postorder.size() - 1));
			return root;
			
		}
	}
	
	private int getLeftRootLoc(List<Integer> postorder, int leftRoot) {
		for(int i = 0; i < postorder.size(); i++) {
			if(postorder.get(i) == leftRoot) {
				return i;
			}
		}
		return -1;
	}
	
	
	

}
