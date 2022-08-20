package complexstructures;

import customexceptions.StackException;

public interface Stack<T> {
	void push(T data) throws StackException;
	T pop() throws StackException;
	T peek() throws StackException;
	int size();
	void display();
	boolean isEmpty();
}
