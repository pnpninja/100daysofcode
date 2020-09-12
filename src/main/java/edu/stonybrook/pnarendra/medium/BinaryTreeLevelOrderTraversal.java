package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	
	int maxLevel;
	Map<Integer, List<Integer>> levelMap;
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        this.maxLevel = -1;
        this.levelMap = new HashMap<Integer, List<Integer>>();
        levelOrderTraversal(root,0);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i = 0; i <= maxLevel; i++) {
        	answer.add(this.levelMap.get(i));
        }
        return answer;
        
        
    }
	
	private void levelOrderTraversal(TreeNode root, int currentLevel) {
		if(root == null) {
			return;
		}else {
			List<Integer> valuesAtLevel = this.levelMap.getOrDefault(currentLevel, new ArrayList<Integer>());
			valuesAtLevel.add(root.val);
			this.levelMap.put(currentLevel, valuesAtLevel);
			if(this.maxLevel < currentLevel) {
				this.maxLevel = currentLevel;
			}
			levelOrderTraversal(root.left, currentLevel + 1);
			levelOrderTraversal(root.right, currentLevel + 1);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> ans = new BinaryTreeLevelOrderTraversal().levelOrder(null);
		System.out.println("Done");
	}

}
