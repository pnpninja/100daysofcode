package edu.stonybrook.pnarendra.medium;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class PathSumIII {
	
	int possibilities;
	public int pathSum(TreeNode root, int sum) {
        possibilities = 0;
        traverseWrapper(root,sum);
        return possibilities;
		
		
    }
	
	private void traverseWrapper(TreeNode root, int sum) {
		if(root == null) {
			return;
		}else {
			traverse(root,0,sum);
			traverseWrapper(root.left,sum);
			traverseWrapper(root.right,sum);
			
		}
	}
	
	
	private void traverse(TreeNode root, int sumSoFar, int sum) {
		if(root == null) {
			return;
		}else if(root.left == null && root.right == null) {
			if(sumSoFar + root.val == sum) {
				possibilities++;
			}
			return;
		}else {
			if(sumSoFar + root.val == sum) {
				possibilities++;
			}
			traverse(root.left,sumSoFar+root.val,sum);
			traverse(root.right,sumSoFar+root.val,sum);
			
		}
	}
	
	
	

}
