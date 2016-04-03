package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		if (hasUniqueCharactersAscii(input)) {
			System.out.println("All characters are unique");
		} else {
			System.out.println("All characters are not unique");
		}
		if (hasUniqueCharactersUtf8(input)) {
			System.out.println("All characters are unique");
		} else {
			System.out.println("All characters are not unique");
		}
		s.close();
	}

	//for ASCII character encoded string
	private static boolean hasUniqueCharactersAscii(String input) {
		if (input.length() > 256) {
			return false;
		}
		
		boolean exists[] = new boolean[256];
		
		for (int i=0; i<input.length(); i++) {
			if (exists[input.charAt(i)]) {
				return false;
			} else {
				exists[input.charAt(i)] = true;
			}
		}
		return true;
	}
	
	//for UTF-8 character encoding
	private static boolean hasUniqueCharactersUtf8(String input) {
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);
		char previousChar = inputArray[0];
		for (int i=1; i<inputArray.length; i++) {
			if (previousChar == inputArray[i]) {
				return false;
			}
			previousChar = inputArray[i];
		}
		return true;
	}
}
