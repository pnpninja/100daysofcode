package edu.stonybrook.pnarendra.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bloomberg_GenerateAllSubsequences {
	
	List<String> allSubsequences;
	public List<String> generateAllSubsequences(String input){
		this.allSubsequences = new ArrayList<String>();
		generateAllSubsequencesHelper(input, "");
		return this.allSubsequences;
	}
	
	private void generateAllSubsequencesHelper(String str, String str2) {
		if(str.equals("")) {
			this.allSubsequences.add(str2);
		}else {
			generateAllSubsequencesHelper(str.substring(1), str2 + str.charAt(0));
			generateAllSubsequencesHelper(str.substring(1), str2);
		}
	}
	
	public static void main(String[] args) {
		String input = "abcd";
		System.out.println(Arrays.deepToString(new Bloomberg_GenerateAllSubsequences().generateAllSubsequences(input).toArray()));
	}

}
