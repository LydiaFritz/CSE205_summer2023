package quick_sort;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Random rnd = new Random();
		int [] values = new int[rnd.nextInt(25)];
		for(int i = 0; i < values.length; i++) {
			values[i] = rnd.nextInt(40);
		}
		
		showArray(values);

	}
	
	public static void showArray(int [] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.printf("%d ", arr[i]);
	}

}
