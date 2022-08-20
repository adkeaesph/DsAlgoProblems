package ds_problems.stacks;



import complexstructures.Stack;
import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;
import utils.ListUtil;

public class SortStack {
	
	private static Stack<Integer> sortStackWithHighestAtTop(Stack<Integer> stack) throws StackException {
		Stack<Integer> auxStack = new StackUsingLinkedList<>();
		
		while(!stack.isEmpty()) {
			int poppedData = stack.pop();
			if(auxStack.isEmpty()) {
				auxStack.push(poppedData);
			} else {
				if(auxStack.peek() <= poppedData)
					auxStack.push(poppedData);
				else {
					while(!auxStack.isEmpty())
						stack.push(auxStack.pop());
					auxStack.push(poppedData);
				}	
			}
		}
		return auxStack;
	}
	
	private static Stack<Integer> sortStackWithLowestAtTop(Stack<Integer> stack) throws StackException {
		Stack<Integer> auxStack = new StackUsingLinkedList<>();
		
		while(!stack.isEmpty()) {
			int poppedData = stack.pop();
			if(auxStack.isEmpty()) {
				auxStack.push(poppedData);
			} else {
				if(auxStack.peek() >= poppedData)
					auxStack.push(poppedData);
				else {
					while(!auxStack.isEmpty())
						stack.push(auxStack.pop());
					auxStack.push(poppedData);
				}	
			}
		}
		return auxStack;
	}

	public static void main(String[] args) throws StackException {
		Stack<Integer> stack = new StackUsingLinkedList<>();
		stack.push(2);
		stack.push(4);
		stack.push(1);
		stack.push(8);
		stack.push(7);
		stack.push(2);
		stack.display();
		
		Stack<Integer> descendingStack = sortStackWithHighestAtTop(stack);
		descendingStack.display();
		
		Stack<Integer> ascendingStack = sortStackWithLowestAtTop(descendingStack);
		ascendingStack.display();
	}

}
