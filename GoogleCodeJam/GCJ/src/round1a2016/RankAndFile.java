package round1a2016;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RankAndFile {
	
	private static final String INPUT_FILE = "resource/RankAndFile-large.in";
	private static final String OUTPUT_FILE = "resource/RankAndFile-large.out";
	private static final boolean GCJ = true;

	public static void main(String[] args) throws Exception {
		Scanner scanner = GCJ ? new Scanner(new File(INPUT_FILE))
				: new Scanner(System.in);
		PrintWriter printWriter = new PrintWriter(OUTPUT_FILE);
		RankAndFile object = new RankAndFile();

		int numberOfTestCases = scanner.nextInt();
		for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {

			int n = scanner.nextInt();
			int[] input = new int[(2*n*n) -n];
			
			for (int i=0; i<(2*n*n)-n; i++) {
					input[i] = scanner.nextInt();
			}

			String output = "Case #" + caseNumber + ": " + object.solve(input);
			if (GCJ) {
				printWriter.println(output);
			}
			System.out.println(output);
		}

		printWriter.close();
		scanner.close();
	}

	private String solve(int[]input) {
		Arrays.sort(input);
		List<Integer> oddOccurence = new ArrayList<>();
		
		int prev=input[0];
		int counter = 1;
		for (int i=1; i<input.length; i++) {
			if (prev == input[i]) {
				counter++;
			} else {
				if (counter%2 == 1) {
					oddOccurence.add(prev);
				}
				prev = input[i];
				counter = 1;
			}
		}
		if(counter % 2 == 1) {
			oddOccurence.add(prev);
		}
		
		Collections.sort(oddOccurence);
		StringBuilder sb = new StringBuilder();
		for (int num:oddOccurence) {
			sb.append(num);
			sb.append(" ");
		}
		
		return sb.toString();
	}
}