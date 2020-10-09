package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	boolean stop = false;

	public List<String> wordBreak(String s, List<String> wordDict) {
		TrieNode root = new TrieNode(' ');
		root.characterList = new HashMap<Character, TrieNode>();
		// Prepare Trie Structure for fast lookup
		for (String word : wordDict) {
			TrieNode iter = root;
			for (char a : word.toCharArray()) {
				// TrieNode temp = iter.characterList.getOrDefault(a, new TrieNode(a));
				iter.characterList.putIfAbsent(a, new TrieNode(a));
				iter = iter.characterList.get(a);
				if (iter.characterList == null) {
					iter.characterList = new HashMap<Character, TrieNode>();
				}
			}
			iter.isEnd = true;
			iter.word = word;
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
		}else {
			TrieNode iter = root;
			int index = startIndex;
			while (index < terminationIndex && iter != null && !stop) {
				char temp = s.charAt(index);
				if (!iter.characterList.containsKey(temp)) {
					break;
				} else {
					TrieNode n = iter.characterList.get(temp);
					if (n == null) {
						iter = n;
						break;
					} else if (n.isEnd && n.characterList != null) {
						int len2 = sb.length();
						sb.append(n.word);
						sb.append(' ');
						explore(root, sb, answer, s, index + 1, terminationIndex);
						sb.setLength(len2);
						// n.isEnd = false;
						iter = n;
						index++;

					} else {
						iter = n;
						index++;
					}

				}
			}
			return;
		}

	}

//	public void explore(String s, StringBuilder sb, List<String> wordDict,List<String> answer) {
//	if(s.length()==0) {
//		sb.setLength(sb.length() - 1);
//		answer.add(sb.toString());
//		return;
//	}else {
//		int sbLength = sb.length();
//		int len = sb.length();
//		int len2 = s.length();
//		for(int i = 1; i<= len2;i++) {
//			if(wordDict.contains(s.substring(0, i))){
//				sb.append(s.substring(0, i));
//				sb.append(" ");
//				explore(s.substring(i, len2),sb,wordDict,answer);
//				sb.setLength(len);
//			}
//		}
//	}
//}

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");

//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		List<String> wordDict = new ArrayList<String>();
//		wordDict.add("a");
//		wordDict.add("aa");
//		wordDict.add("aaa");
//		wordDict.add("aaaa");
//		wordDict.add("aaaaa");
//		wordDict.add("aaaaaa");
//		wordDict.add("aaaaaaa");
//		wordDict.add("aaaaaaaa");
//		wordDict.add("aaaaaaaaa");
		new WordBreak2().wordBreak(s, wordDict);
	}

}
