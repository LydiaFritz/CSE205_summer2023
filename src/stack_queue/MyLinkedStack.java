package stack_queue;

//front of stack is TOP of stack
public class MyLinkedStack implements MyStack {
	
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
	
	public MyLinkedStack() {
		front = null;
		size = 0;
	}
	
	@Override
	public void push(Object item) {
		Node nn = new Node(item, front);
		front = nn;
		size++;
	}

	@Override
	public Object pop() {
		Object result = null;
		if(size > 0) {
			result = front.data;
			front = front.next;
			size--;
		}
		return result;
	}

	@Override
	public Object peek() {
		Object result = null;
		if(size > 0) {
			result = front.data;
		}
		return result;
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
		//treating front as index 0
		int index = -1;
		Node curr = front;
		int currIndex = 0;
		while(curr != null) {
			if(curr.data.equals(item))
				return currIndex;
			curr = curr.next;
			currIndex++;
		}
		return index;
	}

}
