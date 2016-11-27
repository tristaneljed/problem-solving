package strings;

import java.util.Scanner;

public class MarsExploration {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		MarsExploration object = new MarsExploration();

		while (t-- > 0) {
			object.solve(s.next());
		}
		s.close();
	}

	private void solve(String input) {
		char message[] = new char[]{'S', 'O', 'S'};
		int alteredChars = 0;
		for (int i=0; i<input.length(); i++) {
			int mod = i % 3;
			if(input.charAt(i) != message[mod]) {
				alteredChars++;
			}
		}
		System.out.println(alteredChars);
	}
}
