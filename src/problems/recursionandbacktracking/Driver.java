package problems.recursionandbacktracking;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Number of bits to generate all strings : ");
		Scanner scanner = new Scanner(System.in);
		int numberOfBits = Integer.parseInt(scanner.next().trim());
		scanner.close();
		generateAllStringsOfNBits(numberOfBits);

	}

	private static void generateAllStringsOfNBits(int numberOfBits) {
		StringsAndBits stringsAndBits = new StringsAndBits(numberOfBits);
		stringsAndBits.getAllStringsOfNBits(numberOfBits);
	}

}
