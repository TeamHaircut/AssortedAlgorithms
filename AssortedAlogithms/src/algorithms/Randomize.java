package algorithms;

import java.util.Random;

public class Randomize {
	
	public static void inPlace(int[] A) {
		int n = A.length;
		for(int i = 0; i < n; i++) {
			int temp = A[i];
			Random random = new Random();
			int randomNumber = random.nextInt((n-1) + 1 - 0) + 0;
			A[i] = A[randomNumber];
			A[randomNumber] = temp;
		}
	}

}
