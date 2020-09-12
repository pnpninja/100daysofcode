package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Amazon_Day1Challenge {
	List<String> answers(String input, int size){
		String s = input;
        // String s = "democracy";
        int k = size;
        HashMap<Character, Integer> window =  new HashMap<>();
        for(int i=0;i<k;i++)
        {
            if(window.get(s.charAt(i)) == null)
            {
                window.put(s.charAt(i),1);
            }
            else
            {
                window.put(s.charAt(i), window.get(s.charAt(i)) + 1 );
            }
        }
        List<String> ans = new ArrayList<>();
        int end = k-1;

        // ocrack, 4
        // wawaglkn
        for (int i = 0 ;i < s.length()-k+1; i++)
        {
            // System.out.println("window" + window);
            // System.out.println(i + " , "+ end);
            if(window.size() == k-1)
            {
                ans.add(s.substring(i,end+1));
            }

            if(window.get(s.charAt(i)) == 1)
                window.remove(s.charAt(i));
            else
                window.put(s.charAt(i),window.get(s.charAt(i)) - 1);
            
            end = end + 1;
            if(end < s.length())
            {
                if(window.get(s.charAt(end)) == null )
                {
                    window.put(s.charAt(end),1);
                }
                else
                {
                    window.put(s.charAt(end), window.get(s.charAt(end)) + 1);
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
	}

	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new Amazon_Day1Challenge().answers("awaglknagawunagwkwagl", 4).toArray()));
	}
}
