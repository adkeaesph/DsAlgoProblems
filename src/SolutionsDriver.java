import corestructures.SinglyNode;
import customexceptions.ListException;
import problems.FindNthNode;
import problems.LoopDetection;

public class SolutionsDriver {

	public static void main(String[] args) throws ListException {
		SinglyNode<Integer> head = new SinglyNode<>(23);
		head.setNext(new SinglyNode<Integer>(34, new SinglyNode<Integer>(45, new SinglyNode<Integer>(56))));
		
//		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 0));
//		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 1));
//		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 2));
//		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 3));
		
		System.out.println(LoopDetection.doesLoopExistsUsingSet(head));
		System.out.println(LoopDetection.doesLoopExistsUsingPointers(head));
		System.out.println(LoopDetection.findStartNodeOfLoopIfLoopExists(head).getData());
		
		SinglyNode<Integer> currentNode = head;
		
		while(currentNode.getNext()!= null)
			currentNode = currentNode.getNext();
		
		currentNode.setNext(new SinglyNode<Integer>(67, new SinglyNode<Integer>(78, head.getNext().getNext())));
		System.out.println(LoopDetection.doesLoopExistsUsingSet(head));
		System.out.println(LoopDetection.doesLoopExistsUsingPointers(head));
		System.out.println(LoopDetection.findStartNodeOfLoopIfLoopExists(head).getData());

	}

}
