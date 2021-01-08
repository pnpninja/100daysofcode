package edu.stonybrook.pnarendra.hard;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
	
	Set<String> seen;
	StringBuilder ans;
	
	public String crackSafe(int n, int k) {
        if(n ==1 && k == 1) {
        	return "0";
        }
        
        seen = new HashSet<String>();
        ans = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1;i++) {
        	sb.append("0");
        }
        
        String start = sb.toString();
        dfs(start,k);
        ans.append(start);
        return new String(ans);
        
    }
	
	private void dfs(String node, int k) {
		for(int i = 0; i < k; i++) {
			String temp = node+i;
			if(!seen.contains(temp)) {
				seen.add(temp);
				dfs(temp.substring(1),k);
				ans.append(i);
			}
		}
	}

    
    
    public static void main(String[] args) {
		System.out.println(new CrackingTheSafe().crackSafe(2, 2));
	}
}
