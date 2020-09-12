package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class WordStat{
	public String word;
	public int count;
	
}

class WordStatComparator implements Comparator<WordStat>{
	@Override
	public int compare(WordStat o1, WordStat o2) {
		if(o1.count > o2.count) {
			return -1;
		}else if(o2.count > o1.count) {
			return 1;
		}else {
			return o1.word.compareTo(o2.word);
		}
	}		
}
public class TopKFrequentWords {	
	public List<String> topKFrequent(String[] words, int k) {
        //Create map to access
		Map<String,WordStat> map = new HashMap<String,WordStat>();
		PriorityQueue<WordStat> maxHeap= new PriorityQueue<WordStat>(new WordStatComparator());
		for(String word : words) {
			if(map.containsKey(word)) {
				WordStat obj = map.get(word);
				if(maxHeap.contains(obj)) {
					maxHeap.remove(obj);
					obj.count++;
					maxHeap.add(obj);
				}else {
					obj.count++;
					maxHeap.add(obj);
				}
			}else {
				WordStat obj = new WordStat();
				obj.word = word;
				obj.count = 1;
				map.put(word, obj);
				maxHeap.add(obj);
			}
		}
		
		List<String> answer = new ArrayList<String>();
		int counter = 0;
		while(counter < k && !maxHeap.isEmpty()) {
			answer.add(maxHeap.poll().word);
			counter++;
		}
		
		return answer;
		
    }
	
	public static void main(String[] args) {
		String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> ans = new TopKFrequentWords().topKFrequent(words, 2);
		System.out.println("Done");
	}
}
