package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class UnmatchedParenthesisMarking {
	
	public static String markUnmatchedParentheses(String str) throws StackException {//string buffer can be used too
		int len=str.length();
		
		StackUsingLinkedList<Character> symbolstk =new StackUsingLinkedList<>();
		StackUsingLinkedList<Integer> indexstk =new StackUsingLinkedList<>();
		for(int i=0;i<len;i++) {
			if(symbolstk.isEmpty()) {
				if(str.charAt(i)=='(' || str.charAt(i)==')') {
					symbolstk.push(str.charAt(i));
					indexstk.push(i);
				}
			}else {
				if(str.charAt(i)=='(') {
					symbolstk.push(str.charAt(i));
					indexstk.push(i);
				}else if(str.charAt(i)==')') {
					if(symbolstk.peek()=='(') {
						symbolstk.pop();
						indexstk.pop();
					}else {
						symbolstk.push(str.charAt(i));
						indexstk.push(i);
					}
				}
			}
		}
		
		//symbolstk.displayStackContents();
		//indexstk.displayStackContents();
		symbolstk=null;
		
		String res="";
		for(int i=len-1;i>=0;i--) {
			if(!indexstk.isEmpty() && indexstk.peek()==i) {
				indexstk.pop();
				res="-1"+res;
			} else {
				if(str.charAt(i)=='(') 
					res="0"+res;
				else if(str.charAt(i)==')')
					res="1"+res;
				else
					res=str.charAt(i)+res;
			}
		}
		return res;
	}
	public static void main(String[] args) throws StackException {
		//String str="(((abc))((d)))))";
		//String str="(a))";
		String str="((a))";
		String res=markUnmatchedParentheses(str);
		System.out.println(str);
		System.out.println(res);
	}

}
