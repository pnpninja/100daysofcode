package edu.stonybrook.pnarendra.solutions;

public class Databricks_FrameGenerator {

	public void generateFrame(int n) {
		for(int i = 0; i < n; i++) {
			StringBuilder temp = new StringBuilder();
			for(int j = 0; j < n; j++) {
				if(i == 0 || j == 0 || i == n - 1 || j == n - 1) {
					temp.append("*");
				}else {
					temp.append(" ");
				}
			}
			System.out.println(temp);
		}
		return;
	}
	
	public static void main(String[] args) {
		new Databricks_FrameGenerator().generateFrame(4);
	}
}
