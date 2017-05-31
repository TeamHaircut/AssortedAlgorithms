package testcases;

import org.junit.Test;
import static org.junit.Assert.*;
import algorithms.InsertionSort;

public class AlgorithmTestCase {
	
	@Test
	public void insertionSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		A = InsertionSort.sort(A);
		assertArrayEquals(new int[]{1,3,5,7,16,20,45},A);
	}
	
	@Test
	public void mergeSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		int p = 0;
		int r = A.length - 1;
		A = MergeSort.sort();
		assertArrayEquals(new int[]{1,3,5,7,16,20,45},A);
	}

}
