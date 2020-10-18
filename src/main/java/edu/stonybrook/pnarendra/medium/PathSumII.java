package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class PathSumII {
	
	List<List<Integer>> answers;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        answers = new ArrayList<List<Integer>>();
        explore(root,sum,0,new ArrayList<Integer>());
        return answers;
    }
	
	public void explore(TreeNode root, int sum, int sumSoFar, List<Integer> elements) {
		if(root == null) {
			return;
		}else if(root.left == null && root.right == null) {
			if(sumSoFar + root.val == sum) {
				elements.add(root.val);
				answers.add(new ArrayList<Integer>(elements));
                elements.remove(elements.size() - 1);
			}
			return;
		}else {
			elements.add(root.val);
			sumSoFar+=root.val;
			explore(root.left,sum,sumSoFar,elements);
			explore(root.right,sum,sumSoFar,elements);
            elements.remove(elements.size() - 1);
			
		}
	}

}
