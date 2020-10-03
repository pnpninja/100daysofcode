package edu.stonybrook.pnarendra.medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SynonymousSentences {
	
	public static List<Set<String>> unionFind(List<List<String>> synonyms){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		Set<String> allWords = new HashSet<String>();
		Map<String, Boolean> addedInSomeSet = new HashMap<String, Boolean>();
		List<Set<String>> answers = new ArrayList<Set<String>>();
		for(List<String> input : synonyms) {
			List<String> ref =  map.getOrDefault(input.get(0), new ArrayList<String>());
			ref.add(input.get(1));
			map.put(input.get(0),ref);
			
			ref =  map.getOrDefault(input.get(1), new ArrayList<String>());
			ref.add(input.get(0));
			map.put(input.get(1),ref);
			allWords.add(input.get(0));
			allWords.add(input.get(1));
		}
		
		for(String word : allWords) {
			//Perform BFS
			if(!addedInSomeSet.getOrDefault(word, false)){
				Queue<String> t = new LinkedList<String>();
				Set<String> aa = new HashSet<String>();
				aa.add(word);
				addedInSomeSet.put(word, true);
				t.add(word);
				while(!t.isEmpty()) {
					String te = t.poll();
					List<String> gg = map.getOrDefault(te, new ArrayList<String>());
					for(String g : gg) {
						if(!addedInSomeSet.getOrDefault(g, false)) {
							addedInSomeSet.put(g, true);
							t.add(g);
							aa.add(g);
						}
					}
				}
				answers.add(aa);
			}
		}
		return answers;
				
	}
	Map<String, List<String>> synonymMap;
	List<String> answers;
	public List<String> generateSentences(List<List<String>> synonyms, String text) {
        this.answers = new ArrayList<String>();
        this.synonymMap = new HashMap<String, List<String>>();
        //Process Synonyms
        for(List<String> synonym : synonyms) {
        	String key1 = synonym.get(0), key2 = synonym.get(1);
        	List<String> temp = synonymMap.getOrDefault(key1, new ArrayList<String>());
        	temp.add(key2);
        	this.synonymMap.put(key1, temp);
        	
        	temp = synonymMap.getOrDefault(key2, new ArrayList<String>());
        	temp.add(key1);
        	this.synonymMap.put(key2, temp);
        }
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        bfs(sb,words,0);
        Collections.sort(this.answers);
        return this.answers;
        
    }
	
	private void bfs(StringBuilder sb, String[] words, int index) {
		if(index == words.length) {
			answers.add(sb.toString());
			return;
		}
		
		List<String> synonyms = synonymMap.get(words[index]);
		int len = sb.length();
		if(synonyms == null) {
			sb.append(words[index]);
			if(index < words.length - 1) {
				sb.append(" ");
			}
			bfs(sb, words, index + 1);
		}else {
			Set<String> synonymsDeep = new HashSet<String>();
			getNeighbors(words[index], synonymsDeep);
			for(String t : synonymsDeep) {
				sb.append(t);
				if(index < words.length - 1) {
					sb.append(" ");
				}
				bfs(sb,words,index + 1);
				sb.setLength(len);				
			}			
			
		}
	}
	
	private void getNeighbors(String word, Set<String> synonyms) {
		if(synonyms.contains(word)) {
			return;
		}
		synonyms.add(word);
		for(String syn : this.synonymMap.get(word)) {
			getNeighbors(syn,synonyms);
		}
	}
	
	
	
	
	
	
	
}
