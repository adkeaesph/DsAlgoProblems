package problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
	
	private static long findNumberOfWays(int rows, int columns) {
		if(rows == 1 && columns == 1)
			return 1;
		
		if(rows == 0 || columns == 0)
			return 0;
		
		return findNumberOfWays(rows - 1, columns) + findNumberOfWays(rows, columns - 1);
	}
	
	private static long findNumberOfWaysUsingMemoisation(int rows, int columns) {
		Map<String, Long> store = new HashMap<>();
		return memoisedHelper(rows, columns, store);
	}
	
	private static long memoisedHelper(int rows, int columns, Map<String, Long> store) {
//		String currentKey = rows + " , " + columns;
		String currentKey = ""; 
		if(rows < columns)
			currentKey = rows + " , " + columns;
		else
			currentKey = columns + " , " + rows;
		
		if(store.containsKey(currentKey))
			return store.get(currentKey);
		
		if(rows == 1 && columns == 1)
			return 1;
		
		if(rows == 0 || columns == 0)
			return 0;
		
		store.put(currentKey, memoisedHelper(rows - 1, columns, store) + memoisedHelper(rows, columns - 1, store));
		return store.get(currentKey);
	}

	public static void main(String[] args) {
		System.out.println(findNumberOfWays(1, 2));
		System.out.println(findNumberOfWays(3, 4));
		System.out.println(findNumberOfWays(5, 4));
		System.out.println(findNumberOfWays(18, 18));
		
		System.out.println(findNumberOfWaysUsingMemoisation(1, 2));
		System.out.println(findNumberOfWaysUsingMemoisation(2, 2));
		System.out.println(findNumberOfWaysUsingMemoisation(3, 3));
		System.out.println(findNumberOfWaysUsingMemoisation(3, 4));
		System.out.println(findNumberOfWaysUsingMemoisation(5, 4));
		System.out.println(findNumberOfWaysUsingMemoisation(50, 50));
		
		
	}
}
