package edu.stonybrook.pnarendra.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TrieNode {
	Character c;
	boolean isEnd;
	Map<Character, TrieNode> characterList;
	String word;

	public TrieNode(Character c) {
		this.c = c;
	}
}
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
//		TrieNode root = new TrieNode(' ');
//		root.characterList = new HashMap<Character, TrieNode>();
//		Set<Integer> charSet = new HashSet<>();
//		// Prepare Trie Structure for fast lookup
//		for (String word : wordDict) {
//			TrieNode iter = root;
//			for (char a : word.toCharArray()) {
//				charSet.add(a - 'a');
//				// TrieNode temp = iter.characterList.getOrDefault(a, new TrieNode(a));
//				if (iter.characterList == null) {
//					iter.characterList = new HashMap<Character, TrieNode>();
//				}
//				iter.characterList.putIfAbsent(a, new TrieNode(a));
//				iter = iter.characterList.get(a);
//			}
//			iter.isEnd = true;
//			iter.word = word;
//		}
//		
//		for(char t : s.toCharArray()) {
//			if(!charSet.contains(t - 'a')) {
//				return false;
//			}
//		}
//
//		List<String> answer = new ArrayList<String>();
//		// explore(s,new StringBuilder(), wordDict,answer);
//		int len = s.length();
//		return explore(root, s, 0, len);
		Set<String> words = new HashSet<String>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i<= s.length();i++) {
			for(int j = 0; j < i;j++) {
				dp[i] = dp[i] || (dp[j] && words.contains(s.substring(j, i)));
			}
		}
		return dp[s.length()];

	}

	public boolean explore(TrieNode root, String s, int startIndex,
			int terminationIndex) {
		if (startIndex == terminationIndex) {
			return true;
		} else {
			TrieNode iter = root;
			int index = startIndex;
			boolean ans = false;
			for (int i = startIndex; i < terminationIndex; i++) {
				if (iter == null) {
					break;
				} else if (iter.characterList == null || iter.characterList.isEmpty()) {
					break;
				} else if (iter.characterList.containsKey(s.charAt(i))) {
					iter = iter.characterList.get(s.charAt(i));
					if (iter.isEnd) {
						boolean f =  true && explore(root, s, i + 1, terminationIndex);
						f = f || ans;
					} else {
						continue;
					}
				} else {
					break;
				}
			}
			return ans;
		}

	}
	
	public static void main(String[] args) {
		Set<String> words = new HashSet<String>();
		words.add("a");
		words.add("aa");
		words.add("aaa");
		words.add("aaaa");
		words.add("aaaaa");
		words.add("aaaaaa");
		words.add("aaaaaaa");
		words.add("aaaaaaaa");
		words.add("aaaaaaaaa");
		words.add("aaaaaaaaaaa");
	}
}
