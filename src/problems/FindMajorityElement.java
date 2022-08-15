package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FindMajorityElement {

	public static void main(String[] args) throws Exception{
		File file = new File(getFilePath());
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		String[] numbers;
		boolean firstLine = true;
		String majorityElement = "$";
		String[] result = new String[2]; //contains majority element and count
		result[0] ="$";
		result[1]= "1";
		while((line = bufferedReader.readLine()) != null) {
			numbers = line.split("\\s+");
			if(firstLine) {
				firstLine = false;
				result = findMajorityElement(numbers);
			} else {
				result = majorityElement.equals("$") ? findMajorityElement(numbers) : findMajorityElement(result, numbers);
			}
		}
		bufferedReader.close();
		System.out.println(result[0]);
	}
	
	

	private static String[] findMajorityElement(String[] numbers) {
		String[] result = new String[2]; //contains majority element and count
		result[0] ="$";
		result[1]= "1";
		
		if(numbers == null || numbers.length == 0)
			return result;
		
		result[0] = numbers[0];
		if(numbers.length == 1) {
			return result;
		}
		
		String majorityElement = numbers[0];
		int count = 1;
		for(int i=1; i<numbers.length; i++) {
			if(numbers[i].equals(majorityElement))
				count++;
			else
				count--;
			
			if(count == 0) {
				if(i+1 < numbers.length) {
					majorityElement = numbers[i+1];
					count = 0;
				} else {
					majorityElement = "$";
					count = 1;
				}
			}
		}
		return new String[] {majorityElement, Integer.toString(count)};
	}
	
	private static String[] findMajorityElement(String[] majorityElementDetails, String[] numbers) {
		if(numbers == null || numbers.length == 0)
			return majorityElementDetails;
		
		String majorityElement = majorityElementDetails[0];
		int count = Integer.parseInt(majorityElementDetails[1]);
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i].equals(majorityElement))
				count++;
			else
				count--;
			
			if(count == 0) {
				if(i+1 < numbers.length) {
					majorityElement = numbers[i+1];
					count = 0;
				} else {
					majorityElement = "$";
					count = 1;
				}
			}
		}
		majorityElementDetails[0] = majorityElement;
		majorityElementDetails[1] = Integer.toString(count);
		return majorityElementDetails;
	}

	private static String getFilePath() {
		return System.getProperty("user.dir") + "/src/sample_input/majority_element_input.txt";
	}

}
