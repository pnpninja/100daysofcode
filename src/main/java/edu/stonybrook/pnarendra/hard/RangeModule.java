package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.List;

public class RangeModule {
	
	List<int[]> ranges = new ArrayList<int[]>();

    public RangeModule() {
        ranges.add(new int[] {-2,-1});
    }
    
    public void addRange(int left, int right) {
        int l = searchFloor(left);
        int r = searchFloor(right);
        int[] vl = ranges.get(l);
        int[] vr = ranges.get(r);
        if(vr[1] < left) {
        	ranges.add(r+1,new int[] {left,right});
        }else {
        	for(int k = 0; k < r - l;k++) {
        		ranges.remove(l+1);
        	}
        	
        	if(vl[1] < left) {
        		ranges.add(l+1,new int[] {left, Math.max(right, vr[1])});
        	}else {
        		ranges.remove(l);
        		ranges.add(l, new int[] {vl[0],Math.max(right, vr[1])});
        	}
        }
        		
    }
    
    public boolean queryRange(int left, int right) {
    	int l = searchFloor(left);
        int[] r = ranges.get(l);
        return (r[1] >= right);
    }
    
    public void removeRange(int left, int right) {
    	int l = searchFloor(left);
        int r = searchFloor(right);
        int[] vl = ranges.get(l);
        int[] vr = ranges.get(r);
        if (vr[1] <= left) return;
        for (int k = 0; k < r-l; k++) ranges.remove(l+1);
        if (vr[1] > right) {
            ranges.add(l+1, new int[] {right, vr[1]});
        }
        if (vl[1] > left) {
            ranges.remove(l);
            if (vl[0] < left) {
                ranges.add(l, new int[] {vl[0], left});
            }
        }
    }
    
    private int searchFloor(int key) {
    	int low = 0;
    	int high = ranges.size();
    	while(low + 1 < high) {
    		int mid = (low + high)/2;
    		int v = ranges.get(mid)[0];
    		if(v == key) {
    			low = mid;
    			break;
    		}else if(v > key) {
    			high = mid;
    		}else {
    			low = mid;
    		}
    	}
    	return low;
    	
    }
}
