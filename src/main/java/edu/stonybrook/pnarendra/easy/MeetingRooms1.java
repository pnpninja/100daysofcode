package edu.stonybrook.pnarendra.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms1 {
	public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				}else if(o1[0] == o2[0]) {
					if(o1[1] < o2[1]) {
						return -1;
					}else if(o1[1] == o2[1]) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
        	
		});
        
        for(int i = 0; i < intervals.length - 1; i++) {
        	if(intervals[i][1] > intervals[i + 1][0]) {
        		return false;
        	}else {
        		continue;
        	}
        }
        return true;
    }
}
