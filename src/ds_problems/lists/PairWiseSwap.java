package ds_problems.lists;

import corestructures.SinglyNode;
import utils.ListUtil;

public class PairWiseSwap {
	
	private static <T> SinglyNode<T> pairwiseSwap(SinglyNode<T> head) {
		if(head == null || head.getNext() == null)
			return head;
		
		SinglyNode<T> temp = head, prev = null;
		SinglyNode<T> curr1, curr2, next;
		
		while(temp != null && temp.getNext() != null) {
			curr1 = temp;
			curr2 = temp.getNext();
			next = curr2.getNext();
			if(temp == head) {
				head = curr2;
				head.setNext(curr1);
				prev = head.getNext();
				prev.setNext(next);
			} else {
				prev.setNext(curr2);
				prev.getNext().setNext(curr1);
				prev.getNext().getNext().setNext(next);
				prev = prev.getNext().getNext();
			}
			temp = prev.getNext();
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyNode<Integer> head = null;
		head = new SinglyNode<Integer>(1,
//				null);
				new SinglyNode<Integer>(2,
//						null));
						new SinglyNode<Integer>(3,
//								null)));
								new SinglyNode<Integer>(4, 
//										null))));
										new SinglyNode<Integer>(5,null)))));
		
		ListUtil.displayList(head);
		head = pairwiseSwap(head);
		ListUtil.displayList(head);
	}

}
