package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Course {
	Set<Integer> in;
	Set<Integer> out;
	int prereqCount;
	boolean traversed;
	
	public Course() {
		this.in = new HashSet<Integer>();
		this.out = new HashSet<Integer>();
		this.prereqCount = 0;
		traversed = false;
	}
	
	public void traversePrereq(int prereq) {
		if(in.contains(prereq)) {
			in.remove(prereq);
			prereqCount--;
		}
	}
	
	public void addPrereq(int prereq) {
		if(!in.contains(prereq)) {
			in.add(prereq);
			prereqCount++;
		}
	}
	
	public boolean isReadyToStudy() {
		return this.prereqCount == 0;
	}
}
public class CourseSchedule2 {
	
	private boolean isCyclic(Course[] courseInfo) {
		boolean[] recStack = new boolean[courseInfo.length];
		boolean[] visited = new boolean[courseInfo.length];
		
		for(int i = 0; i < courseInfo.length; i++) {
			if(isCyclicUtil(i, courseInfo, recStack, visited)) {
				return true;
			}
		}
		return false;
		
		
	}
	
	private boolean isCyclicUtil(int i, Course[] courseInfo, boolean[] recStack, boolean[] visited) {
		if(recStack[i])
			return true;
		if(visited[i])
			return false;
		
		visited[i] = true;
		recStack[i] = true;
		for(int o : courseInfo[i].out) {
			if(isCyclicUtil(o,courseInfo, recStack, visited)) {
				return true;
			}
		}
		recStack[i] = false;
		return false;
		
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Course[] courseInfo = new Course[numCourses];
        for(int i = 0; i < numCourses; i++) {
        	courseInfo[i] = new Course();
        }
    	//take the course bi before the course ai
    	//bi is the prereq
    	//ai has indegree from bi
    	//bi has outdegree to ai        
        for(int[] prerequisite : prerequisites) {
        	int ai = prerequisite[0];
        	int bi = prerequisite[1];
        	courseInfo[ai].addPrereq(bi);
        	courseInfo[bi].out.add(ai);       	
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        if(isCyclic(courseInfo)) {
        	return new int[0];
        }
        for(int i = 0; i < numCourses; i++) {
        	if(courseInfo[i].prereqCount == 0) {
        		queue.add(i);
        	}
        }
        
        while(!queue.isEmpty()) {
        	int nextCourseIndex = queue.poll();
        	answer.add(nextCourseIndex);
        	Course nextCourse = courseInfo[nextCourseIndex];
        	for(int c : nextCourse.out) {
        		courseInfo[c].traversePrereq(nextCourseIndex);
        		if(courseInfo[c].isReadyToStudy()) {
        			queue.add(c);
        		}
        	}
        }
        int[] gg = new int[answer.size()];
        int i = 0;
        for(int k : answer) {
        	gg[i++] = k;
        }
        return gg;
    }
	
	public static void main(String[] args) {
		int[][] prerequisites = new int[][] {{0,1},{0,2},{1,2}};
		int numCourses = 3;
		int[] ans = new CourseSchedule2().findOrder(numCourses, prerequisites);
	}
	
}
