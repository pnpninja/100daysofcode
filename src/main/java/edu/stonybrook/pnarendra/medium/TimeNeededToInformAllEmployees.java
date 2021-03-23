package edu.stonybrook.pnarendra.medium;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
//	class Employee{
//		int number;
//		int timeToInform;
//		List<Employee> directReports;
//		
//		public Employee(int number, int timeToInform) {
//			this.number = number;
//			this.timeToInform = timeToInform;
//			this.directReports = new ArrayList<Employee>();
//		}
//	}	
//	
//	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime)  {
//		//Prepare all Employee Nodes 
//		List<Employee> allEmployees = new ArrayList<Employee>();
//		for(int i = 0; i < n; i++) {
//			allEmployees.add(new Employee(i,0));
//		}
//		
//		//Create headNode
//		Employee root = allEmployees.remove(headID);
//		root.timeToInform = informTime[headID];
//		int maxTimeToInform = informTime[headID];
//		//BFS to add all nodes
//		List<Employee> firstLevel = new ArrayList<Employee>();
//		firstLevel.add(root);
//		
//		while(!firstLevel.isEmpty()) {
//			List<Employee> secondLevel = new ArrayList<Employee>();
//			while(!firstLevel.isEmpty()) {
//				Employee l1 = firstLevel.remove(0);
//				int newHeadID = l1.number;
//				List<Employee> tempList = getDirectReports(newHeadID, manager, allEmployees);
//				for(Employee employee : tempList) {
//					employee.timeToInform = l1.timeToInform + informTime[employee.number];
//					if(employee.timeToInform > maxTimeToInform) {
//						maxTimeToInform = employee.timeToInform;
//					}
//				}
//				l1.directReports = tempList;
//				secondLevel.addAll(tempList);
//			}
//			firstLevel = secondLevel;
//		}
//		return maxTimeToInform;
//		
//		
//	}
//	
//	private List<Employee> getDirectReports(int headID, int[] manager, List<Employee> allEmployees){
//		List<Employee> l2 = new ArrayList<Employee>();
//		Iterator<Employee> employeeIter = allEmployees.iterator();
//		while(employeeIter.hasNext()) {
//			Employee employee = employeeIter.next();
//			if(manager[employee.number] == headID) {
//				l2.add(employee);
//				employeeIter.remove();
//			}
//		}
//		return l2;
//		
//	}
	
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		/*
			Input: n = 6, headID = 2, manager = [3, 3, -1, 2, 2, 4], informTime[0, 0, 4, 7, 2, 0]

						2 (time: 4)
					  /   \ 
		  (time: 7)  3       4  (time: 2)
				   /   \     \
				 0      1     5
				...   (time: 0) ....


			1. Create graph using adjacency list (mapping manager's to their employees)
				{2: [3, 4], 3:[0, 1], 4:[5]}

			2. Call DFS function to find the max (total overall time elasped)

			3. return results


		Create Adjacent List

		*/
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		adjList.put(headID, new ArrayList<>());

		for(int i = 0; i < manager.length; i++) {

			if(i != headID) {

				int managerID = manager[i];

				if(!adjList.containsKey(managerID)) {
					adjList.put(managerID, new ArrayList<>());
				}
				adjList.get(managerID).add(i);

			}

		}

		return dfs(headID, informTime, adjList);

	}

	public int dfs(int currID, int[] informTime, Map<Integer, List<Integer>> adjList) {

		if(informTime[currID] == 0) {
			return 0;
		}

		int maxTime = 0;

		for(int employee: adjList.get(currID)) {      
				maxTime = Math.max(maxTime, dfs(employee, informTime, adjList));  
		}

		return maxTime + informTime[currID];


	}
	
	public static void main(String[] args) {
		int n = 4, headID = 2;
		int[] manager = new int[] {3,3,-1,2};
		int[] informTime = new int[] {0,0,162,914};
		System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n, headID, manager, informTime));
	}
}
