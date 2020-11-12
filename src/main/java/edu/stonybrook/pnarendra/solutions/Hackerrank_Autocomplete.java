package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
	TrieNode[] children = new TrieNode[2];
	int prefix = -1;
	public TrieNode(int prefix){
		this.prefix = prefix;
	}
}
public class Hackerrank_Autocomplete {
	public static List<Integer> autoComplete(List<String> commands){
		TrieNode root = new TrieNode(-1);
		ArrayList<Integer> output = new ArrayList();
		int index = 1,res = 0;
		for(String com : commands){
			TrieNode node = root;

			for(char c : com.toCharArray()){
				if(null == node.children[c - '0']){
					node.children[c - '0'] = new TrieNode(index);
					node = node.children[c - '0'];
					continue;
				}
				
				res = node.children[c - '0'].prefix;
				node.children[c - '0'].prefix = index;
				node = node.children[c - '0'];	
			}
			
			output.add(res);
			res = index++;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		
	}

}
