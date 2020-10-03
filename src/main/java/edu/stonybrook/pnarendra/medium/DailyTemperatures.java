package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

class TempNode{
	int loc;
	int temp;
	
	public TempNode(int loc, int temp) {
		this.loc = loc;
		this.temp = temp;
	}
}
public class DailyTemperatures {
	
	public int[] dailyTemperatures(int[] T) {
		int[] answer = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < T.length; i++) {
			while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
				int t = stack.pop();
				answer[t] = i - t;
			}
			stack.add(i);
		}
		return answer;
		
        
    }

}
