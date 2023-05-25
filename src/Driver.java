import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner fin;
		int value = 0;
		try {
			fin = new Scanner(new File("test.txt"));
			System.out.println("Opening file...");
			while (fin.hasNext())
				value += fin.nextInt();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		finally {
			System.out.println("End of processing");
		}
		
		
	}

}
