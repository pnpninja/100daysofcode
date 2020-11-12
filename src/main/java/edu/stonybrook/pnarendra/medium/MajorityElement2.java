package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	
	public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        
        Integer candidate1 = null;
        Integer candidate2 = null;
        
        for(int n : nums) {
        	if(candidate1 != null && candidate1 == n) {
        		c1++;
        	}else if(candidate2 != null && candidate2 == n) {
        		c2++;
        	}else if(c1 == 0) {
        		candidate1 = n;
        		c1 = 1;
        	}else if(c2 == 0) {
        		candidate2 = n;
        		c2 = 1;
        	}else {
        		c1--;
        		c2--;
        	}
        }
        
        List<Integer> result = new ArrayList<Integer>();
        c1 = 0; 
        c2 = 0;
        
        for(int n : nums) {
        	if(candidate1!=null && candidate1 == n) {
        		c1++;
        	}
        	if(candidate2!=null && candidate2 == n) {
        		c2++;
        	}
        	
        }
        
        if(c1 > nums.length/3) result.add(candidate1);
        if(c2 > nums.length/3) result.add(candidate2);
        
        return result;
        
    }

}
