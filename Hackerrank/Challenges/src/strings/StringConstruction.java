package strings;

import java.util.Scanner;

public class StringConstruction {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		StringConstruction object = new StringConstruction();

		while (t-- > 0) {
			String input = s.next();
			object.solve(input);
		}
		s.close();
	}

	private void solve(String input) {
		int[] frequency = new int[26];
		int uniqueCharacters = 0;
		for(int i=0; i<input.length(); i++) {
			int index = input.charAt(i) - 'a';
			if (frequency[index] == 0) {
				uniqueCharacters++;
			}
			frequency[index]++;
		}
		System.out.println(uniqueCharacters);
	}
}
