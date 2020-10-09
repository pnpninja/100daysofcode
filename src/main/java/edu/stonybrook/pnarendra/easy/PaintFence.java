package edu.stonybrook.pnarendra.easy;

public class PaintFence {

	public int numWays(int n, int k) {
		if(n == 0) {
			return 0;
		}
		int same = 0, diff = k, temp = 0;
		for(int i = 2; i<=n;i++) {
			temp = diff;
			diff = (same + diff) * (k - 1);
			same = temp;
		}
		return same + diff;
		
        
    }
}
