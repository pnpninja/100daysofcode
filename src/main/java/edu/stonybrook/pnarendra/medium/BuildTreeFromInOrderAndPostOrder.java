package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BuildTreeFromInOrderAndPostOrder {
	private List<Integer> createList(int[] array){
		List<Integer> temp = new ArrayList<Integer>();
		for(int t : array) {
			temp.add(t);
		}
		return temp;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = createList(inorder), 
        		postorderList = createList(postorder);
        return buildTree(inorderList, postorderList);
        
        
    }
	
	
	private TreeNode buildTree(List<Integer> inorderList, List<Integer> postorderList) {
		if(postorderList.size() == 0) {
			return null;
		}else if(postorderList.size() == 1) {
			return new TreeNode(postorderList.get(0));
		}else {
			//What is the root element?
			int root = postorderList.get(postorderList.size() - 1);
			
			//Find root element index in List
			int rootLoc = locateRootInInorder(inorderList, root);
			
			if(rootLoc == 0) {
				//Handle right skew
				TreeNode node = new TreeNode(root);
				node.left = null;
				node.right = buildTree(inorderList.subList(1, inorderList.size()), postorderList.subList(0, postorderList.size() -1 ));
				return node;
			}else if(rootLoc == inorderList.size() - 1) {
				//Handle left skew
				TreeNode node = new TreeNode(root);
				node.left = buildTree(inorderList.subList(0, inorderList.size() - 1), postorderList.subList(0, postorderList.size() -1 ));
				node.right = null;
				return node;
			}else {
				//Handle normal
				TreeNode node = new TreeNode(root);
				node.left = buildTree(inorderList.subList(0, rootLoc),postorderList.subList(0, rootLoc));
				node.right = buildTree(inorderList.subList(rootLoc + 1, inorderList.size()), postorderList.subList(rootLoc, postorderList.size() - 1));
				return node;
			}
			
			
			
			
			
		}
	}
	
	private int locateRootInInorder(List<Integer> inorderList, int root) {
		for(int i = 0; i < inorderList.size(); i++) {
			if(inorderList.get(i) == root) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		BuildTreeFromInOrderAndPostOrder x = new BuildTreeFromInOrderAndPostOrder();
		int[] inorder = new int[] {9,3,15,20,7};
		int[] postorder = new int[] {9,15,7,20,3};
		TreeNode gg = x.buildTree(inorder, postorder);
	}
	
}
