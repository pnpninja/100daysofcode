package edu.stonybrook.pnarendra.easy;

import java.util.ArrayList;
import java.util.List;

public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		S = S.replace("-", "");
		S = S.toUpperCase();
		StringBuilder sb = new StringBuilder();
		int nosChars = S.length();
		int nosGroups = nosChars/K;
		int remainder = nosChars%K;
		if(remainder == 0) {
			int t = 0;
			for(int i = 0; i < nosGroups;i++) {
				sb.append(S.substring(t, t+K));
				if(t+K<S.length()) {
					sb.append("-");
				}				
				t+=K;
			}
			return sb.toString();
		}else {
			sb.append(S.substring(0, remainder));
			if(nosGroups == 0) {
				return sb.toString();
			}else {
				int t = 0;
				sb.append("-");
				while(t+remainder<S.length()) {
					sb.append(S.substring(t+remainder, t+K+remainder));
					if(t+K+remainder<S.length()) {
						sb.append("-");
					}				
					t+=K;
				}
				return sb.toString();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4);
	}
}
