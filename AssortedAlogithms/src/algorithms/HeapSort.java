package algorithms;

public class HeapSort {

	private static int heapSize;
	
	public static void sort(int[] A) {
		heapSize = A.length;
		buildMaxHeap(A);
		for(int i = A.length-1; i >= 1; i--) {
			int temp = A[0]; 
            		A[0] = A[i]; 
            		A[i] = temp;
            		heapSize = heapSize - 1;
			maxHeapify(A,0);
		}
	}
	
	//maxHeapify - maintains the max heap property A[parent(i)] >= A[i]
	private static void maxHeapify(int[] A, int i) {
		int largest;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < heapSize && A[l] > A[i]) {
			largest = l;
		}
		else {
			largest = i;
		}
		if(r < heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if(largest != i) {
			int temp = A[i]; 
            		A[i] = A[largest]; 
            		A[largest] = temp;
			maxHeapify(A,largest);
		}
	}
	
	//buildMaxHeap - produces a max heap from an unordered array
	public static void buildMaxHeap(int[] A) {
		int n = A.length;
		for(int i = n/2 - 1; i >= 0; i--) {
			maxHeapify(A,i);
		}
	}
}
