package strings;

import java.util.Scanner;

public class TwoStrings {
	
	public static void main(String[] args) {
		boolean [] alphabets;
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			String str1 = s.next();
			String str2 = s.next();
			alphabets = new boolean[26];
			
			for (int i=0; i<str1.length(); i++) {
				alphabets[str1.charAt(i) - 'a'] = true;
			}
			
			int i;
			for (i=0; i<str2.length(); i++) {
				if(alphabets[str2.charAt(i) - 'a']) {
					break;
				}
			}
			
			if (i < str2.length()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}
}
