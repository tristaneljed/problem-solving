package chapter1;

import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		
		if (str1.length() == str2.length() && isSubstring(str1 + str1, str2)) {
			System.out.println("Is a rotation");
		} else {
			System.out.println("Is not a rotation");
		}
		
		s.close();
	}
	
	public static boolean isSubstring(String str1, String str2) {
		return str1.contains(str2);
	}
}
