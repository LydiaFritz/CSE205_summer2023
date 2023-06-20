package stack_queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {

		MyStack stk = new MyLinkedStack();
		Scanner fin = new Scanner(new File("MyArrayQ.java"));

		String str;
		while (fin.hasNext()) {
			str = fin.nextLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(')
					stk.push(str.charAt(i));
				else if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
					if (stk.isEmpty()) {
						System.out.println("The stack is empty, missing lhs symbol");
					} else if (isMatch((char) stk.peek(), str.charAt(i))) {
						stk.pop();
					} else {
						System.out.println("not a match, parens unbalanced");
						System.exit(10);
					}
				}

			}

		}
		if (stk.isEmpty()) {
			System.out.println("Parenthese match");
		} else {
			System.out.println("Stuff is still on the stack");
		}

	}

	public static boolean isMatch(char ch1, char ch2) {
		if (ch1 == '[' && ch2 == ']')
			return true;
		if (ch1 == '{' && ch2 == '}')
			return true;
		if (ch1 == '(' && ch2 == ')')
			return true;
		return false;
	}

}
