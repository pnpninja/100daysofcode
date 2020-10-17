package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

public class BinaryTreeAllNodesDistanceK {
	int distance;
	List<Integer> answer;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.distance = K;
        this.answer = new ArrayList<Integer>();
        dfs(root,target,K);
        return this.answer;
        
    }
	
	public int dfs(TreeNode root, TreeNode target, int K) {
		if(root == null) {
			return -1;
		}else if(root == target) {
			addToAnswer(root,0);
			return 0;
		}else {
			int left = dfs(root.left,target,K);
			int right = dfs(root.left,target,K);
			if(left !=-1) {
				if(left == K) this.answer.add(root.val);
				addToAnswer(root.right, left + 1);
				return left + 1;
			}else if(right != -1) {
				if(right == K) this.answer.add(root.val);
				addToAnswer(root.left, right + 1);
				return right + 1;
			}else {
				return -1;
			}
		}
	}
	
	public void addToAnswer(TreeNode root, int curDistance) {
		if(root == null) {
			return;
		}else if(curDistance == this.distance) {
			this.answer.add(root.val);
			return;
		}else {
			addToAnswer(root.left,curDistance + 1);
			addToAnswer(root.right,curDistance + 1);			
		}
	}

}
