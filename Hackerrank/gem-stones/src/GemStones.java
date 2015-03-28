import java.util.Scanner;

public class GemStones {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		int count = numOfTestCases;
		int globalCharMap[] = new int[26];
		while (numOfTestCases-- > 0) {
			String str = s.next();
			boolean charMap[] = new boolean[26];
			int i=0;
			while (i < str.length()) {
				int index = str.charAt(i) - 'a';
				if (!charMap[index]) {
					charMap[index] = true;
					globalCharMap[index]++;
				}
				i++;
			}
		}
		
		int output = 0;
		for (int i=0; i<26; i++) {
			if (globalCharMap[i] == count) {
				output++;
			}
		}
		System.out.println(output);
		s.close();
	}
}
