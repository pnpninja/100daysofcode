package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        List<int[]> ppl = new ArrayList<int[]>();
        for(int i = 0; i < people.length; i++) {
        	ppl.add(people[i]);
        }
        
        Collections.sort(ppl, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				}else if(o1[0] > o2[0]) {
					return 1;
				}else {
					return((Integer) o1[1]).compareTo(o2[1]);
				}
			}
		});
        
        boolean[] occupied = new boolean[people.length];
        for(int i = 0; i < occupied.length; i++) {
        	occupied[i] = false;
        }
        
        for(int[] person : ppl) {
        	int shift = person[1];
        	int loc = 0;
        	while(loc < ppl.size()) {
        		if(occupied[loc] == true) {
        			//If occupied - then i cannot use the space
        			if(people[loc][0] >= person[0]) {
        				shift--;
        			}
        			loc++;
        			
        		}else {
        			//if not occupied
        			if(shift == 0) {
        				occupied[loc] = true;
        				people[loc] = person;
        				break;
        				
        			}else {
        				shift--;
        				loc++;
        			}
        		}
        	}
        }
        
        return people;
        
        
    }
	
	public static void main(String[] args) {
		int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		QueueReconstructionByHeight gg = new QueueReconstructionByHeight();
		gg.reconstructQueue(people);
		System.out.println("dONE");
		
	}
}
