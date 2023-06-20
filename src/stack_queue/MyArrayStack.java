/**
 * 
 */
package stack_queue;

/**
 * @author lfritz4
 *
 */
public class MyArrayStack implements MyStack {
	
	private Object [] stkArr;
	private int size;
	
	public MyArrayStack() {
		stkArr = new Object[10];
		size = 0;
	}
	
	private void ensureCapacity() {
		if(size == stkArr.length) {
			Object [] temp = new Object[stkArr.length*2];
			
			for(int i = 0; i < size; i++) {
				temp[i] = stkArr[i];
			}
			
			stkArr = temp;
		}
	}

	@Override
	public void push(Object item) {
		ensureCapacity();
		stkArr[size++] = item;
	}

	@Override
	public Object pop() {
		Object result = null;
		if(size > 0) {
			result = stkArr[--size];
		}
		return result;
	}

	@Override
	public Object peek() {
		Object result = null;
		if(size > 0) {
			result = stkArr[size-1];
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
		int result = -1;
		//find the item
		for(int i = 0; i < size; i++) {
			if(item.equals(stkArr[i])) {
				return i;
			}
		}
		return result;
	}

}
