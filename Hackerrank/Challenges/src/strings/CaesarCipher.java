package strings;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		CaesarCipher object = new CaesarCipher();

		while (t-- > 0) {
			int n = s.nextInt();
			String str = s.next();
			int k = s.nextInt() % 26;
			object.solve(n, str, k);
		}

		s.close();
	}

	private void solve(int n, String str, int k) {
		for (int i=0; i<str.length(); i++) {
			char c = isAlphabet(str.charAt(i)) ? rotate(str.charAt(i), k) : str.charAt(i);
			System.out.print(c);
		}
	}
	
	private char rotate(char c, int k) {
		boolean rotatedAlphabets = (isSmallAlphabet((char)(c+k)) && isSmallAlphabet(c)) ||
				(isCapitalAlphabet((char)(c+k)) && isCapitalAlphabet(c));
		return  (char)(rotatedAlphabets ? c+k : c+k-26);
	}

	private boolean isAlphabet(char c) {
		return isSmallAlphabet(c) || isCapitalAlphabet(c);
	}
	
	private boolean isSmallAlphabet(char c) {
		return (c > 96 && c < 123);
	}
	
	private boolean isCapitalAlphabet(char c) {
		return (c > 64 && c < 91);
	}
}
