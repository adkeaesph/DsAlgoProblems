package ds_problems.lists;

import complexstructures.SinglyLinkedList;
import corestructures.SinglyNode;
import utils.ListUtil;

public class Reversals {

	public static SinglyLinkedList<Integer> reverseListWhenListIsGiven(SinglyLinkedList<Integer> originalList) {
		SinglyNode<Integer> prev = null, temp = originalList.getHead();
		SinglyNode<Integer> next;
		
		while(temp != null) {
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		
		originalList.setHead(prev);
		return originalList;
	}
	
	public static SinglyNode<Integer> reverseListWhenListHeadIsGiven(SinglyNode<Integer> head) {
		SinglyNode<Integer> prev = null, temp = head;
		SinglyNode<Integer> next;
		
		while(temp != null) {
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(7);
		list = reverseListWhenListIsGiven(list);
		ListUtil.displayList(list.getHead());
		
		SinglyNode<Integer> head = new SinglyNode<Integer>(2, 
				new SinglyNode<>(4, new SinglyNode<>(7, 
						new SinglyNode<>(10))));
		
		head = reverseListWhenListHeadIsGiven(head);
		ListUtil.displayList(head);
	}

}
