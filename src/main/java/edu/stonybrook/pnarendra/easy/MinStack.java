package edu.stonybrook.pnarendra.easy;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    Stack<int[]> minStack;
    public MinStack() {
        this.minStack = new Stack<int[]>();
    }
    
    public void push(int x) {
        if(this.minStack.isEmpty()){
            this.minStack.push(new int[] {x,x});
            return;
        }
        
        this.minStack.push(new int[]{x,Math.min(x,this.minStack.peek()[1])});
        return;
        
    }
    
    public void pop() {
        this.minStack.pop();
    }
    
    public int top() {
        return this.minStack.peek()[0];
    }
    
    public int getMin() {
        return this.minStack.peek()[1];
    }
}
