package recursion_sandbox;

public class RecursionDriver {

	public static void main(String[] args) {
		changePi("pipi");
	}

	// iterative method that prints a string in reverse
	public static void iter_printString(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.printf("%3s", str.charAt(i));
		}
		System.out.println();
	}

	// recursive method that prints a string in reverse
	public static void recur_printString(String str) {
		if (str.length() == 0) {
			System.out.println();
		} else {
			// print last character
			System.out.printf("%3s", str.charAt(str.length() - 1));
			// call method with substring(0, str.length()-1)
			recur_printString(str.substring(0, str.length() - 1));
		}
	}
	
	public static int fib(int n) {
		//calculate and return the nth term in the Fib sequence
		if(n == 0 || n == 1) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static int count8(int n) {
		  if(n == 0) return 0;
		  else if(n % 100 == 88) return 2 + count8(n/10);
		  else if(n % 10 == 8) return 1 + count8(n/10);
		  else return 0 + count8(n/10);
		}
	
	public static String changePi(String str) {
		  if(str.length() == 0)return "";
		  else if(str.length() == 1)return str.substring(0,1);
		  else if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
		    return "3.14" + changePi(str.substring(2));
		  }
		  else return str.charAt(0) + changePi(str.substring(1));
		}
}
