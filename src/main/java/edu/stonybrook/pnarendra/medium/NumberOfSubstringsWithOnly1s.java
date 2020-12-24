package edu.stonybrook.pnarendra.medium;

public class NumberOfSubstringsWithOnly1s {
	public int numSub(String s) {
		int len = s.length(), mod = 1000000007;
        if(len==1)return s.charAt(0)=='1'?1:0;
        long ans=0, cnt=0;
        for(char c:s.toCharArray()){
            if(c=='0')cnt=0;
            else ans+= ++cnt;
        }
        return (int)(ans%mod);
    }
	
	public static void main(String[] args) {
		new NumberOfSubstringsWithOnly1s().numSub("0110111");	
	}
}
