package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	class MyObject{
		TreeNode node;
		int level;
		
		public MyObject(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	Map<Integer, List<MyObject>> map;
	public List<List<Integer>> verticalOrder(TreeNode root) {
		map = new TreeMap<Integer, List<MyObject>>();
		verticalOrderHelper(root, 0, 0);
		for(Integer key : map.keySet()) {
			Collections.sort(map.get(key), (a,b) -> a.level - b.level);
		}
		List<List<Integer>> answers = new ArrayList<List<Integer>>();
		for(int k : map.keySet()) {
			List<Integer> temp2 = new ArrayList<Integer>();
        	for(MyObject temp : map.get(k)) {
        		temp2.add(temp.node.val);
        	}
        	answers.add(temp2);
        }
		return answers;
    }
	
	private void verticalOrderHelper(TreeNode root, int combine, int level) {
		if(root == null) {
			return;
		}else {
			List<MyObject> temp = map.getOrDefault(combine, new ArrayList<MyObject>());
			temp.add(new MyObject(root, level));
			map.put(combine, temp);
			verticalOrderHelper(root.left, combine - 1, level + 1);
			verticalOrderHelper(root.right, combine + 1, level + 1);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> gg = new BinaryTreeVerticalOrderTraversal().verticalOrder(root);
		System.out.println("Hellp");
	}
}
