package problems.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SumConstructor {
	
	private static boolean isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimes(String target, String[] array) {
		if(target.isEmpty())
			return true;
		
		for(int i = 0; i < array.length; i++) {
			if(target.startsWith(array[i])) {
				target = target.substring(array[i].length());
				if(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimes(target, array)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimesUsingMemoisation(String target, String[] array) {
		Map<String, Boolean> store = new HashMap<>();
		return memoisedHelper(target, array, store);
	}
	
	

	private static boolean memoisedHelper(String target, String[] array, Map<String, Boolean> store) {
		if(store.containsKey(target))
			return store.get(target);
		
		if(target.isEmpty())
			return true;
		
		int len = array.length;
		for(int i = 0; i < len; i++) {
			if(target.startsWith(array[i])) {
				String substring = target.substring(array[i].length());
				if(memoisedHelper(substring, array, store)) {
					store.put(substring, true);
					return true;
				}
			}
		}
		store.put(target, false);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] array = {"skate", "ate", "boa", "boar", "ard"};
		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimes("skateboard", array));
		
		array = new String[]{"skate", "ate", "boa", "boar", "rd"};
		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimes("skateboard", array));
		
//		array = new String[]{"e", "ee", "eee", "eeee", "eeeee"};
//		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimes(
//				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", array));
		
		System.out.println("------------------------------------------------------------");
		String[] array2;
		array2 = new String[]{"skate", "ate", "boa", "boar", "ard"};
		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimesUsingMemoisation("skateboard", array2));
		
		array2 = new String[]{"skate", "ate", "boa", "boar", "rd"};
		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimesUsingMemoisation("skateboard", array2));
		
		array2 = new String[]{"e", "ee", "eee", "eeee", "eeeee"};
		System.out.println(isStringPossibleFromGivenArrayUsingStringAnyNumberOfTimesUsingMemoisation(
				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", array2));

	}

}
