package algorithms;

public class MatrixMultiplication {
	
	public static int[][] strassen(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		
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
		
		int[][] s1 = new int[n/2][n/2];
		int[][] s2 = new int[n/2][n/2];
		int[][] s3 = new int[n/2][n/2];
		int[][] s4 = new int[n/2][n/2];
		int[][] s5 = new int[n/2][n/2];
		int[][] s6 = new int[n/2][n/2];
		int[][] s7 = new int[n/2][n/2];
		int[][] s8 = new int[n/2][n/2];
		int[][] s9 = new int[n/2][n/2];
		int[][] s10 = new int[n/2][n/2];
		
		s1 = sub(par_b01,par_b11);
		s2 = add(par_a00,par_a01);
		s3 = add(par_a10,par_a11);
		s4 = sub(par_b10,par_b00);
		s5 = add(par_a00,par_a11);
		s6 = add(par_b00,par_b11);
		s7 = sub(par_a01,par_a11);
		s8 = add(par_b10,par_b11);
		s9 = sub(par_a00,par_a10);
		s10 = add(par_b00,par_b01);
		
		int[][] p1 = new int[n/2][n/2];
		int[][] p2 = new int[n/2][n/2];
		int[][] p3 = new int[n/2][n/2];
		int[][] p4 = new int[n/2][n/2];
		int[][] p5 = new int[n/2][n/2];
		int[][] p6 = new int[n/2][n/2];
		int[][] p7 = new int[n/2][n/2];
		
		p1 = recursiveMultiply(par_a00,s1);
		p2 = recursiveMultiply(s2,par_b11);
		p3 = recursiveMultiply(s3,par_b00);
		p4 = recursiveMultiply(par_a11,s4);
		p5 = recursiveMultiply(s5,s6);
		p6 = recursiveMultiply(s7,s8);
		p7 = recursiveMultiply(s9,s10);
		
		par_c00 = add(sub(add(p5,p4),p2),p6);
		par_c01 = add(p1,p2);
		par_c10 = add(p3,p4);
		par_c11 = sub(sub(add(p5,p1),p3),p7);
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				C[i][j] = par_c00[i][j];
				C[i][j+(n/2)] = par_c01[i][j];
				C[i+(n/2)][j] = par_c10[i][j];
				C[i+(n/2)][j+(n/2)] = par_c11[i][j];
			}
		}
		return C;	
	}
	
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
	
	public static int[][] sub(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				C[i][j] = A[i][j]-B[i][j];
			}
		}
		return C;
	}
	
	
}
