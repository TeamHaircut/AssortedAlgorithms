package testcases;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;
import algorithms.BubbleSort;
import algorithms.HeapSort;
import algorithms.InsertionSort;
import algorithms.MaximumSubArray;
import algorithms.MergeSort;
import algorithms.PermutationSort;
import algorithms.Randomize;
import algorithms.MatrixMultiplication;

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
	public void heapSortTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		HeapSort.sort(A);
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
	public void sqMatrixMultiplyTest() {
		int[][] A = new int[][]{
				{0,2},
				{5,4}
		};
		int[][] B = new int[][]{
				{1,9},
				{7,6}
		};
		int[][] C = MatrixMultiplication.multiply(A,B);
		assertArrayEquals(new int[][]{{14,12},{33,69}},C);
	}
	
	@Test
	public void randomizeInPlaceTest() {
		int[] A = new int[]{5,3,1,7,20,45,16};
		Randomize.inPlace(A);
		assertFalse(Arrays.equals(new int[]{5,3,1,7,20,45,16}, A));
	}
	
	@Test
	public void sqRecursiveMatrixMultiplyTest() {
		int[][] A = new int[][]{
				{2,3,7,8},
				{4,5,6,9},
				{1,2,3,4},
				{2,6,3,7}
		};
		int[][] B = new int[][]{
				{6,7,3,8},
				{8,9,2,9},
				{4,5,6,4},
				{1,6,8,2}
		};
		int[][] test = MatrixMultiplication.multiply(A, B);
		int[][] C = MatrixMultiplication.recursiveMultiply(A,B);
		assertArrayEquals(test,C);
	}
	
	@Test
	public void strassenTest() {
		int[][] A = new int[][]{
				{2,3,7,8},
				{4,5,6,9},
				{1,2,3,4},
				{2,6,3,7}
		};
		int[][] B = new int[][]{
				{6,7,3,8},
				{8,9,2,9},
				{4,5,6,4},
				{1,6,8,2}
		};
		int[][] test = MatrixMultiplication.multiply(A, B);
		int[][] C = MatrixMultiplication.strassen(A,B);
		assertArrayEquals(test,C);
	}
	
	@Test
	public void permuteBySortingTest() {
		int[] A = new int[] {1,2,3,4};
		PermutationSort.permuteBySorting(A);
		assertFalse(Arrays.equals(new int[]{1,2,3,4}, A));
	}

}
