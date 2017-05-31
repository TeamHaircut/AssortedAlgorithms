package algorithms;

public class MergeSort {
	
	public static int[] sort(int[] A, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p + r)/2);
			A = sort(A,p,q);
			A = sort(A,q+1,r);
			A = merge(A,p,q,r);
		}
		return A;
	}
	
	public static int[] merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1+1];//n1+1?
		int[] R = new int[n2+1];//n2+1?
		for(int i = 0; i < n1; i++) {
			L[i] = A[p+i+1];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = A[q+j];
		}
		//inf
		//inf
		int i = 1;
		int j = 1;
		for(int k = p; k < r; k++) {
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i = i + 1;
			}
			else {
				A[k] = R[j];
				j = j + 1;
			}
		}
		
		return A;
	}

}
