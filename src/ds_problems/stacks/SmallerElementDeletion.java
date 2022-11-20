package ds_problems.stacks;

import customexceptions.StackException;
import complexstructures.SinglyLinkedList;
import complexstructures.StackUsingLinkedList;
import customexceptions.ListException;

/* Problem Statement : Given an array arr[] and a number k. The task is to delete k elements which are 
 * smaller than next element (i.e., we delete arr[i] if arr[i] < arr[i+1]) or become 
 * smaller than next because next element is deleted.
 */
public class SmallerElementDeletion {

	public static SinglyLinkedList<Integer> deleteSmallerElements(Integer[] arr, int k) throws StackException, ListException {
		int len = arr.length;
		StackUsingLinkedList<Integer> stk = new StackUsingLinkedList<>();
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (stk.isEmpty())
				stk.push(arr[i]);
			else {
				while (!stk.isEmpty() && stk.peek() < arr[i] && j != k) {
					stk.pop();
					j++;
				}
				stk.push(arr[i]);
			}
		}

		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		while (!stk.isEmpty()) {
			sll.add(stk.pop(),0);
		}

		return sll;
	}

	public static void main(String[] args) throws StackException, ListException {
		// Integer[] arr= {3, 100, 1 };
		// int k=1;
		// Integer[] arr = {20, 10, 25, 30, 40};
		// int k = 2;
		Integer[] arr = { 23, 45, 11, 77, 18 };
		int k = 3;

		SinglyLinkedList<Integer> sll = deleteSmallerElements(arr, k);
		System.out.println(sll);
	}

}
