package edu.stonybrook.pnarendra.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToEnglish {
	
	public String numberToWords(int num) {
        if(num == 0) {
        	return "Zero";
        }
        //return null;
        List<Integer> triples = splitNumbers(num);
        List<String> tripleWords = triples.stream().map(triple -> processTriple(triple)).collect(Collectors.toList());
        int loc = 0;
        StringBuilder answer = new StringBuilder();
        for(String tripleWord : tripleWords) {
        	if(loc == 0) {
        		answer.insert(0, tripleWord);
        		loc++;
        	}else if(loc == 1) {
        		if(!tripleWord.equals("")) {
        			answer.insert(0, tripleWord+" Thousand ");
        		}
        		loc++;
        	}else if(loc == 2) {
        		if(!tripleWord.equals("")) {
        			answer.insert(0, tripleWord+" Million ");
        		}
        		loc++;
        	}else {
        		if(!tripleWord.equals("")) {
        			answer.insert(0, tripleWord+" Billion ");
        		}
        		loc++;
        	}
        }
        return answer.toString().trim();
        
    }
	
	private String processTriple(int num) {
		if(num == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int lastTwoDigits = num % 100;
		int thirdDigit = (num - lastTwoDigits)/100;
		if(thirdDigit!=0) {
			sb.append(singleDigitToString(thirdDigit));
			sb.append(" Hundred");
		}
		
		if(lastTwoDigits >= 10 && lastTwoDigits <= 19) {
			if(lastTwoDigits == 10) {
				sb.append((sb.length()!=0 ? " " : "")+"Ten");
			}else if(lastTwoDigits == 11) {
				sb.append((sb.length()!=0 ? " " : "")+"Eleven");
			}else if(lastTwoDigits == 12) {
				sb.append((sb.length()!=0 ? " " : "")+"Twelve");
			}else if(lastTwoDigits == 13) {
				sb.append((sb.length()!=0 ? " " : "")+"Thirteen");
			}else if(lastTwoDigits == 14) {
				sb.append((sb.length()!=0 ? " " : "")+"Fourteen");
			}else if(lastTwoDigits == 15) {
				sb.append((sb.length()!=0 ? " " : "")+"Fifteen");
			}else if(lastTwoDigits == 16) {
				sb.append((sb.length()!=0 ? " " : "")+"Sixteen");
			}else if(lastTwoDigits == 17) {
				sb.append((sb.length()!=0 ? " " : "")+"Seventeen");
			}else if(lastTwoDigits == 18) {
				sb.append((sb.length()!=0 ? " " : "")+"Eighteen");
			}else {
				sb.append((sb.length()!=0 ? " " : "")+"Nineteen");
			}
			return sb.toString();
		}else {
			int tensPlace = lastTwoDigits/10;
			if(tensPlace!=0) {
				if(tensPlace == 2) {
					sb.append((sb.length()!=0 ? " " : "")+"Twenty");
				}else if(tensPlace == 3) {
					sb.append((sb.length()!=0 ? " " : "")+"Thirty");
				}else if(tensPlace == 4) {
					sb.append((sb.length()!=0 ? " " : "")+"Forty");
				}else if(tensPlace == 5) {
					sb.append((sb.length()!=0 ? " " : "")+"Fifty");
				}else if(tensPlace == 6) {
					sb.append((sb.length()!=0 ? " " : "")+"Sixty");
				}else if(tensPlace == 7) {
					sb.append((sb.length()!=0 ? " " : "")+"Seventy");
				}else if(tensPlace == 8) {
					sb.append((sb.length()!=0 ? " " : "")+"Eighty");
				}else{
					sb.append((sb.length()!=0 ? " " : "")+"Ninety");
				}
			}
			int onesPlace = lastTwoDigits%10;
			if(onesPlace!=0) {
				sb.append((sb.length()!=0 ? " " : "")+singleDigitToString(onesPlace));
			}
			return sb.toString();
		}
	}
	
	private String singleDigitToString(int digit) {
		switch (digit) {
			case 1: return "One";
			case 2: return "Two";
			case 3: return "Three";
			case 4: return "Four";
			case 5: return "Five";
			case 6: return "Six";
			case 7: return "Seven";
			case 8: return "Eight";
			case 9: return "Nine";
			default: return "";
			
		}
			
	}
	
	//Split Numbers into pairs of threes
	private static List<Integer> splitNumbers(int num){
		int pow10 = 0, numTemp = 0;
		List<Integer> answer = new ArrayList<Integer>();
		while(num > 0) {
			int rem = num % 10;
			num=num/10;
			numTemp = ((int)(Math.pow(10, pow10))*rem)+numTemp;
			pow10++;
			if(pow10 == 3) {
				pow10 = 0;
				answer.add(numTemp);
				numTemp = 0;
			}			
			else if(num == 0) {
				pow10 = 0;
				answer.add(numTemp);
				numTemp = 0;
			}
		}
		return answer;
	}
	

}
