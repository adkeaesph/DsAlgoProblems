package problems;

import corestructures.SinglyNode;
import utils.ListUtil;

public class Sorting {

	public static SinglyNode<Integer> insertNodeInASortedList(SinglyNode<Integer> head, Integer data) {
		SinglyNode<Integer> nodeToBeInserted = new SinglyNode<>(data);
		if (head == null) {
			head = nodeToBeInserted;
			return head;
		} else {
			if (head.getData() == null) {
				head.setData(data);
				return head;
			} else {
				if (data < head.getData()) {
					nodeToBeInserted.setNext(head);
					head = nodeToBeInserted;
					return head;
				}
			}

		}

		SinglyNode<Integer> previousNode = head;
		SinglyNode<Integer> nextNode = head.getNext();

		while (nextNode != null) {
			if (data < nextNode.getData()) {
				previousNode.setNext(nodeToBeInserted);
				nodeToBeInserted.setNext(nextNode);
				return head;
			}
			previousNode = previousNode.getNext();
			nextNode = nextNode.getNext();
		}
		previousNode.setNext(nodeToBeInserted);
		return head;
	}

	public static <T> SinglyNode<T> reverseList(SinglyNode<T> head) {
		SinglyNode<T> nextNode, previousNode = 	null;

		while (head.getNext() != null) {
			nextNode = head.getNext();
			head.setNext(previousNode);
			previousNode = head;
			head = nextNode;
		}
		head.setNext(previousNode);
		return head;
	}
	
	public static SinglyNode<Integer> mergeTwoSortedLists(SinglyNode<Integer> head, SinglyNode<Integer> head2) {
		if(head == null ) 
			return head2;
		
		if(head2 == null) 
			return head;
		
		SinglyNode<Integer> head3 = null, curr = head, curr2 = head2, curr3 = head3;
		
		while(curr != null && curr2 != null) {
			if(curr.getData() <= curr2.getData()) {
				if(head3 == null) {
					head3 = curr;
					curr3 = head3;
				} else {
					curr3.setNext(curr);
					curr3 = curr3.getNext();
				}
				curr = curr.getNext();
					
			} else {
				if(head3 == null) {
					head3 = curr2;
					curr3 = head3;
				} else {
					curr3.setNext(curr2);
					curr3 = curr3.getNext();
				}
				curr2 = curr2.getNext();
			}
		}
		
		if(curr != null)
			curr3.setNext(curr);
		if(curr2 != null)
			curr3.setNext(curr2);
	
		return head3;
	}
	
//	public static <T> SinglyNode<T> reverseNnodes(SinglyNode<T> head, int n) {
//		SinglyNode<T> curr = head, curr2;
//		while(curr!=null) {
//			curr2 = curr;
//			for(int i=0;i<n-1;i++) {
//				curr2 = curr2.getNext();
//			}
//			
//		}
//	}

	public static void main(String[] args) {
		SinglyNode<Integer> head = new SinglyNode<>();
		head = insertNodeInASortedList(head, 45);
		head = insertNodeInASortedList(head, 56);
		head = insertNodeInASortedList(head, 22);
		head = insertNodeInASortedList(head, 54);
		head = insertNodeInASortedList(head, 45);
		ListUtil.displayList(head);
		
		SinglyNode<Integer> head2 = new SinglyNode<>();
		head2 = insertNodeInASortedList(head2, 10);
		head2 = insertNodeInASortedList(head2, 30);
		head2 = insertNodeInASortedList(head2, 49);
		head2 = insertNodeInASortedList(head2, 90);
		ListUtil.displayList(head2);
		
		SinglyNode<Integer> head3 = mergeTwoSortedLists(head, head2);
		ListUtil.displayList(head3);
		
		head = reverseList(head);
		ListUtil.displayList(head);
	}

}
