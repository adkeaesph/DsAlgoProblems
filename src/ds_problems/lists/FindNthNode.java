package ds_problems.lists;

import complexstructures.List;
import complexstructures.SinglyLinkedList;
import corestructures.SinglyNode;
import customexceptions.ListException;

public class FindNthNode {

	private static <T> T findNthNodeFromLast(List<T> list, int n) throws ListException {
		int sizeOfList = list.getSize();
		if (n < 0 || n >= sizeOfList)
			throw new ListException(
					"Size of list is " + sizeOfList + ". Hence, n can be 0 to " + (sizeOfList - 1) + "(inclusive).");
		return list.get(list.getSize() - 1 - n);
	}

	private static <T> T findNthNodeFromLastEfficiently(SinglyNode<T> head, int n) throws ListException {
		if (n < 0)
			throw new ListException("position of a list can never be negative.");
		SinglyNode<T> fastPointer = head;
		SinglyNode<T> slowPointer = head;
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				if (fastPointer.getNext() == null)
					throw new ListException("n is greater than size - 1");
				else
					fastPointer = fastPointer.getNext();
			}
		}

		while (fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}

		return slowPointer.getData();
	}
	
	public static void main(String[] args) throws ListException {
		List<Integer> list = new SinglyLinkedList<>();
		list.add(11);
		list.add(12);
		list.add(13);
		System.out.println(FindNthNode.findNthNodeFromLast(list, 0));
		System.out.println(FindNthNode.findNthNodeFromLast(list, 1));
		System.out.println(FindNthNode.findNthNodeFromLast(list, 2));
//		System.out.println(FindNthNode.findNthNodeFromLast(list, 3));
		
		System.out.println("-----------------------------------------------------------");
		
		SinglyNode<Integer> head = new SinglyNode<>(23);
		head.setNext(new SinglyNode<Integer>(34, new SinglyNode<Integer>(45, new SinglyNode<Integer>(56))));
		
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 0));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 1));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 2));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 3));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 4));
	}	

}
