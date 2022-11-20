package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class PostfixEvauation {

	public static Integer evaluatePostfixExpression(String s) throws StackException {
		StackUsingLinkedList<Integer> numbers=new StackUsingLinkedList<>();
		
		int a,b,len=s.length();
		String temp="";
		Integer n;
		for(int i=0;i<len;i++) {
			if(s.charAt(i)==' ') {
				try {
					n=Integer.parseInt(temp);
					numbers.push(n);
				}catch(NumberFormatException e) {
					b=numbers.pop();
					a=numbers.pop();
					if(temp.equals("+")) 
						numbers.push(a+b);
					else if(temp.equals("-"))
						numbers.push(a-b);
					else if(temp.equals("/"))
						numbers.push(a/b);
					else if(temp.equals("*"))
						numbers.push(a*b);
					else if(temp.equals("%"))
						numbers.push(a%b);
				}
				temp="";
//				System.out.println("Stack contents top to bottom : ");
//				try {
//					numbers.display();
//				}catch(Exception e) {
//					System.out.println("Stack is empty!!!");
//				}
//				System.out.println();
			}else
				temp+=s.charAt(i);
		}
		return numbers.pop();
	}
	public static void main(String[] args) throws StackException {
		System.out.println(evaluatePostfixExpression("3 10 2 / * 2 - "));
	}

}
