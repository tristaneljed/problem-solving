package round1a2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MushroomMonster {
	
	private static final String INPUT_FILE = "resource/MushroomMonster-large.in";
	private static final String OUTPUT_FILE = "resource/MushroomMonster-large.out";
	private static final boolean GCJ = true;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = GCJ ? new Scanner(new File(INPUT_FILE))
				: new Scanner(System.in);
		PrintWriter printWriter = new PrintWriter(OUTPUT_FILE);
		MushroomMonster object = new MushroomMonster();

		int numberOfTestCases = scanner.nextInt();
		for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {

			int n = scanner.nextInt();
			int[] mushrooms = new int[n];
			
			for (int i=0; i<n; i++) {
				mushrooms[i] = scanner.nextInt();
			}

			String output = "Case #" + caseNumber + ": " + object.solve(n, mushrooms);
			if (GCJ) {
				printWriter.println(output);
			}
			System.out.println(output);
		}

		printWriter.close();
		scanner.close();
	}

	private String solve(int n, int[] mushrooms) {

		int firstResult = 0;
		int maxDrop = -1;
		//first way
		int prev = mushrooms[0];
		for (int i=1; i<n; i++) {
			int drop = prev - mushrooms[i];
			if (prev > mushrooms[i]) {
				firstResult += drop;
			}
			
			if (maxDrop < drop) {
				maxDrop = drop;
			}
			
			prev = mushrooms[i];
		}
		
		int secondResult = 0;
		for (int i=0; i<n-1; i++) {
			secondResult += (mushrooms[i] > maxDrop) ? maxDrop : mushrooms[i];
		}
		
		return firstResult + " " + secondResult;
	}
}
