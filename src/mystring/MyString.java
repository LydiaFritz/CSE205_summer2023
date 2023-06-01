/**
 * 
 */
package mystring;

/**
 * @author lfritz4
 *
 */
public class MyString {

	private int capacity = 5;
	private int size = 0;
	private char[] charArr = new char[capacity];

	private void ensureCapacity() {

		if (size < capacity)
			return;

		int newSize = size * 2;
		capacity = newSize;
		char[] newArr = new char[newSize];

		for (int i = 0; i < size; i++) {
			newArr[i] = charArr[i];
		}

		charArr = newArr;
	}

	private void ensureCapacity(int requestSz) {
		if (requestSz < capacity)
			return;

		capacity = requestSz;
		char[] newArr = new char[requestSz];

		for (int i = 0; i < size; i++) {
			newArr[i] = charArr[i];
		}

		charArr = newArr;
	}

	public MyString(String str) {
		
		ensureCapacity(str.length());
		
		for(int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		size = str.length();
		
	}
	
	public MyString(MyString str) {
		this(str.toString());
	}
	
	public String toString() {
		String str = "";
		for(Character ch : charArr) {
			str += ch;
		}
		return str;
	}

}