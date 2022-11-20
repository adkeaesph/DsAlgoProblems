package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class ConsecutiveWordsDeletion {

	private static String deleteConsecutiveSameWords(String str) throws StackException {
		int len=str.length();
		String temp="";
		StackUsingLinkedList<String> stk=new StackUsingLinkedList<>();
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ') {
				temp+=str.charAt(i);
			}else {
				if(stk.isEmpty())
					stk.push(temp);
				else {
					if(stk.peek().equals(temp))
						stk.pop();
					else
						stk.push(temp);
				}
				temp="";
			}
		}
		
		if(!temp.isEmpty()) {
			if(stk.peek().equals(temp))
				stk.pop();
			else
				stk.push(temp);
		}
		
		String result="";
		
		while(stk.size() != 1) {
			result=" "+stk.pop()+result;
		}
		result=stk.pop()+result;
		return result;
	}
	
	public static void main(String[] args) throws StackException {
		String str="tom jerry jerry harry";
		String res=deleteConsecutiveSameWords(str);
		System.out.println(str+" "+str.length());
		System.out.println(res+" "+res.length());

	}

}
