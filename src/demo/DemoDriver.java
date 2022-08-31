package demo;

import java.util.Arrays;

public class DemoDriver {

	private static void swap(int a, int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b=3;
		swap(a,b);
	}

}
