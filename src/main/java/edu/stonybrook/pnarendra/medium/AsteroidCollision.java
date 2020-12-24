package edu.stonybrook.pnarendra.medium;

import java.util.Stack;

public class AsteroidCollision {
	
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int asteroid : asteroids) {
        	if(stack.isEmpty() || asteroid > 0) {
        		stack.add(asteroid);
        	}else {
        		if(stack.isEmpty() || stack.peek() < 0) {
        			stack.push(asteroid);
        		}else {
        			while(true) {
            			if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
            				stack.pop();
            			}else {
            				break;
            			}
            		}
            		if(stack.isEmpty()) {
            			stack.push(asteroid);
            		}else if(stack.peek() == -asteroid) {
            			stack.pop();
            		}else {
            			stack.push(asteroid);
            		}
        		}
        		
        	}
        }
        int[] answer = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
        	answer[i] = stack.pop();
        	i++;
        }
        for(int ii = 0; ii < answer.length/2;ii++) {
        	int temp = answer[ii];
        	answer[ii] = answer[answer.length - 1 - ii];
        	answer[answer.length - 1 - ii] = temp;
        }
        return answer;
        
        
    }
	
	public static void main(String[] args) {
		int[] asteroids = new int[] {-2,-2,1,-2};
		new AsteroidCollision().asteroidCollision(asteroids);
	}

}
