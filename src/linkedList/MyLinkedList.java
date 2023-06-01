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
		MyLinkedList test = new MyLinkedList();
		test.append("do");
		test.append("re");
		test.append("mi");
		test.append("fa");
		test.append("sol");
		test.append("la");
		test.insertAt(1, "tra-la-la");
		
		for(int i = 0; i < test.getSize(); i++) {
			System.out.printf("%s  ", test.getAt(i));
		}
		System.out.println();
		
		test.removeAt(2);
		
		for(int i = 0; i < test.getSize(); i++) {
			System.out.printf("%s  ", test.getAt(i));
		}

	}
	
	//internal class
	class Node{
		
		public Object data;
		public Node next;
		
		//constructor for convenience
		public Node() {
			data = next = null;
		}
		public Node(Object o) {
			data = o;
			next = null;
		}		
		public Node(Object o, Node next) {
			data = o;
			this.next = next;
		}
				
	}
	
	//instance variables
	private Node front;
	private int size;
	
	//constructor
	MyLinkedList(){
		front = null;
		size = 0;
	}
	
	public void append(Object e) {
		//make a node
		Node newNode = new Node(e);
		if(front == null) {
			front = newNode;
		}
		else {
			//find the end
			Node curr = front;
			while(curr.next != null) {
				curr = curr.next;
			}
			//curr.next is null, so put node here
			curr.next = newNode;			
		}
		//update size
		size++;		
	}
	
	public Object getAt(int index) {
		
		Object result;
		Node curr = front;
		for(int i = 0; i < index; i++)
			curr = curr.next;
		result = curr.data;
		return result;
		
	}
	
	public int getSize() {return size;}
	
	public void insertAt(int index, Object element) {
		
		//make a new node
		Node newNode = new Node(element);
		
		//if index is n, find node at position n-1
		Node curr = front;
		for(int i = 0; i < index - 1; i++) {
			curr = curr.next;
		}
		//curr is on index-1.
		newNode.next = curr.next;
		curr.next = newNode;
		
		//increase size
		size++;
	}
	
	public void removeAt(int index) {
		//find the node at index-1
		Node curr = front;
		for(int i = 0; i < index - 1; i++) {
			curr = curr.next;
		}
		//curr is on index-1
		curr.next = curr.next.next;
		//decrease size
		size--;
	}
	

}
