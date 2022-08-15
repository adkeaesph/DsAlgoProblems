package problems;

import complexstructures.MinMaxStack;

public class FindMinAndMaxOfStack {
	
	private static void displayInDetails(MinMaxStack stack) {
		stack.displayMainStack();
		stack.displayMinimumsStack();
		stack.displayMaximumsStack();
		System.out.println();
	}

	public static void main(String[] args) {
		MinMaxStack stack = new MinMaxStack();
		
		stack.push(8);
		displayInDetails(stack);
		
		stack.push(6);
		displayInDetails(stack);
		
		stack.push(100);
		displayInDetails(stack);
		
		stack.push(40);
		displayInDetails(stack);
		
		stack.push(6);
		displayInDetails(stack);
		
		stack.push(2);
		displayInDetails(stack);
	}

}
