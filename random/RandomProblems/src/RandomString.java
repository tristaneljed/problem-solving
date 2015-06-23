package epiccode;

import java.util.Scanner;

public class RandomString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(solve(s.next()));
		s.close();
	}
	
	private static String solve(String str) {
		String prev;
		String transformedString = str;
		
		do {
			prev = transformedString;
			transformedString = transform(prev);
		} while(!transformedString.equals(prev));
		
		return transformedString;
	}

	private static String transform(String str) {
//		System.out.println("Input = " + str);
		str = replace(str, "AB", "AA");
		str = replace(str, "BA", "AA");
		str = replace(str, "CB", "CC");
		str = replace(str, "BC", "CC");
		str = replace(str, "AA", "A");
		str = replace(str, "CC", "C");
//		System.out.println("Output = " + str);
		return str;
	}

	private static String replace(String str, String from, String to) {
//		System.out.println("From => " + str);
		if (str.indexOf(from) != -1) {
			String first = "";
			if (str.indexOf(from) != 0) {
				first = str.substring(0, str.indexOf(from));
			}
			
			String last = "";
			if (str.indexOf(from) != str.length() - 2) {
				last = str.substring(str.indexOf(from) + 2);
			}
			str = first + to + last;
		}
//		System.out.println("To => " + str);
		return str;
	}
}
