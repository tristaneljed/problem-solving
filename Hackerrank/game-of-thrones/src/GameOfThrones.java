import java.util.Scanner;

public class GameOfThrones {
	private static int[] alphaCount;
	
	public static void main(String[] args) {
	 	Scanner s = new Scanner(System.in);
	 	String input = s.next();
	 	System.out.println(isAnagram(input));
	 	s.close();
	}

	private static String isAnagram(String input) {
		int len = input.length();
		boolean evenLength = (len%2 == 0);
		boolean foundOddFrequency = false;
		alphaCount = new int[26];
		for (int i=0; i<len; i++) {
			alphaCount[input.charAt(i) - 'a']++;
		}
		
		for(int i=0; i<26; i++) {
			if (alphaCount[i] % 2 == 1) {
				if (foundOddFrequency || evenLength) {
					return "NO";
				}
				foundOddFrequency = true;
			}
		}
		
		return "YES";
	}

}
