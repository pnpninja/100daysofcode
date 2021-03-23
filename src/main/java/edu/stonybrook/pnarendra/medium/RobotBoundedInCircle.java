package edu.stonybrook.pnarendra.medium;

public class RobotBoundedInCircle {
	
	int face = 1;
	int x = 0;
	int y = 0;
	public boolean isRobotBounded(String instructions) {
        for(char c : instructions.toCharArray()) {
        	switch(c) {
        	case 'G' : if(face == 1) {//up
        					y++;
        				}else if(face == 2) { //down
        					y--;
        				}else if(face == 3) { //left
        					x--;
        				}else {
        					x++;
        				}
        				break;
        	case 'L' : if(face == 1) { //up
        					face = 3;
        				}else if(face == 2) { //down
        					face = 4;
        				}else if(face == 3) { //left
        					face = 2;
        				}else {
        					face = 1;
        				}
        				break;
        	case 'R' : if(face == 1) { //up
							face = 4;
						}else if(face == 2) { //down
							face = 3;
						}else if(face == 3) { //left
							face = 1;
						}else {
							face = 2;
						}
						break;
			default : break;
        	}
        }
        return (x == 0 && y == 0)|| face != 1;
    }

}
