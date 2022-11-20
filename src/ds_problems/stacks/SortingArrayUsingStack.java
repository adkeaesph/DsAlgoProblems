package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class SortingArrayUsingStack {

	public static Integer[] sortArray(Integer[] arr) throws StackException {
		StackUsingLinkedList<Integer> sortedStk = new StackUsingLinkedList<Integer>();
		StackUsingLinkedList<Integer> auxStk = new StackUsingLinkedList<Integer>();

		int len = arr.length;
		for (int i = 0; i < len; i++) {	//	another way is maintain only one stack in order; when a number 
										//  comes that cant be stacked, pop and store in the array itself 
										//	until it can be stacked. repeat till all are in order
			if (sortedStk.isEmpty())
				sortedStk.push(arr[i]);
			else {
				if (sortedStk.peek() <= arr[i])
					sortedStk.push(arr[i]);
				else {
					while (!sortedStk.isEmpty() && sortedStk.peek() > arr[i]) {
						auxStk.push(sortedStk.pop());
					}
					sortedStk.push(arr[i]);
					while (!auxStk.isEmpty()) {
						sortedStk.push(auxStk.pop());
					}
				}
			}
		}
		int i=arr.length-1;
		while(!sortedStk.isEmpty()) {
			arr[i]=sortedStk.pop();
			i--;
		}
		return arr;
	}

	public static void main(String[] args) throws StackException {
		Integer[] arr = { 2, 4, 1, 3, 7, 2, 9, 3 };
		arr=sortArray(arr);
		
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
	}

}
