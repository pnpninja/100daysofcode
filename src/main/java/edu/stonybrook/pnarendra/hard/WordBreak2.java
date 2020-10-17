package edu.stonybrook.pnarendra.hard;

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

public class WordBreak2 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		TrieNode root = new TrieNode(' ');
		root.characterList = new HashMap<Character, TrieNode>();
		Set<Integer> charSet = new HashSet<>();
		// Prepare Trie Structure for fast lookup
		for (String word : wordDict) {
			TrieNode iter = root;
			for (char a : word.toCharArray()) {
				charSet.add(a - 'a');
				// TrieNode temp = iter.characterList.getOrDefault(a, new TrieNode(a));
				if (iter.characterList == null) {
					iter.characterList = new HashMap<Character, TrieNode>();
				}
				iter.characterList.putIfAbsent(a, new TrieNode(a));
				iter = iter.characterList.get(a);
			}
			iter.isEnd = true;
			iter.word = word;
		}
		
		for(char t : s.toCharArray()) {
			if(!charSet.contains(t - 'a')) {
				return new ArrayList<>();
			}
		}

		List<String> answer = new ArrayList<String>();
		// explore(s,new StringBuilder(), wordDict,answer);
		int len = s.length();
		explore(root, new StringBuilder(), answer, s, 0, len);
		return answer;

	}

	public void explore(TrieNode root, StringBuilder sb, List<String> answer, String s, int startIndex,
			int terminationIndex) {
		int len = sb.length();
		if (startIndex == terminationIndex) {
			sb.setLength(len - 1);
			answer.add(sb.toString());
			return;
		} else {
			TrieNode iter = root;
			int index = startIndex;
			for (int i = startIndex; i < terminationIndex; i++) {
				if (iter == null) {
					break;
				} else if (iter.characterList == null || iter.characterList.isEmpty()) {
					break;
				} else if (iter.characterList.containsKey(s.charAt(i))) {
					iter = iter.characterList.get(s.charAt(i));
					if (iter.isEnd) {
						StringBuilder temp = new StringBuilder(sb);
						temp.append(iter.word + " ");
						explore(root, temp, answer, s, i + 1, terminationIndex);
					} else {
						continue;
					}
				} else {
					break;
				}
			}
			return;
		}

	}


	public static void main(String[] args) {
//		String s = "catsanddog";
//		List<String> wordDict = new ArrayList<String>();
//		wordDict.add("cat");
//		wordDict.add("cats");
//		wordDict.add("and");
//		wordDict.add("sand");
//		wordDict.add("dog");
//
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		new WordBreak2().wordBreak(s, wordDict);
	}

}
