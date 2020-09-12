package edu.stonybrook.pnarendra.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Nordstrom_SetIntersection {
	
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		String[] arrays = new String[2];
		int i = 0;
		while(i < 2) {
			arrays[i] = in.readLine();
			i++;
		}
		String[] answer = setIntersection(arrays);
		if(answer.length == 0) {
			System.out.println("NULL");
		}else {
			for(int k = 0; k < answer.length; k++) {
				System.out.print(answer[k]);
				if(k < answer.length - 1) {
					System.out.print(" ");
				}
			}
		}
		
	}
	
	private static String[] setIntersection(String[] arrays){
		String[] array1 = arrays[0].split(" ");
		String[] array2 = arrays[1].split(" ");
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int array1Pointer = 0;
		int array2Pointer = 0;
		int k = 0;
		
		while(array1Pointer < array1.length && array2Pointer < array2.length) {
			if(array1[array1Pointer].compareTo(array2[array2Pointer]) < 0) {
				++array1Pointer;
			}else if(array1[array1Pointer].compareTo(array2[array2Pointer]) > 0) {
				++array2Pointer;
			}else {
				array1[k++] = array1[array1Pointer++];
				array2Pointer++;
			}
		}
		
		return Arrays.copyOfRange(array1, 0, k);
	}

}
