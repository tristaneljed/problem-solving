package strings;
import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(process(str1, str2));
		s.close();
	}
	
	public static int process (String str1, String str2) {
		int charMap1[] = new int[26];
		int charMap2[] = new int[26];
		
		for (int i=0; i<str1.length(); i++) {
			charMap1[str1.charAt(i) - 'a']++;
		}
		
		for (int i=0; i<str2.length(); i++) {
			charMap2[str2.charAt(i) - 'a']++;
		}
		
		int matchingCount = 0;
		
		for (int i=0; i<26; i++) {
			matchingCount += Math.min(charMap1[i], charMap2[i]);
		}
		matchingCount *= 2;
		
		return (str1.length() + str2.length() - matchingCount);
	}
}
