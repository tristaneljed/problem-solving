package epiccode;

import java.util.Scanner;

public class BeginEnd {
	public static void main(String[] args) {
		int[] charFrequency = new int[26];
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		String str = s.next();
		
		for (int i=0; i<str.length(); i++) {
			charFrequency[str.charAt(i) - 'a'] += 1;
		}
		
		long fx = 0;
		
		for (int i=0; i<26; i++) {
			if (charFrequency[i] == 0) {
				continue;
			} else if (charFrequency[i] == 1) {
				fx += 1;
			} else {
				long val = ( (long)(charFrequency[i]) * (charFrequency[i] - 1)) / 2 ;
				fx += val + charFrequency[i];
			}
		}
		
		System.out.println(fx);
		
		s.close();
	}
}
