package ds_problems.stacks;

import java.util.Scanner;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;
import customexceptions.InvalidInputException;

public class TowerOfHanoiProblem {
	
	public static void TowerOfHanoi(int noOfDisks, StackUsingLinkedList<Integer> sourceStack, StackUsingLinkedList<Integer> destinationStack,  StackUsingLinkedList<Integer> auxiliaryStack) throws StackException, InvalidInputException {
		if(noOfDisks==1) {
			destinationStack.push(sourceStack.pop());
			System.out.println("Disk "+noOfDisks+" moved from "+sourceStack.getStackId()+" to "+destinationStack.getStackId()+".");
			return;
		} else if(noOfDisks>1){
			TowerOfHanoi(noOfDisks-1, sourceStack, auxiliaryStack, destinationStack);
			destinationStack.push(sourceStack.pop());
			System.out.println("Disk "+noOfDisks+" moved from "+sourceStack.getStackId()+" to "+destinationStack.getStackId()+".");
			TowerOfHanoi(noOfDisks-1, auxiliaryStack, destinationStack, sourceStack);
		} else {
			throw new InvalidInputException("Number of disks need to be 1 or more than 1");
		}
	}
	
	public static void main(String[] args) throws StackException, InvalidInputException {
		StackUsingLinkedList<Integer> srcStack=new StackUsingLinkedList<>();
		srcStack.setStackId("A");
		StackUsingLinkedList<Integer> auxStack=new StackUsingLinkedList<>();
		auxStack.setStackId("B");
		StackUsingLinkedList<Integer> dstnStack=new StackUsingLinkedList<>();
		dstnStack.setStackId("C");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of disks for TOH puzzle : ");
		int noOfDisks=sc.nextInt();
		for(int i=noOfDisks;i>=1;i--)
			srcStack.push(i);
		
		TowerOfHanoi(noOfDisks, srcStack, dstnStack, auxStack);
		
		System.out.println();
		try {
			srcStack.display();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			auxStack.display();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dstnStack.display();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
