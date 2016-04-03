package chapter1;

import java.util.Scanner;

public class Problem3 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		System.out.println(isPermutation(str1, str2));
		s.close();
	}

	private static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int freq[] = new int[256];
		for (int i=0; i<str1.length(); i++) {
			freq[str1.charAt(i) - 'a']++;
		}
		
		for (int i=0; i<str2.length(); i++) {
			if (freq[str2.charAt(i) - 'a'] == 0) {
				return false;
			} else {
				freq[str2.charAt(i) - 'a']--;
			}
		}
		return true;
	}
}
