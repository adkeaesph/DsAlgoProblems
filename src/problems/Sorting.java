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

	public static void main(String[] args) {
		SinglyNode<Integer> head = new SinglyNode<>();
		head = insertNodeInASortedList(head, 45);
		head = insertNodeInASortedList(head, 56);
		head = insertNodeInASortedList(head, 22);
		head = insertNodeInASortedList(head, 54);
		head = insertNodeInASortedList(head, 45);
		ListUtil.displayList(head);
		
		head = reverseList(head);
		ListUtil.displayList(head);
	}

}
