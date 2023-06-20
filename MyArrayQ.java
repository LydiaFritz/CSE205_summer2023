package stack_queue;

import stack_queue.MyQueue;

public class MyArrayQ implements MyQueue {
	
	private Object [] qArr;
	private int size;
	
	//shifts elements forward 1 position
	private void shiftElements() {
		for(int i = 0; i < size-1; i++) {
			qArr[i] = qArr[i+1];
		}
	}
	
	public MyArrayQ() {
		qArr = new Object[5];
		size = 0;
	}
	
	public void ensureCapacity() {
		if(size == qArr.length) {
			Object [] temp = new Object[qArr.length*2];
			for(int i = 0; i < size; i++) {
				temp[i] = qArr[i];
			}
			qArr = temp;
		}
	}

	@Override
	public void enqueue(Object item) {
		ensureCapacity();
		qArr[size++] = item;
	}

	@Override
	public Object dequeue() {
		Object result = null;
		if(size > 0) {
			result = qArr[0];
			shiftElements();
		}
		size--;
		return result;
	}

	@Override
	public Object peek() {
		Object result = null;
		if(size > 0)
			result = qArr[0];
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
		for(int i = 0; i < size; i++) {
			if(item.equals(qArr[i]))
				return i;
		}
		return result;
	}

}
