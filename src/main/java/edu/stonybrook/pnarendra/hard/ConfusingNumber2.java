package edu.stonybrook.pnarendra.hard;

public class ConfusingNumber2 {
	
	private int[] iterators = new int[]{0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        return find(0, N);
    }
    
    private int find(int current, int N) {
        int count = 0;
        if (isConfusing(current)) {
            count++;
        }
        
        for (int iter : iterators) {
            int baseLimit = Integer.MAX_VALUE / 10;
            int digitLimit = Integer.MAX_VALUE % 10;
            // prevent overflow
            if (current > baseLimit || current == baseLimit && iter > digitLimit) {
                continue;
            }
            int next = current * 10 + iter;
            if (next >= 1 && next <= N) {
                count += find(next, N);
            }
        }
        
        return count;
    }
    
    private boolean isConfusing(int n) {
        int original = n;
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 6) {
                digit = 9;
            } else if (digit == 9) {
                digit = 6;
            }
            result *= 10;
            result += digit;
            n /= 10;
        }

        return result != original;
    }
	
	public static void main(String[] args) {
		System.out.println(new ConfusingNumber2().confusingNumberII(170));
	}
	
	

}
