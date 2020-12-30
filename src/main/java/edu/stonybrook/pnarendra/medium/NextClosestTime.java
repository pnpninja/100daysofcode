package edu.stonybrook.pnarendra.medium;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	
	public String nextClosestTime(String time) {
        int minutes = (Integer.parseInt(time.substring(0,2)) * 60 )+(Integer.parseInt(time.substring(3)));
        Set<Integer> digits = new HashSet<Integer>();
        for(char c : time.toCharArray()) {
        	if(c == ':') {
        		continue;
        	}else {
        		digits.add(c-'0');
        	}
        }
        
        while(true) {
        	minutes = (minutes + 1)%(24*60);
        	int[] newDigits = {(minutes / 60)/10,(minutes/60)%10,(minutes%60)/10,(minutes%60)%10};
        	boolean isValid = true;
        	for(int d : newDigits) {
        		if(!digits.contains(d)) {
        			isValid = false;
        			break;
        		}
        	}
        	
        	if(isValid) {
        		return String.valueOf(newDigits[0]) + newDigits[1] + ":" + newDigits[2] + newDigits[3];
        	}
        }
    }
	

}
