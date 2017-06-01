package algorithms;

public class MaximumSubArray {
	
	public static int[] find(int[] A, int low, int high) {
		if(high == low) {
			return new int[]{low,high,A[low]};
		}
		else {
			int mid = (int)Math.floor((low+high)/2);
			int[] L = find(A,low,mid);
			int[] R = find(A,mid+1,high);
			int[] C = findMaxCrossing(A,low,mid,high);
			if((L[2] >= R[2])&&(L[2] >= C[2])) {
				return new int[]{L[0],L[1],L[2]};
			}
			else if((R[2] >= L[2])&&(R[2] >= C[2])) {
				return new int[]{R[0],R[1],R[2]};
			}
			else {
				return new int[]{C[0],C[1],C[2]};
			}
		}
	}
	
	private static int[] findMaxCrossing(int[] A, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int maxLeft = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = mid; i >= low; i--) {
			sum = sum + A[i];
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;
		sum = 0;
		for(int j = mid+1; j <= high; j++) {
			sum = sum + A[j];
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		return new int[]{maxLeft,maxRight,leftSum+rightSum};
	}

}
