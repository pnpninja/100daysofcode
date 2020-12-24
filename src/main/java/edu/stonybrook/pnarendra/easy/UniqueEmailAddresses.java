package edu.stonybrook.pnarendra.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	
	public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailAddresses = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        for(String email : emails) {
        	sb.setLength(0);
        	String[] parts = email.split("@");
        	for(char t : parts[0].toCharArray()) {
        		if(t == '+') {
        			break;
        		}else if(t == '.') {
        			continue;
        		}else {
        			sb.append(t);
        		}
        	}
        	sb.append("@");
        	sb.append(parts[1]);
        	uniqueEmailAddresses.add(sb.toString());
        }
        return uniqueEmailAddresses.size();
    }

}
