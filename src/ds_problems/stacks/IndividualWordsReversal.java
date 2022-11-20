package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class IndividualWordsReversal {

	public static String reverseIndividualWords(String str) throws StackException {
		String result="";
		int len=str.length();
		StackUsingLinkedList<Character> stack=new StackUsingLinkedList<>();
		
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ') {
				while(!stack.isEmpty()) {
					result+=stack.pop();
				}
				result+=" ";
			}else {
				stack.push(str.charAt(i));
			}
		}
		
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				result+=stack.pop();
			}
		}
		return result;
	}
	public static void main(String[] args) throws StackException {
		String str="I am Ramesh";
		String res=reverseIndividualWords(str);
		System.out.println(str);
		System.out.println(res);
	}

}
