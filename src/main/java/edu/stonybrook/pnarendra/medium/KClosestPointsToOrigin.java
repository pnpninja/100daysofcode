package edu.stonybrook.pnarendra.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class PointComparator implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		double d1 = Math.sqrt((o1[0]*o1[0]) + (o1[1]*o1[1]));
		double d2 = Math.sqrt((o2[0]*o2[0]) + (o2[1]*o2[1]));
		
		return new Double(d1).compareTo(d2);
	}
	
}
public class KClosestPointsToOrigin {
	
	public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> sortedList = new PriorityQueue<int[]>(new PointComparator());
        
        for(int i = 0; i < points.length; i++) {
        	sortedList.add(points[i]);
        }
        int[][] temp = new int[Math.min(K, sortedList.size())][2];
        int t = sortedList.size();
        for(int i = 0; i < Math.min(K, t); i++) {
        	temp[i] = sortedList.poll();
        }
        return temp;
    }
	
	public static void main(String[] args) {
		int[][] temp = new int[][] {{1,0},{0,1}};
		//int[][] gg = kClosest(temp, 2);
		int xx = Arrays.binarySearch(new int[] {1,2,4,5,6},0);
		System.out.println("Done");
		
	}

}
