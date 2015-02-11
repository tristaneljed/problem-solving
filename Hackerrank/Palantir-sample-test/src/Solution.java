import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String firstString = s.nextLine();
		String secondString = s.nextLine();
		System.out.println(checkAnagram(firstString, secondString));
		s.close();
	}

	private static String checkAnagram(String firstString, String secondString) {
		if (firstString.length() != secondString.length()) {
			return "Not Anagram!";
		}
		
		Map<Character, Integer> firstMap = new HashMap<>();
		for (int i=0; i<firstString.length(); i++) {
			int freq = 0;
			if (firstMap.containsKey(firstString.charAt(i))) {
				freq = firstMap.get(firstString.charAt(i));
			}
			firstMap.put(firstString.charAt(i), freq+1);
		}
		
		for (int i=0; i<secondString.length(); i++) {
			if (!firstMap.containsKey(secondString.charAt(i))) {
				return "Not Anagram!";
			}
			
			int freq = firstMap.get(secondString.charAt(i));
			if (freq == 0) {
				return "Not Anagram!";
			}
			firstMap.put(secondString.charAt(i), freq-1);
		}
		
		return "Anagram!";
	}

}
