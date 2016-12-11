package strings;

import java.util.Scanner;

public class BeautifulBinaryString {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		BeautifulBinaryString object = new BeautifulBinaryString();

		while (t-- > 0) {
			s.nextInt();
			String input = s.next();
			object.solve(input);
		}
		s.close();
	}

	private void solve(String input) {
		int counter = 0;
		for(int i=0; i<input.length() - 2; i++) {
			if(input.charAt(i) == '0' && input.charAt(i+1) == '1'  && input.charAt(i+2) == '0' ) {
				counter++;
				i+=2;
			}
		}
		System.out.println(counter);
	}
}
