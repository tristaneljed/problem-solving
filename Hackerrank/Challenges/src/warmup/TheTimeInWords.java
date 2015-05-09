package warmup;

import java.util.Scanner;

public class TheTimeInWords {
	
	private static final String[] oneToNineteen = { "", "one", "two", "three", "four",
		"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
		"fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	
	private static final String[] tees = {"", "" ,"twenty", "thirty", "forty", "fifty", "sixty"};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int m = s.nextInt();
		
		StringBuilder output = new StringBuilder();
		String min = (m == 1) ? " minute " : " minutes "; 
		
		if (m == 0) {
			output.append(numToWords(h)).append(" ").append("o' clock");
		} else if (m == 15) {
			output.append("quarter past ").append(numToWords(h));
		} else if (m < 30) {
			output.append(numToWords(m)).append(min).append("past ")
				.append(numToWords(h));
		} else if (m == 30) {
			output.append("half past ").append(numToWords(h));
		} else if (m == 45) {
			output.append("quarter to ").append(numToWords((h == 12) ? 1 : h+1));
		} else {
			output.append(numToWords(60 - m)).append(min).append("to ")
				.append(numToWords((h == 12) ? 1 : h+1));
		}
		System.out.println(output.toString());
		
		s.close();
	}
	
	private static String numToWords(int num) {
		if (num < 20) {
			return oneToNineteen[num];
		} else {
			int ones = num % 10;
			int tens = num / 10;
			return (tees[tens] + " " + oneToNineteen[ones]).trim();
		}
	}

}
