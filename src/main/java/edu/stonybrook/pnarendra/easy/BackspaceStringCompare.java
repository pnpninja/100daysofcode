package edu.stonybrook.pnarendra.easy;

public class BackspaceStringCompare {
	
	public boolean backspaceCompare(String S, String T) {
        return processString(S).equals(processString(T));
    }
	
	private String processString(String S) {
		StringBuilder sb = new StringBuilder();
		for(char c : S.toCharArray()) {
			if(c == '#') {
				if(sb.length() == 0) {
					continue;
				}else {
					sb.setLength(sb.length()-1);
				}
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
