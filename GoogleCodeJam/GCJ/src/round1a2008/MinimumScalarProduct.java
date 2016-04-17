package round1a2008;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumScalarProduct {
	
	private static final String INPUT_FILE = "resource/MinimumScalarProduct-large.in";
	private static final String OUTPUT_FILE = "resource/MinimumScalarProduct-large.out";
	private static final boolean GCJ = true;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = GCJ ? new Scanner(new File(INPUT_FILE))
				: new Scanner(System.in);
		PrintWriter printWriter = new PrintWriter(OUTPUT_FILE);
		MinimumScalarProduct object = new MinimumScalarProduct();

		int numberOfTestCases = scanner.nextInt();
		for (int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {

			int n = scanner.nextInt();
			int[] array1 = new int[n];
			int[] array2 = new int[n];

			for (int i=0; i<n; i++) {
				array1[i] = scanner.nextInt();
			}
			for (int i=0; i<n; i++) {
				array2[i] = scanner.nextInt();
			}

			String output = "Case #" + caseNumber + ": " + object.solve(array1, array2);
			if (GCJ) {
				printWriter.println(output);
			}
			System.out.println(output);
		}

		printWriter.close();
		scanner.close();
	}

	private String solve(int[] vector1, int[] vector2) {
		Arrays.sort(vector1);
		Arrays.sort(vector2);
		int n = vector1.length;
		BigInteger result = BigInteger.ZERO;
		
		for (int i=0; i<n; i++) {
			long multiplication = ((long)vector1[i]) * vector2[n-i-1];
			result = result.add(new BigInteger(String.valueOf(multiplication))) ;
		}
		
		return result.toString();
	}
}
