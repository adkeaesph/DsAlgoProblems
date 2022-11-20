package ds_problems.stacks;

import java.util.HashMap;
import java.util.Map;

import complexstructures.StackUsingLinkedList;
import customexceptions.StackException;

public class InfixToPostfix {

	
	public static double evaluatePostfixExpression(String expression) throws Exception {
		String[] tokens = expression.split("\\s+");
		int numberOfTokens = tokens.length;
		StackUsingLinkedList<Double> stackOfIntermediateResults = new StackUsingLinkedList<>();
		
		for(int i=0; i<numberOfTokens; i++) {
			String currentToken = tokens[i].trim();
			try {
				double operand = Double.parseDouble(currentToken);
				stackOfIntermediateResults.push(operand);
			} catch (NumberFormatException e) {
				double operand2 = stackOfIntermediateResults.pop();
				double operand1 = stackOfIntermediateResults.pop();
				
				double result;
				switch(currentToken) {
					case "+":
						result = operand1 + operand2;
						break;
					case "-":
						result = operand1 - operand2;
						break;
					case "/":
						result = operand1 / operand2;
						break;
					case "*":
						result = operand1 * operand2;
						break;
					case "%":
						result = operand1 % operand2;
						break;
					default:
						throw new Exception("Invalid operator : " + currentToken);
				}
				stackOfIntermediateResults.push(result);	
			}
		}
		return stackOfIntermediateResults.pop();
	}
	
	/*
	 * assuming all operands are denoted by capital characters A to Z
	 * and operators only include: +,-,/,*,%,(,)
	 */
	public static String infixToPostfix(String infixExpression) throws StackException {
		StackUsingLinkedList<Character> stackOfOperators = new StackUsingLinkedList<>();
		int lengthOfExpression = infixExpression.length();
		String resultantPostfixExpression = "";
		Map<Character,Integer> mapOfPrecedenceForOperators = getPrecedenceMap();
		for(int i=0; i<lengthOfExpression; i++) {
			char currentCharacter = infixExpression.charAt(i);
			if(currentCharacter >= 'A' && currentCharacter <= 'Z') 
				resultantPostfixExpression += currentCharacter;
			else if(currentCharacter == ')') {
				while(true) {
					if(stackOfOperators.peek() != '(')
						resultantPostfixExpression += stackOfOperators.pop();
					else {
						stackOfOperators.pop();
						break;
					}
				}
			} else {
				//the current character is an operator
				while(!stackOfOperators.isEmpty() && stackOfOperators.peek() != '(' 
						&& mapOfPrecedenceForOperators.get(stackOfOperators.peek()) >= mapOfPrecedenceForOperators.get(currentCharacter))
						resultantPostfixExpression += stackOfOperators.pop();
				stackOfOperators.push(currentCharacter);
			}
		}
		
		while(!stackOfOperators.isEmpty())
			resultantPostfixExpression += stackOfOperators.pop();
		
		return resultantPostfixExpression;
	}

	private static Map<Character, Integer> getPrecedenceMap() {
		Map<Character, Integer> mapOfPrecedence = new HashMap<>();
		mapOfPrecedence.put('+', 1);
		mapOfPrecedence.put('-', 1);
		mapOfPrecedence.put('/', 2);
		mapOfPrecedence.put('%', 2);
		mapOfPrecedence.put('*', 2);
		mapOfPrecedence.put('(', 3);
		return mapOfPrecedence;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(infixToPostfix("A*B-(C+D)+E"));
		System.out.println(evaluatePostfixExpression("24 5 * 8 2 + / 5 -"));
	}

}
