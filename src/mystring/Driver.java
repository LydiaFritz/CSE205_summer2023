/**
 * 
 */
package mystring;

/**
 * @author lfritz4
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyString s1 = new MyString("Chicken");
		MyString s2 = new MyString(s1);
		
		System.out.println(s1);
		System.out.println(s2);

	}

}
