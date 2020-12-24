package edu.stonybrook.pnarendra.medium;

public class ReverseWordsInString {
	public String reverseWords(String s) {
        s = s.replaceAll("^\\s+","").replaceAll("\\s+$","").replaceAll("\\s+"," ");
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < s.length()){
            int j = i + 1;
            while(j < s.length() && arr[j]!=' '){
                j++;
            }
             //encountered space or out of bound
            int k = j - 1;
            for(int x = 0; x <= (k-i)/2; x++){
                char temp = arr[i+x];
                arr[i+x] = arr[k-x];
                arr[k-x] = temp;
            }
            i = j + 1;  
        }
        for(int ii = 0; ii < s.length()/2; ii++){
            char temp = arr[ii];
            arr[ii] = arr[s.length() - 1 - ii];
            arr[s.length()-1-ii] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int ii = 0; ii < s.length(); ii++){
            sb.append(arr[ii]);
        }
        return sb.toString();
    }
}
