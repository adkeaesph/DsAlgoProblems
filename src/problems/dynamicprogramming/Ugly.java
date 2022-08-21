package problems.dynamicprogramming;

public class Ugly {
	
	private static int findNthUglyNumber(int n) {
		if(n == 0)
			return 0;
		int i = 1;
		int count = 0;
		while(true) {
			if(isUgly(i))
				count++;
			if(count == n)
				break;
			i++;
		}
		return i;
	}
	
	private static boolean isUgly(int n) {
		if(n == 1)
			return true;
		
		while(n%2==0) {
			n/=2;
		}
		
		while(n%3==0) {
			n/=3;
		}
		
		while(n%5==0) {
			n/=5;
		}
		
		return n==1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNthUglyNumber(11));

	}

}
