package edu.stonybrook.pnarendra.hard;

public class StudentAttendanceRecords2 {
	/*
	int possibilities;
	char[] c = new char[] {'A','P','L'};
	
	public int checkRecord(int n) {
        this.possibilities = 0;
        
        StringBuilder sb = new StringBuilder();
        dfs(n,0,sb,false);
        return this.possibilities;
    }
	
	private void dfs(int n, int len, StringBuilder sb, boolean absentDayPresent) {
		
		if(sb.length() >= 2 && sb.charAt(len-1) == sb.charAt(len-2) && sb.charAt(len - 1) == 'L') {
			return;
		}
		
		if(len == n) {
			this.possibilities = (this.possibilities+1)%(1000000007);
		}else {
			for(char f : this.c) {
				if(f == 'A') {
					if(absentDayPresent == true) {
						continue;
					}else {
						sb.append(f);
						dfs(n,len+1,sb,true);
						sb.deleteCharAt(sb.length()-1);
					}
				}else {
					sb.append(f);
					dfs(n,len+1,sb,absentDayPresent);
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
			
	}
	*/
	long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }

}
