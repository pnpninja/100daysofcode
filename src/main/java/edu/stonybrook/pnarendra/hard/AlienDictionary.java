package edu.stonybrook.pnarendra.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	public String alienOrder(String[] words) {
		int[] indegree = new int[26];
		Map<Character, Set<Character>> graph = new HashMap<>();
		buildGraph(graph,indegree,words);
		return bfs(graph,indegree);
		
	}
	
	public String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
		StringBuilder sb = new StringBuilder();
		int nosChars = graph.size();
		Queue<Character> queue = new LinkedList<Character>();
		for(Character c : graph.keySet()) {
			if(indegree[c-'a'] == 0 && graph.get(c).size()!=0) {
				sb.append(c);
				queue.add(c);
			}
		}
		
		while(!queue.isEmpty()) {
			char s = queue.poll();
			if(graph.get(s) == null || graph.get(s).size() == 0) continue;
			for(Character next : graph.get(s)) {
				indegree[next - 'a']--;
				if(indegree[next - 'a'] == 0) {
					sb.append(next);
					queue.add(next);
				}
			}
		}
		return sb.length() == nosChars ? sb.toString() : "";
	}
	
	public void buildGraph(Map<Character, Set<Character>> graph, int[] indegree, String[] words) {
		for(String word : words) {
			for(char c : word.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<Character>());
			}
		}
		
		for(int i = 0; i < words.length - 1; i++) {
			String first = words[i];
			String second = words[i + 1];
			int len = Math.min(first.length(), second.length());
			for(int pos = 0; pos < len; pos++) {
				if(first.charAt(pos) != second.charAt(pos)) {
					char out = first.charAt(pos);
					char in = second.charAt(pos);
						
					if(!graph.get(out).contains(in)) {
						graph.get(out).add(in);
						indegree[in - 'a']++;
					}
					break;
				}
				if (pos + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
			}
		}
	}
}

