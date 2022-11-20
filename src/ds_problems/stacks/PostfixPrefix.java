package ds_problems.stacks;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class PostfixPrefix {

	public static String changePostfixIntoPrefix(String s) throws StackException {
		int len = s.length();
		StackUsingLinkedList<String> operands = new StackUsingLinkedList<>();
		String a, b;

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				operands.push("" + s.charAt(i));
			else {
				b = operands.pop();
				a = operands.pop();
				operands.push(s.charAt(i) + a + b);
			}
		}

		return operands.pop();
	}

	public static String changePrefixIntoPostfix(String s) throws StackException {
		int len = s.length();
		StackUsingLinkedList<String> operands = new StackUsingLinkedList<>();
		String a, b;

		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				operands.push("" + s.charAt(i));
			else {
				a = operands.pop();
				b = operands.pop();
				operands.push(a + b + s.charAt(i));
			}
		}

		return operands.pop();
	}

	public static void main(String[] args) throws StackException {
		String a = changePostfixIntoPrefix("dab/c*-");
		System.out.println(a);
		System.out.println(changePrefixIntoPostfix(a));

		System.out.println();
		String b = changePostfixIntoPrefix("dn/ab/c*-");
		System.out.println(b);
		System.out.println(changePrefixIntoPostfix(b));
		System.out.println(changePostfixIntoPrefix(changePrefixIntoPostfix(b)));
	}

}
