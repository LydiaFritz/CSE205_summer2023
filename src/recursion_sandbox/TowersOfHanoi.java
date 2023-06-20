package recursion_sandbox;

public class TowersOfHanoi {
	public static void main(String[] args) {

		// hanoi(3, "A", "C", "B");
		printLeft(10);
		printRight(10, 5);
	}

	public static void hanoi(int numRings, String start, String finish, String temp) {
		if (numRings == 1)
			System.out.printf("Moving ring from %s to %s\n", start, finish);
		else {
			hanoi(numRings - 1, start, temp, finish);
			System.out.printf("Moving ring from %s to %s\n", start, finish);
			hanoi(numRings - 1, temp, finish, start);
		}
	}
	
	public static void printLeft(int chars) {
		if(chars == 0)System.out.println();
		else {
			System.out.print("*");
			printLeft(chars-1);
		}
	}
	
	public static void printRight(int chars, int spaces) {
		if(spaces == 0)
			printLeft(chars);
		else {
			System.out.print(" ");
			printRight(chars, spaces-1);
		}
	}


}
