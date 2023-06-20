package quick_sort;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Random rnd = new Random();
		int [] values = new int[5];
		for(int i = 0; i < values.length; i++) {
			values[i] = rnd.nextInt(40);
		}
		
		showArray(values);
		
		qSort(values, 0, values.length-1);
		
		showArray(values);

	}
	
	public static void showArray(int [] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.printf("%d ", arr[i]);
		
		System.out.println();
	}
	
	public static void qSort(int [] arr, int startIndx, int endIndx) {
		if(startIndx < endIndx) {
			int pivot = partition(arr, startIndx, endIndx);
			qSort(arr, startIndx, pivot-1);
			qSort(arr, pivot+1, endIndx);
		}
	}
	
	private static void swap(int [] arr, int indxA, int indxB)
	{
		int temp = arr[indxA];
		arr[indxA] = arr[indxB];
		arr[indxB] = temp;
	}
	
	private static int partition(int arr[], int begin, int end) {
		//let pivot be last element in the array
	    int pivot = arr[end];
	    int endOfLeft = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	        	endOfLeft++;

	            int swapTemp = arr[endOfLeft];
	            arr[endOfLeft] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[endOfLeft+1];
	    arr[endOfLeft+1] = arr[end];
	    arr[end] = swapTemp;

	    return endOfLeft+1;
	}

}
