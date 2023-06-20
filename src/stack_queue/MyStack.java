/**
 * 
 */
package stack_queue;

/**
 * @author lfritz4
 *
 */
public interface MyStack {
	
	public void push(Object item);
	public Object pop();
	public Object peek();
	public int getSize();
	public boolean isEmpty();
	public int getIndex(Object item);

}
