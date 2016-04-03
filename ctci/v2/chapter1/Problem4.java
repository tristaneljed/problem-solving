package chapter1;

import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			System.out.println(encode(s.nextLine()));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		s.close();
	}
	
	private static String encode(String input) throws Exception {
		char inputArray[] = input.toCharArray();
		int numberOfSpaces = 0;
		
		for (int i=0; i<input.trim().length(); i++) {
			if(inputArray[i] == ' ') {
				numberOfSpaces++;
			}
		}
		
		int extraSpaces = inputArray.length - (input.trim().length() 
				+ (2 * numberOfSpaces));
		if (extraSpaces < 0) {
			throw new Exception("Invalid input");
		}
		
		int lastIndex = inputArray.length - extraSpaces - 1;
		for (int i=input.trim().length() - 1; i>=0; i--) {
			if (inputArray[i] == ' ') {
				inputArray[lastIndex--] = '0';
				inputArray[lastIndex--] = '2';
				inputArray[lastIndex--] = '%';
			} else {
				inputArray[lastIndex--] = inputArray[i];
			}
		}
		return new String(inputArray);
	}

}
