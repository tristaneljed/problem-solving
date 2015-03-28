import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(numberOfSteps(s.next()));
		}
		s.close();
	}

	private static int numberOfSteps(String input) {
		char chr = input.charAt(0);
		int len = input.length();
		int count = 0;
		for (int i=1; i<len; i++) {
			if (chr == input.charAt(i)) {
				count++;
			} else {
				chr = input.charAt(i);
			}
		}
		return count;
	}

}
