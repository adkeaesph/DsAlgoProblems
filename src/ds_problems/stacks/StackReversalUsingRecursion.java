package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class StackReversalUsingRecursion {
	
	public static StackUsingLinkedList<Integer> reverseStack(StackUsingLinkedList<Integer> stk) throws StackException {
		StackUsingLinkedList<Integer> result=new StackUsingLinkedList<>();
		coreReverseStack(stk,result);
		return result;
	}
	
	public static StackUsingLinkedList<Integer> coreReverseStack(StackUsingLinkedList<Integer> stk, StackUsingLinkedList<Integer> res) throws StackException{
		if(stk.isEmpty())
			return res;
		
		res.push(stk.pop());
		return coreReverseStack(stk, res);
	}
	public static void main(String[] args) throws StackException {
		StackUsingLinkedList<Integer> stk=new StackUsingLinkedList<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.display();
		stk=reverseStack(stk);
		stk.display();
	}
}
