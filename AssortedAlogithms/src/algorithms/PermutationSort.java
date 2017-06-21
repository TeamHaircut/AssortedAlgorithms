package algorithms;

import java.util.Random;

public class PermutationSort {
	
	public static void permuteBySorting(int[] A) {
		int n = A.length;
		int[] P = new int[n];
		for(int i = 0; i < n; i++) {
			Random rand = new Random();
			P[i] = rand.nextInt((n*n*n)+1);
		}
		permuteByInsertionSort(A,P);
	}
	
	private static void permuteByInsertionSort(int[] A, int[] B) {
		for(int j = 1; j < A.length; j++) {
			int sorting_key = B[j];
			int parallel_key = A[j];
			
			int i = j - 1;
			while(i >= 0 && B[i] > sorting_key) {
				A[i+1] = A[i];
				B[i+1] = B[i];
				i = i - 1;
			}
			B[i+1] = sorting_key;
			A[i+1] = parallel_key;
		}
	}

}
