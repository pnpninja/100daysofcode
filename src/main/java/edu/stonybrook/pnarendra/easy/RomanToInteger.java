package edu.stonybrook.pnarendra.easy;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int sum = 0;
        sum+=romanAlphabetToInteger(roman[0]);
        for(int i = 1; i < roman.length; i++) {
        	if(roman[i] == 'M') {
        		if(i != 0 && roman[i-1] == 'C') {
        			sum+=800;
        		}else {
        			sum+=1000;
        		}
        	}else if(roman[i] == 'D') {
        		if(i != 0 && roman[i-1] == 'C') {
        			sum+=300;
        		}else {
        			sum+=500;
        		}
        	}else if(roman[i] == 'C') {
        		if(i != 0 &&roman[i-1] == 'X') {
        			sum+=80;
        		}else {
        			sum+=100;
        		}
        	}else if(roman[i] == 'L') {
        		if(i != 0 &&roman[i-1] == 'X') {
        			sum+=30;
        		}else {
        			sum+=50;
        		}
        	}else if(roman[i] == 'X') {
        		if(i != 0 &&roman[i-1] == 'I') {
        			sum+=8;
        		}else {
        			sum+=10;
        		}
        	}else if(roman[i] == 'V') {
        		if(i != 0 &&roman[i-1] == 'I') {
        			sum+=3;
        		}else {
        			sum+=5;
        		}
        	}else {
        		sum+=1;
        	}
        }
        return sum;
    }
	
	private int romanAlphabetToInteger(char rom) {
		switch(rom) {
			case 'I' : return 1;
			case 'V' :return 5;
			case 'X': return 10;
			case 'L':return 50;
			case 'C': return 100;
			case 'D' : return 500;
			case 'M' : return 1000;
			default: return 0;
		}
	}

	

}
