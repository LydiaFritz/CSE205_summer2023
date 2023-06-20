package stack_queue;

public interface MyQueue {

	public void enqueue(Object item);
	public Object dequeue();
	public Object peek();
	public int getSize();
	public boolean isEmpty();
	public int getIndex(Object item);
}
