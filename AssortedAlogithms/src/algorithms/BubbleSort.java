package algorithms;

public class BubbleSort {
	
	public static void sort(int[] A) {
		for(int i = 0; i < A.length-1; i++) {
			for(int j = A.length-1; j > i; j--) {
				if(A[j] < A[j-1]) {
					int temp = A[j];
					A[j] = A[j-1];
					A[j-1] = temp;
				}
			}
		}
	}
	
}
