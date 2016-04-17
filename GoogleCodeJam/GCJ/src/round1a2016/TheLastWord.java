package round1a2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TheLastWord {
	
	private static final String INPUT_FILE = "resource/TheLastWord-large.in";
	private static final String OUTPUT_FILE = "resource/TheLastWord-large.out";
	private static final boolean GCJ = true;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = GCJ ? new Scanner(new File(INPUT_FILE))
				: new Scanner(System.in);
		PrintWriter printWriter = new PrintWriter(OUTPUT_FILE);
		TheLastWord object = new TheLastWord();

		int numberOfTestCases = scanner.nextInt();
		for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {

			String output = "Case #" + caseNumber + ": " + object.solve(scanner.next());
			if (GCJ) {
				printWriter.println(output);
			}
			System.out.println(output);
		}

		printWriter.close();
		scanner.close();
	}

	private String solve(String input) {
		char largestChar = input.charAt(0);
		String result = String.valueOf(largestChar);
		
		for (int i=1; i<input.length(); i++) {
			if (input.charAt(i) >= largestChar) {
				largestChar = input.charAt(i);
				result = largestChar + result;
			} else {
				result = result + input.charAt(i);
			}
		}
		return result;
	}
}
