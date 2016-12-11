package strings;

import java.util.Scanner;

public class ReducedString {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		ReducedString object = new ReducedString();

		while (t-- > 0) {
			object.solve(s.next());
		}
		s.close();
	}

	private void solve(String input) {
		String prev;
		do {
			prev = input;
			input = reduce(input);
		} while(!input.equals(prev));
		
		System.out.println("".equals(input) ? "Empty String" : input);
	}

	private String reduce(String input) {
		if("".equals(input)) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		char prev = input.charAt(0);
		int count = 0;
		for (int i=0; i<input.length(); i++) {
			if(prev == input.charAt(i)) {
				count++;
			} else {
				if(count%2==1) {
					sb.append(prev);
				}
				prev = input.charAt(i);
				count = 1;
			}
		}
		if (count%2==1) {
			sb.append(prev);
		}
		return sb.toString();
	}
}
