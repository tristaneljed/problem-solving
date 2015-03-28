import java.util.Scanner;


public class Panagrams {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine().toLowerCase();
		int len = str.length();
		int count = 0;
		boolean charMap[] = new boolean[26];
		
		for (int i=0; (i<len) && (count != 26); i++) {
			int index = str.charAt(i) - 'a';
			if (index > 25 || index < 0) {
				continue;
			}
			
			if (!charMap[index]) {
				charMap[index] = true;
				count++;
			}
		}
		
		if (count == 26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
		
		s.close();
	}

}
