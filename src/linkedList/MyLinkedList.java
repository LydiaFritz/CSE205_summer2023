/**
 * 
 */
package linkedList;

/**
 * @author lfritz4
 *
 */
public class MyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//internal class
	class Node{
		public Object data;
		public Node next;
	}
	
	//instance variables
	private Node front;
	private int size;
	
	//constructor
	MyLinkedList(){
		front = null;
		size = 0;
	}
	

}
