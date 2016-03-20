package dynamicprogramming;

import java.util.Scanner;

public class StringReduction {
	
	/* 
	 * Solution is to count the frequency of characters
	 * in the string. If all the characters are same then
	 * the length of the string is the answer. Else following
	 * pattern stands true :-
	 * 
	 * Even Even Even => 2
	 * Even Even Odd  => 1
	 * Even Odd Odd   => 1
	 * Odd Odd Odd    => 2
	 * 
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestcases = s.nextInt();
		while (numOfTestcases-- > 0) {
			String input = s.next();
			int length = input.length();
			int aFreq = 0;
			int bFreq = 0;
			int cFreq = 0;
			
			for (int i=0; i<length; i++) {
				switch(input.charAt(i) - 'a') {
					case 0: aFreq++; break;
					case 1: bFreq++; break;
					case 2: cFreq++; break;
					default : System.out.println("Holy crap!!");
				}
			}
			
			if (aFreq == length || 
				bFreq == length || 
				cFreq == length) {
				System.out.println(length);
				continue;
			}
			
			int evenCount = 0;
			if (isEven(aFreq)) {
				evenCount++;
			}
			if (isEven(bFreq)) {
				evenCount++;
			}
			if (isEven(cFreq)) {
				evenCount++;
			}
			
			if (evenCount == 3 || evenCount == 0) {
				System.out.println(2);
			} else {
				System.out.println(1);
			}
			
		}
		s.close();
	}
	
	public static boolean isEven(int number) {
		return (number % 2 == 0);
	}
}
