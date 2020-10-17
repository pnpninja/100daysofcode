package edu.stonybrook.pnarendra.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

class Meeting{
	int startTime;
	int endTime;
	
	public Meeting(int[] times) {
		this.startTime = times[0];
		this.endTime = times[1];
	}
}

class MeetingComparator implements Comparator<Meeting>{
	@Override
	public int compare(Meeting o1, Meeting o2) {
		return new Integer(o1.startTime).compareTo(o2.startTime);
	}
	
}

class MeetingComparator2 implements Comparator<Meeting>{
	@Override
	public int compare(Meeting o1, Meeting o2) {
		return new Integer(o1.endTime).compareTo(o2.endTime);
	}
	
}
public class MeetingRooms2 {
	public static int minMeetingRooms(int[][] intervals) {
		PriorityQueue<Meeting> meetings = new PriorityQueue<Meeting>(new MeetingComparator());
        for(int[] interval : intervals) {
        	meetings.add(new Meeting(interval));
        }
        PriorityQueue<Meeting> minMeetingRooms = new PriorityQueue<Meeting>(new MeetingComparator2());
        while(!meetings.isEmpty()) {
        	Meeting nextMeeting = meetings.poll();
        	Meeting oldMeeting = minMeetingRooms.peek();
        	if(oldMeeting == null) {
        		minMeetingRooms.add(nextMeeting);
        	}else {
        		if(oldMeeting.endTime <= nextMeeting.startTime) {
        			minMeetingRooms.poll();
        		}
        		minMeetingRooms.add(nextMeeting);
        	}
        }
        return minMeetingRooms.size();
    }
	
	public static void main(String[] args) {
		int[][] meetings = new int[][] {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(meetings));
	}
}
