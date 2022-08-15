package complexstructures;

import java.util.Iterator;
import java.util.Stack;

import customexceptions.StackException;

public class MinMaxStack {
	private Stack<Integer> mainStack;
	private Stack<Integer> minimumsStack;
	private Stack<Integer> maximumsStack;
	
	public MinMaxStack() {
		mainStack = new Stack<>();
		minimumsStack = new Stack<>();
		maximumsStack = new Stack<>();
	}
	
	public void push(Integer value) {
		mainStack.push(value);
		
		if(minimumsStack.isEmpty())
			minimumsStack.push(value);
		else {
			if((int)value <= (int)minimumsStack.peek())
				minimumsStack.push(value);
		}
		
		if(maximumsStack.isEmpty()) {
			maximumsStack.push(value);
		} else {
			if((int)value > (int)maximumsStack.peek())
				maximumsStack.push(value);
		}
	}
	
	public Integer pop() throws StackException {
		if(mainStack.isEmpty())
			throw new StackException("stack is empty!");
		
		Integer popped = mainStack.pop();
		
		if((int)popped == (int)minimumsStack.peek())
			minimumsStack.pop();
		
		if((int)popped == (int)maximumsStack.peek())
			maximumsStack.pop();
		
		return popped;
	}
	
	public boolean isEmpty() {
		return mainStack.isEmpty();
	}
	
	public Integer getMinimum() throws StackException {
		if(mainStack.isEmpty())
			throw new StackException("stack is empty!");
		return minimumsStack.peek();
	}
	
	public Integer getMaximum() throws StackException {
		if(mainStack.isEmpty())
			throw new StackException("stack is empty!");
		return maximumsStack.peek();
	}
	
	public int size() {
		return mainStack.size();
	}
	
	public void displayMainStack() {
		Iterator<Integer> iterator = mainStack.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public void displayMinimumsStack() {
		Iterator<Integer> iterator = minimumsStack.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	public void displayMaximumsStack() {
		Iterator<Integer> iterator = maximumsStack.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

}
