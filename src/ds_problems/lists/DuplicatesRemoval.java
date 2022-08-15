package ds_problems.lists;

import java.util.LinkedHashSet;
import java.util.Set;

import corestructures.SinglyNode;
import utils.ListUtil;

public class DuplicatesRemoval {
	
	public static <T> SinglyNode<T> removeDuplicatesWhenHeadIsGiven(SinglyNode<T> head) 
    {
         // Your code here
         if(head == null)
            return head;
            
         Set<T> distincts = new LinkedHashSet<>();
         distincts.add(head.getData());
         
         SinglyNode<T> temp = head;
         while(temp!=null && temp.getNext()!=null) {
             if(distincts.contains(temp.getNext().getData())) {
                 temp.setNext(temp.getNext().getNext());
             } else {
                distincts.add(temp.getNext().getData());
                temp = temp.getNext();
             }
         }
         return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyNode<Integer> head = new SinglyNode<Integer>(2, 
				new SinglyNode<>(4, new SinglyNode<>(7, 
						new SinglyNode<>(10, new SinglyNode<>(4, new SinglyNode<>(6,
								new SinglyNode<>(6)))))));
		
		ListUtil.displayList(head);
		head = removeDuplicatesWhenHeadIsGiven(head);
		ListUtil.displayList(head);
	}

}
