package algorithms;

public class MatrixMultiplication {
	
	public static int[][] recursiveMultiply(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		if(n == 1) {
			C[0][0] = A[0][0]*B[0][0];
		}
		else {
			int[][] par_a00 = new int[n/2][n/2];
			int[][] par_a01 = new int[n/2][n/2];
			int[][] par_a10 = new int[n/2][n/2];
			int[][] par_a11 = new int[n/2][n/2];
			
			int[][] par_b00 = new int[n/2][n/2];
			int[][] par_b01 = new int[n/2][n/2];
			int[][] par_b10 = new int[n/2][n/2];
			int[][] par_b11 = new int[n/2][n/2];
			
			int[][] par_c00 = new int[n/2][n/2];
			int[][] par_c01 = new int[n/2][n/2];
			int[][] par_c10 = new int[n/2][n/2];
			int[][] par_c11 = new int[n/2][n/2];
			
			//partition using copy
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < n/2; j++) {
					par_a00[i][j] = A[i][j];
					par_a01[i][j] = A[i][j+(n/2)];
					par_a10[i][j] = A[i+(n/2)][j];
					par_a11[i][j] = A[i+(n/2)][j+(n/2)];
											
					par_b00[i][j] = B[i][j];
					par_b01[i][j] = B[i][j+(n/2)];
					par_b10[i][j] = B[i+(n/2)][j];
					par_b11[i][j] = B[i+(n/2)][j+(n/2)];
				}
			}
			
			par_c00 = add(recursiveMultiply(par_a00,par_b00),recursiveMultiply(par_a01,par_b10));
			par_c01 = add(recursiveMultiply(par_a00,par_b01),recursiveMultiply(par_a01,par_b11));
			par_c10 = add(recursiveMultiply(par_a10,par_b00),recursiveMultiply(par_a11,par_b10));
			par_c11 = add(recursiveMultiply(par_a10,par_b01),recursiveMultiply(par_a11,par_b11));
			
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < n/2; j++) {
					C[i][j] = par_c00[i][j];
					C[i][j+(n/2)] = par_c01[i][j];
					C[i+(n/2)][j] = par_c10[i][j];
					C[i+(n/2)][j+(n/2)] = par_c11[i][j];
				}
			}
		}
		return C;
	}
	
	public static int[][] multiply(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				C[i][j] = 0;
				for(int k = 0; k < n; k++) {
					C[i][j] = C[i][j] + A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}
	
	public static int[][] add(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				C[i][j] = A[i][j]+B[i][j];
			}
		}
		return C;
	}
	
	
}
