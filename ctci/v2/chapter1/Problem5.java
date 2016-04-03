package chapter1;

import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(compress(s.nextLine()));
		s.close();
	}

	private static String compress(String input) {
		if(input == null || "".equals(input)) {
			return "";
		}
		
		int actualLen = input.length();
		int compressedLen = 0;
		StringBuilder compressedString = new StringBuilder();
		int i = 0;
		while (i<actualLen) {
			char prev = input.charAt(i);
			int count = 0;
			while(i<actualLen && prev == input.charAt(i)) {
				count++;
				i++;
			}
			compressedString.append(prev);
			compressedString.append(String.valueOf(count));
			compressedLen += 2;
			if (compressedLen >= actualLen) {
				return input;
			}
		}
		return compressedString.toString();
	}
}
