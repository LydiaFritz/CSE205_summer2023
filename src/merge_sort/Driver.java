package merge_sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Lydia K Fritz
// CST201
// Date: Jan 4, 2019
// This is my own work.

public class Driver {

	static int comparisons = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner fin = new Scanner(new File("input.in"));
			ArrayList<String> mylst = new ArrayList<String>();
			while(fin.hasNext()){
				String str = fin.next();
				mylst.add(str);				
			}
			
			mergeSort(mylst, 0, mylst.size()-1);
			
			//output the array
			for (String string : mylst) {
				System.out.println(string);
			}
			
			System.out.println("\nThere were " + mylst.size() + " words in the list.");
			System.out.println(comparisons + " comparisons were required to order the words.");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found\n");
		}
		
		

	}
	
	public static void mergeSort(ArrayList<String> lst, int p, int r){
		//if there are more than one item in the list
		if(p < r){
			int q = (p+r)/2;
			//mergesort each half
			mergeSort(lst, p, q);
			mergeSort(lst, q+1, r);
			//then merge them together
			merge(lst, p, q, r);
		}
	}
	
	
	//merge two sorted sublists
	//A[p]...A[q] and A[q+1]...a[r]
	//to form a single sorted subarray that replaces the
	//current subarray A[p...r]
	public static void merge(ArrayList<String> lst, int p, int q, int r){
		//n1 and n2: # of things to process in ea sublist
		int n1 = q - p + 1;
		int n2 = r - q;
		//create arrays for each sublist
		String [] leftLst = new String[n1];
		String [] rightLst = new String[n2];
		for(int i = 0; i < n1; i++){
			leftLst[i] = lst.get(p + i);			
		}
		for(int j = 0; j < n2; j++){
			rightLst[j] = lst.get(q + j + 1);
		}
		
		//merge the two lists together back into lst
		int l_indx = 0, r_indx = 0;
		for(int i = p; i <= r; i++){
			if(l_indx < n1 && r_indx < n2){
				//count the comparisons
				comparisons++;
				if(leftLst[l_indx].compareTo(rightLst[r_indx]) < 0)
					lst.set(i, leftLst[l_indx++]);
					
				else
					lst.set(i, rightLst[r_indx++]);
			}
			else if(l_indx < n1){
				lst.set(i, leftLst[l_indx++]);
			}
			else{
				lst.set(i, rightLst[r_indx++]);
			}
		}
		
	}

}