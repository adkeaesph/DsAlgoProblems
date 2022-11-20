package complexstructures;

import corestructures.SinglyNode;
import customexceptions.StackException;
import utils.ListUtil;

public class StackUsingLinkedList<T> implements Stack<T> {

	private SinglyNode<T> top;
	private int size;
	private String id;
	
	public StackUsingLinkedList() {
		super();
		top = new SinglyNode<>();
		size = 0;
	}

	@Override
	public void push(T data) throws StackException {
		if(size == Integer.MAX_VALUE) 
			throw new StackException("Stack is full. Push operation not possible.");
		
		if(size == 0) {
			top.setData(data);
		} else {
			SinglyNode<T> newTop = new SinglyNode<>(data);
			newTop.setNext(top);
			top = newTop;
		}
		size++;
	}

	@Override
	public T pop() throws StackException {
		if(size == 0)
			throw new StackException("Stack is empty. Pop operation not possible.");
		
		T poppedData = top.getData();
		if(size == 1) 
			top.setData(null);
		else {
			top = top.getNext();
		}
		size--;
		return poppedData;
	}

	@Override
	public T peek() throws StackException {
		if(size == 0)
			throw new StackException("Stack is empty. Peek operation not possible.");
		return top.getData();
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void display() {
		ListUtil.displayList(top);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public String getStackId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setStackId(String id) {
		this.id = id;
	}

}
