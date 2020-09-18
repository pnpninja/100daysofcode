package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class Stock{
	String name;
	int volume;
}

class StockComparator implements Comparator<Stock>{

	@Override
	public int compare(Stock o1, Stock o2) {
		if(o1.volume < o2.volume) {
			return 1;
		}else if(o1.volume == o2.volume) {
			return 0;
		}else {
			return -1;
		}
	}
	
}
public class Bloomberg_TopKTradedStocks {
	Map<String, Stock> hashMap;
	PriorityQueue<Stock> maxHeap;
	
	public Bloomberg_TopKTradedStocks() {
		this.hashMap = new HashMap<>();
		this.maxHeap = new PriorityQueue<Stock>(new StockComparator());
	}
	
	public void addVolume(String stock, int volume) {
		if(this.hashMap.containsKey(stock)) {
			Stock stockObj = this.hashMap.get(stock);
			this.maxHeap.remove(stockObj);
			stockObj.volume+=volume;
			this.maxHeap.add(stockObj);
			this.hashMap.put(stock, stockObj);
		}else {
			Stock stockObj = new Stock();
			stockObj.name = stock;
			stockObj.volume = volume;
			this.hashMap.put(stock, stockObj);
			this.maxHeap.add(stockObj);
		}
	}
	
	public List<String> topKTradedStocks(int k){
		Stack<Stock> temp = new Stack<Stock>();
		List<String> stocks = new ArrayList<String>();
		int iter = 0;
		while(iter < k && !this.maxHeap.isEmpty()) {
			Stock t = this.maxHeap.poll();
			temp.add(t);
			stocks.add(t.name);
		}
		
		while(!temp.isEmpty()) {
			this.maxHeap.add(temp.pop());
		}
		
		return stocks;
	}
	
	public static void main(String[] args) {
		Bloomberg_TopKTradedStocks stockTicker = new Bloomberg_TopKTradedStocks();
		stockTicker.addVolume("GOOG", 10);
		stockTicker.addVolume("YHOO", 30);
		System.out.println(Arrays.deepToString(stockTicker.topKTradedStocks(2).toArray()));
		stockTicker.addVolume("GOOG", 100);
		System.out.println(Arrays.deepToString(stockTicker.topKTradedStocks(2).toArray()));
	}

}
