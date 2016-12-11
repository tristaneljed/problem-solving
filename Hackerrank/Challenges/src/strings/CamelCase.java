package strings;

import java.util.Scanner;

public class CamelCase {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		CamelCase object = new CamelCase();

		while (t-- > 0) {
			object.solve(s.next());
		}
		s.close();
	}

	private void solve(String input) {
		int countOfCapitals = 0;
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) < 'a') {
				countOfCapitals++;
			}
		}
		System.out.println(countOfCapitals+1);
	}
}
