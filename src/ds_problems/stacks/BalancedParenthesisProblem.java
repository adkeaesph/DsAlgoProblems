package ds_problems.stacks;

import java.util.Scanner;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class BalancedParenthesisProblem {
	public static boolean balancedParenthesis(String str) throws StackException{
        str=str.replace(" ","");
        int len=str.length();
        StackUsingLinkedList<Character> stk=new StackUsingLinkedList<>();
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
                stk.push(str.charAt(i));
            else if(str.charAt(i)==')'){
                if(stk.peek()!=null && stk.peek().equals('('))
                    stk.pop();
                else
                    return false;
            }else if(str.charAt(i)==']'){
                if(stk.peek()!=null && stk.peek().equals('['))
                    stk.pop();
                else
                    return false;
            }else if(str.charAt(i)=='}'){
                if(stk.peek()!=null && stk.peek().equals('{'))
                    stk.pop();
                else
                    return false;
            }else
                return false;
        }
        return stk.isEmpty();
    }
	
	public static void main(String[] args) throws StackException {
		Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(balancedParenthesis(str));
        sc.close();
	}

}
