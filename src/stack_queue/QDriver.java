package stack_queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QDriver {

	public static void main(String[] args) throws FileNotFoundException {
		MyQueue q = new MyLinkedQ();
		Scanner fin = new Scanner(new File("MyArrayQ.java"));

		String str;
		while (fin.hasNext()) {
			str = fin.nextLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(')
					q.enqueue(str.charAt(i));
				else if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
					q.enqueue(str.charAt(i));
				}				
			}
		}
		showQ(q);
	}

	public static void showQ(MyQueue theQ) {
		while(!theQ.isEmpty()) {
			System.out.printf("%2s", theQ.dequeue());
		}
		System.out.println("\nThe queue is empty");
	}

	

}
