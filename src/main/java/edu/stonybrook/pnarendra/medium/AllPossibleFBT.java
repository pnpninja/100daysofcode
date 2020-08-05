package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stonybrook.pnarendra.data_structures.TreeNode;

// 894
// https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleFBT {
	
	Map<Integer, List<TreeNode>> memo = new HashMap<Integer,  List<TreeNode>>();
	public List<TreeNode> allPossibleFBT(int N) {
        if(N % 2 == 0) {
        	return new ArrayList<TreeNode>();
        }else if(N == 1) {
        	List<TreeNode> tempList = new ArrayList<TreeNode>();
        	tempList.add(new TreeNode(0));
        	return tempList;
        }else {
        	List<TreeNode> tempList = new ArrayList<TreeNode>();
        	for(int i = 1; i <= N - 2; i+=2) {
        		List<TreeNode> leftTrees = memo.containsKey(i) ? memo.get(i): allPossibleFBT(i);
        		List<TreeNode> rightTrees =  memo.containsKey(N - 1 - i) ? memo.get(N - 1 - i) : allPossibleFBT(N - 1 - i);
        		for(TreeNode leftTree : leftTrees) {
        			for(TreeNode rightTree : rightTrees) {
        				TreeNode temp = new TreeNode(0);
        				temp.left = leftTree;
        				temp.right = rightTree;
        				tempList.add(temp);
        			}
        		}
        	}
        	memo.put(N, tempList);
        	return tempList;
        }
    }
}
