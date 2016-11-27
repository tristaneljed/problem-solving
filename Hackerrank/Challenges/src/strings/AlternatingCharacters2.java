package strings;

import java.util.Scanner;

public class AlternatingCharacters2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		AlternatingCharacters2 object = new AlternatingCharacters2();

		while (t-- > 0) {
			object.solve(s.next());
		}
		s.close();
	}

	private void solve(String input) {
		int count = 0;
		char prev = input.charAt(0);
		for (int i=1; i<input.length(); i++) {
			if(input.charAt(i) == prev) {
				count++;
			}
			prev = input.charAt(i);
		}
		System.out.println(count);
	}
}
