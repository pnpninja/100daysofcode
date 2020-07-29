package edu.stonybrook.pnarendra.treealgorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class TreeAlgorithms {
	
	TreeNode root;
	TreeTraversal traverser;
	@Before
	public void init() {
		root = new TreeNode(10);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(16);
		root.right.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right = new TreeNode(17);
		traverser = new TreeTraversal();
		
	}
	
	@Test
	public void inorderTest() {
		assertTrue(traverser.recursiveInorder(root).equals(traverser.iterativeInorder(root)));
	}
	
	@Test
	public void preorderTest() {
		assertTrue(traverser.recursivePreorder(root).equals(traverser.iterativePreorder(root)));
	}
	
	@Test
	public void postorderTest() {
		assertTrue(traverser.recursivePostorder(root).equals(traverser.iterativePostorder(root)));
	}
	

}
