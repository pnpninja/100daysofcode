package edu.stonybrook.pnarendra.solutions;

public class IMCTrading {
	public class SearchArtifacts{
	    public int[] solution(int N, String artifacts, String searched){
	        int[] returnAnswer = {0,0};
	        String[] arrOfArtifacts = artifacts.split(","); //Total number of artifacts.
	        //Co-ordinates of artifact.
	        
	        for(String artifact : artifacts.split(",")) {
	        	 String[] singleArtifact = artifact.split(" ",N); //Co-ordinates of current artifact stored in array.
	        	 //totalArtifactCells stores the count of total number of cells an artifact occupies, count is to count the hits in search string.
	        	int count = 0;
	            int totalCells = 0;
	          
	            for(char row = singleArtifact[0].charAt(0); row<=singleArtifact[1].charAt(0); row++){
	                for(char col = singleArtifact[0].charAt(1); col<=singleArtifact[1].charAt(1); col++){
	                    totalCells++;
	                    if(searched.contains(Integer.toString(row)+Integer.toString(col))){
	                        count++;
	                    }
	                }
	            }
	          
	            if(totalCells>4){
	                //System.out.println("Artifacts should not be greater than 4 cells."); //Print error if an artifact occupies more than 4 cells.
	                //System.exit(0);
	            	continue;
	            }else if(count == totalCells){
	                returnAnswer[0]++; //increment if all cells of current artifact is found.
	            }else {
	                if(count!=0){
	                    returnAnswer[1]++; //increment if not all but some are found.
	                }
	            }
	        }
	      
	        return returnAnswer;
	    }

	}

}
