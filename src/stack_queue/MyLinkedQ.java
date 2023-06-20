package stack_queue;

import stack_queue.MyLinkedStack.Node;

public class MyLinkedQ implements MyQueue {
	
	class Node{
		public Object data;
		public Node next;
		public Node(Object d, Node n) {
			data = d;
			next = n;
		}
		public Node(Object d) {
			this(d, null);
		}
		public Node() {
			this(null, null);
		}
	}

	private Node front;
	private int size;
	
	public MyLinkedQ() {
		front = null;
		size = 0;
	}

	//add item to end of the queue
	@Override
	public void enqueue(Object item) {
		
		if(front == null) {
			front = new Node(item);
			size++;
		}
		else {
			//find end of queue
			Node curr = front;
			while(curr.next != null) {
				curr = curr.next;
			}
			//curr.next is null, so add node here
			curr.next = new Node(item);
			size++;
		}

	}

	@Override
	public Object dequeue() {
		//remove node at index front
		Object result = null;
		if(size > 0) {
			result = front.data;
			front = front.next;
			size--;
			return result;
		}
		return null;
	}

	@Override
	public Object peek() {
		return front.data;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getIndex(Object item) {
		//find the item
		int i = 0;
		Node curr = front;
		while(curr != null && !item.equals(curr.data)) {
			curr = curr.next;
			i++;
		}
		if(curr == null)return -1;
		else return i;
	}

}
