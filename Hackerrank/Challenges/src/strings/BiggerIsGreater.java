package strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BiggerIsGreater {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(solve(s.next()));
		}
		s.close();
	}

	private static String solve(String str) {
		System.out.println("::" + str);
		Set<Character> charSet = new HashSet<>();
		for (int i=0; i<str.length(); i++) {
			charSet.add(str.charAt(i));
		}
		
		List<Character> charList = new ArrayList<Character>(charSet);
		Collections.sort(charList);
		int len = charList.size();
		int rank = 0;
		Map<Character, Integer> rankMap = new HashMap<Character, Integer>();
		for (char c:charList) {
			rankMap.put(c, rank++);
		}
		
		int i = len-1;
		while (i >= 0) {
			if (rankMap.get(str.charAt(i)) != len-1) {
				break;
			}
			i--;
		}
		
		if (i == -1) {
			return "no answer";
		}
		
		String start = "";
		if (i > 0) {
			start = str.substring(0,i-1);
		}
		
		StringBuilder output = new StringBuilder(start);
		output.append(charList.get(rankMap.get(str.charAt(i)) + 1 ));
		i++;
		while (i < len) {
			output.append(charList.get(0));
			i++;
		}
		
		return output.toString();
	}

}
