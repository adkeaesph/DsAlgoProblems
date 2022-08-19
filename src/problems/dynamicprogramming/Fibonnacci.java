package problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonnacci {

	
	private static long findNthFibonnaciNumberUsingIteration(int n) {
		long first = 1;
		if(n <= 2)
			return first;
		
		long second = first;
		long newNumber = -1;
		
		for(int i = 3; i <= n; i++) {
			newNumber = first + second;
			first = second;
			second = newNumber;
		}
		return newNumber;
	}
	
	private static long findNthFibonnaciNumberUsingRecursion(int n) {
		if(n <= 2)
			return 1;
		
		return findNthFibonnaciNumberUsingRecursion(n - 1) + findNthFibonnaciNumberUsingRecursion(n - 2); 
	}
	
	private static long findNthFibonnaciNumberUsingMemoizedRecursion(int n) {
		return fibonnnaciMemoisedHelper(n, new HashMap<Integer, Long>());
	}
	
	private static long fibonnnaciMemoisedHelper(int n, Map<Integer, Long> store) {
		if(store.containsKey(n))
			return store.get(n);
		
		if(n <= 2)
			return 1;
		
		store.put(n, fibonnnaciMemoisedHelper(n-1, store) + fibonnnaciMemoisedHelper(n-2, store));
		return store.get(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 1; i++)
			System.out.println(findNthFibonnaciNumberUsingIteration(i+1));
		
		System.out.println("----------------------");
		for(int i = 0; i < 50; i++)
			System.out.println(findNthFibonnaciNumberUsingRecursion(i+1));
		
		System.out.println(findNthFibonnaciNumberUsingRecursion(50));
		System.out.println(findNthFibonnaciNumberUsingMemoizedRecursion(50));
	}

}
