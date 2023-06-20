package searching_sorting;

import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Random rnd = new Random();
		Integer[] arr = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = rnd.nextInt(1000);
		}
		
		selectionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();

		/*
		 * for(int i = 0; i < 100; i++) { int index = r_seqSearch(arr, i, 0); if(index
		 * == -1) System.out.printf("the value %d is not in the array\n", i); else
		 * System.out.printf("arr[%d] = %d\n", index, i); }
		 */

	}

	// searching
	public static <T extends Comparable<T>> int seqSearch(T[] lst, int value) {
		// return the index of value
		// return -1 if value is not in the array
		for (int i = 0; i < lst.length; i++) {
			if (lst[i].equals(value))
				return i;
		}
		return -1;
	}
	
	//recursive searching
	public static <T extends Comparable<T>> int r_seqSearch(T[] lst, int value, int startIndex) {
		if(startIndex == lst.length) return -1;
		else if(lst[startIndex].equals(value))return startIndex;
		else return r_seqSearch(lst, value, startIndex + 1);
	}
	
	//sorting
	
	public static <T extends Comparable<T> > void selectionSort(T [] lst) {
		for(int i = 0; i < lst.length; i++) {
			int bigIndex  = findLargest(lst, lst.length - i - 1);
			swap(lst, bigIndex, lst.length - i - 1);
		}
	}
	
	private static <T extends Comparable<T> > void swap(T[] lst, int index1, int index2) {
		T temp = lst[index1];
		lst[index1] = lst[index2];
		lst[index2] = temp;
	}
	private static <T extends Comparable<T> > int findLargest(T[] lst, int endIndex){
		int bigIndex = 0;
		for(int i = 1; i < endIndex; i++) {
			if(lst[i].compareTo(lst[bigIndex])>0)
				bigIndex = i;
		}
		return bigIndex;
	}

}
