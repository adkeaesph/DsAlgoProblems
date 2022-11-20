							package problems.recursionandbacktracking;

public class StringsAndBits {
	
	private int[] array;
	
	public StringsAndBits(int n) {
		array = new int[n];
	}

	public void getAllStringsOfNBits(int n) {
		if(n<1) {
			for(int i = 0 ; i<array.length; i++)
				System.out.print(array[i]);
			System.out.println();
		} else {
			array[n-1] = 0;
			getAllStringsOfNBits(n-1);
			array[n-1] = 1;
			getAllStringsOfNBits(n-1);
		}
	}

}
