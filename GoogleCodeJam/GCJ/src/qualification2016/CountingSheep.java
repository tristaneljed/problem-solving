package qualification2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountingSheep {
	private static boolean[] digitFound = null;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("resource/Counting-sheep-large.in"));
		PrintWriter pw = new PrintWriter("resource/Counting-sheep-large.out");
		int t = s.nextInt();
		
		for (int caseNumber=1; caseNumber<=t; caseNumber++) {
			pw.println("Case #" + caseNumber + ": " + solve(s.nextInt()));
			//System.out.println(solve(s.nextInt()));
		}
		
		pw.close();
		s.close();
	}

	private static String solve(int number) {
		if (number == 0) {
			return "INSOMNIA";
		}
		
		digitFound = new boolean[10];
		int multiplier = 1;
		while(!isCompleted(number * multiplier)) {
			multiplier++;
		}
		
		return String.valueOf(number * multiplier);
	}

	private static boolean isCompleted(int number) {
		while(number != 0) {
			int lastDigit = number % 10;
			digitFound[lastDigit] = true;
			number = number/10;
		}
		
		int i = 0;
		for (i=0; i<10; i++) {
			if(!digitFound[i]) {
				break;
			}
		}
		return (i==10);
	}

}
