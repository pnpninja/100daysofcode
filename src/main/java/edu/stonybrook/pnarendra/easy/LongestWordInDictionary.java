package edu.stonybrook.pnarendra.easy;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
	char ch;
	Map<Character, TrieNode> children;
	String word;
	boolean isEnd;
	
	public TrieNode(char ch) {
		this.ch = ch;
		this.children = new HashMap<>();
		this.word = "";
		this.isEnd = false;
	}
}
public class LongestWordInDictionary {
	
	TrieNode root = new TrieNode('\0');
	String answer = "";
	public String longestWord(String[] words) {
        //Process Word
		for(String word : words) {
			addWord(root,word);
		}
		bfs(root);
		return answer;
		
		
		
    }
	
	private void addWord(TrieNode root, String word) {
		TrieNode iter = root;
		for(char c : word.toCharArray()) {
			iter.children.putIfAbsent(c, new TrieNode(c));
			iter = iter.children.get(c);
		}
		iter.isEnd = true;
		iter.word = word;
	}
	
	private void bfs(TrieNode root) {
		if(root == null) {
			return;
		}else {
			if(root == this.root) {
				for(TrieNode node : root.children.values()) {
					bfs(node);
				}
				return;
			}else {
				if(root.isEnd) {
					for(TrieNode node : root.children.values()) {
						bfs(node);
					}
					if(root.word.length() > this.answer.length() || root.word.compareTo(answer) < 0) {
						this.answer = root.word;
					}
					return;
										
				}else {
					return;
				}
			}
		}
	}
}
