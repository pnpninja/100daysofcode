package edu.stonybrook.pnarendra.medium;

public class AlphabetBoardPath {
	public String alphabetBoardPath(String target) {
        char start = 'a';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < target.length();i++) {
        	if(start != target.charAt(i)) {
        		sb.append(createMoves(start,target.charAt(i)));
        	}
        	sb.append("!");
    		start = target.charAt(i);
        }
        return sb.toString();
    }
	
	public String createMoves(char source, char destination) {
		if(source == 'z') {
			return "U" + createMoves('u',destination);
		}else if(destination == 'z') {
			return createMoves(source,'u') + "D";
		}else {
			int sourceRow = (source-97)/5;
			int sourceCol = (source-97)%5;
			int destinationRow = (destination-97)/5;
			int destinationCol = (destination-97)%5;
			StringBuilder sb = new StringBuilder();
			int t = Math.abs(destinationRow - sourceRow);
			for(int i = 0; i < t;i++) {
				sb.append(destinationRow > sourceRow ? "D" : "U");
			}
			
			for(int i = 0; i < Math.abs(destinationCol - sourceCol);i++) {
				sb.append(destinationCol > sourceCol ? "R" : "L");
			}
			return sb.toString();
			
			
		}
		
	}
}
