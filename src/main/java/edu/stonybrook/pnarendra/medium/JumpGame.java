package edu.stonybrook.pnarendra.medium;

import java.util.LinkedList;
import java.util.Queue;

class DS{
	public int index;
	public int jump;
	
	public DS(int index, int jump) {
		this.index = index;
		this.jump = jump;
	}
}
public class JumpGame {
	public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        Queue<DS> queue = new LinkedList<DS>();
        queue.add(new DS(0,nums[0]));
        visited[0] = true;
        while(!queue.isEmpty()) {
        	Queue<DS> nextQueue = new LinkedList<DS>();
        	while(!queue.isEmpty()) {
        		DS ds = queue.poll();       		
        		for(int i = 1; i<=ds.jump;i++) {
        			if(ds.index + i < nums.length && !visited[ds.index + i]) {
            			DS ds2 = new DS(ds.index + i,nums[ds.index + i]);
            			visited[ds.index + i] = true;
            			nextQueue.add(ds2);
            		}
        		}
        		
        	}
        	queue = nextQueue;
        }
        return visited[nums.length-1];
    }
	
	public boolean canJump2(int[] nums) {
		int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	
	public static void main(String[] args) {
		System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
	}

}
