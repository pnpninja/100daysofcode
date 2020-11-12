package edu.stonybrook.pnarendra.dp;

public class EggDroppingPuzzle {
	
	public static int eggDrop(int floors, int eggs) {
		int[][] dp = new int[eggs + 1][floors + 1];
		for(int i = 0; i <= floors; i++) {
			dp[1][i] = i; 
		}
		
		for(int eggIdx = 2; eggIdx <= eggs; eggIdx++) {
			for(int floorIdx = 1; floorIdx <= floors; floorIdx++) {
				if(floorIdx < eggIdx) {
					dp[eggIdx][floorIdx] = dp[eggIdx - 1][floorIdx];
				}else {
					dp[eggIdx][floorIdx] = Integer.MAX_VALUE;
					for(int i = 1; i <= floorIdx; i++) {
						int res = 1 + Math.max(dp[eggIdx - 1][i - 1], dp[eggIdx][floorIdx - i]);
						if(res < dp[eggIdx][floorIdx]) {
							dp[eggIdx][floorIdx] = res;
						}
					}
				}
			}
		}
		return dp[eggs][floors];
		

	}
	
	public static void main(String[] args) {
		System.out.println(eggDrop(36,2));
	}

}
