package edu.stonybrook.pnarendra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
	
	public void backtrack(List<String> ans, String str, int open, int close, int n) {
		if(str.length() == 2 * n) {
			ans.add(str);
			return;
		}
		
		if(open < n) {
			backtrack(ans,str+"(",open + 1,close,n);
		}
		if(close < open) {
			backtrack(ans,str+")",open,close + 1,n);
		}
	}


}
