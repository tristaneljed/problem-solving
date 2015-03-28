import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			String str = s.next();
			int len = str.length();
			if (len % 2 == 1) {
				System.out.println(-1);
				continue;
			}
			int charMap[] = new int[26];
			for (int i=0; i<(len/2); i++) {
				int index = str.charAt(i) - 'a';
				charMap[index]++;
			}
			
			int numOfMatch = 0;
			
			for (int i=(len/2); i<len; i++) {
				int index = str.charAt(i) - 'a';
				if (charMap[index] != 0) {
					numOfMatch++;
					charMap[index]--;
				}
			}
			
			System.out.println((len/2) - numOfMatch);
		}
		s.close();
	}

}
