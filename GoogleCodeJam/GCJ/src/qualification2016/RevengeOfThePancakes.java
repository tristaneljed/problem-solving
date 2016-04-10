package qualification2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RevengeOfThePancakes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("resource/RevengeOfThePancakes-large.in"));
		PrintWriter printWriter = new PrintWriter("resource/RevengeOfThePancakes-large.out");
		
		int t = s.nextInt();
		
		for(int caseNumber=1; caseNumber<=t; caseNumber++) {
			String result = "Case #" + caseNumber + ": " + solve(s.next());
			printWriter.println(result);
			System.out.println(result);
		}
		
		printWriter.close();
		s.close();
	}

	private static int solve(String input) {
		input = input.trim();
		boolean[] pancakeHappyFace = new boolean[input.length()];
		
		for(int i=0; i<input.length(); i++) {
			pancakeHappyFace[i] = (input.charAt(i) == '+');
		}
		
		int sameTill = 0;
		int flips = 0;
		int numberOfPancakes = input.length();
		
		while(sameTill < numberOfPancakes) {
			int iterator = sameTill + 1;
			while (iterator < numberOfPancakes  && 
					pancakeHappyFace[sameTill] == pancakeHappyFace[iterator]) {
				iterator++;
			}
			
			if(iterator == numberOfPancakes) {
				if (pancakeHappyFace[numberOfPancakes-1]) {
					return flips;
				} else {
					return flips+1;
				}
			} else {
				flips++;
				sameTill = iterator;
			}
		}
		
		return 0;
	}
}
