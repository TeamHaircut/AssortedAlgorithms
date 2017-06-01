package testcases;

import org.junit.Test;

import static org.junit.Assert.*;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MaximumSubArray;
import algorithms.MergeSort;
import algorithms.SquareMatrix;

public class AlgorithmTestCase {
	
	@Test
	public void insertionSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		InsertionSort.sort(A);
		assertArrayEquals(new int[]{1,3,5,7,16,20,45},A);
	}
	
	@Test
	public void mergeSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		MergeSort.sort(A,0,A.length-1);
		assertArrayEquals(new int[]{1,3,5,7,16,20,45},A);
	}
	
	@Test
	public void bubbleSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		BubbleSort.sort(A);
		assertArrayEquals(new int[]{1,3,5,7,16,20,45},A);
	}
	
	@Test
	public void maxSubArrayTest() {
		int[] A = new int[]{5,3,1,-9,20,45,16};
		int[] maxSubArray = MaximumSubArray.find(A,0,A.length-1);
		assertEquals(81,maxSubArray[2]);
	}
	
	@Test
	public void squareMatrixMultiplyTest() {
		int[][] A = new int[][]{
				{0,2},
				{5,4}
		};
		int[][] B = new int[][]{
				{1,9},
				{7,6}
		};
		int[][] C = SquareMatrix.multiply(A,B);
		assertArrayEquals(new int[][]{{14,12},{33,69}},C);
	}

}
