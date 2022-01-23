package problems;

import java.util.HashSet;
import java.util.Set;

import corestructures.SinglyNode;

public class LoopDetection {
	
	public static <T> boolean doesLoopExistsUsingSet(SinglyNode<T> head) {
		Set<SinglyNode<T>> set = new HashSet<>();
		SinglyNode<T> currentNode = head;
		while(currentNode!=null) {
			if(set.contains(currentNode))
				return true;
			
			set.add(currentNode);
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	public static <T> boolean doesLoopExistsUsingPointers(SinglyNode<T> head) {
		SinglyNode<T> slowNode = head;
		SinglyNode<T> fastNode = head;
		
		while(fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
			if(slowNode == fastNode)
				return true;
		}
		return false;
	}
	
	public static <T> SinglyNode<T> findStartNodeOfLoopIfLoopExists(SinglyNode<T> head) {
		SinglyNode<T> slowNode = head;
		SinglyNode<T> fastNode = head;
		
		boolean loopExists = false;
		while(fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
			if(slowNode == fastNode) {
				loopExists = true;
				break;
			}
		}
		
		if(loopExists) {
			slowNode = head;
			while(slowNode != fastNode) {
				slowNode = slowNode.getNext();
				fastNode = fastNode.getNext();
			}
			return slowNode;
		}
		return new SinglyNode<>();
	}

}
