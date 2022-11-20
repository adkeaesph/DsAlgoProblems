package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class MiddleElementDeletion {

	private static StackUsingLinkedList<Integer> deleteMidElement(StackUsingLinkedList<Integer> stk) throws StackException {
		if (stk.size() <= 1)
			return new StackUsingLinkedList<Integer>();
		
		int nth=stk.size()/2+1;
		return coreDeleteMidElement(stk, nth);
	}

	private static StackUsingLinkedList<Integer> coreDeleteMidElement(StackUsingLinkedList<Integer> stk, int nth) 
			throws StackException {
		Integer popped = stk.pop();
		if(nth!=1) {
			stk=coreDeleteMidElement(stk, nth-1);
			stk.push(popped);
		}
		return stk;
	}

	public static void main(String[] args) throws StackException {
		StackUsingLinkedList<Integer> stk = new StackUsingLinkedList<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		stk.display();
		stk = deleteMidElement(stk);
		stk.display();

	}

}
