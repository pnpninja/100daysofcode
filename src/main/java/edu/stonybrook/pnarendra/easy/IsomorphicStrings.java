package edu.stonybrook.pnarendra.easy;

public class IsomorphicStrings {
		
	public boolean isIsomorphic(String s, String t) {
       char[] sMap = new char[256];
       char[] tMap = new char[256];
       int len = s.length();
       for(int i = 0; i < s.length(); i++) {
    	   char sChar = s.charAt(i);
    	   char tChar = t.charAt(i);
    	   if(sMap[sChar] != 0 && tMap[tChar] != 0) {
    		   if(sMap[sChar] == tChar + 1 && tMap[tChar] == sChar + 1) {
    			   continue;
    		   }else {
    			   return false;
    		   }
    	   }else if(sMap[sChar] != 0 || tMap[tChar] !=0) {
    		   return false;
    	   }else {
    		   sMap[sChar] = (char) (tChar + 1);
    		   tMap[tChar] = (char) (sChar + 1);
    	   }
       }
       return true;
    }


}
