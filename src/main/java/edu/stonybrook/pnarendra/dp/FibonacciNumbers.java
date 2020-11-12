package edu.stonybrook.pnarendra.dp;

import java.util.Arrays;

public class FibonacciNumbers {
	
	static int[] fibonacci(int N) {
		int[] fib = new int[N + 1];
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i <= N; i++){
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(fibonacci(10)));
	}

}
