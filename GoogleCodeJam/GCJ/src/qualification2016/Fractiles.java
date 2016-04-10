package qualification2016;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Fractiles {
	
	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("resource/Fractiles-large.in"));
		//Scanner scanner = new Scanner(System.in);
		PrintWriter printWriter = new PrintWriter(new File("resource/Fractiles-large.out"));
		int t = scanner.nextInt();
		for (int caseNumber=1; caseNumber<=t; caseNumber++) {
			int k = scanner.nextInt();
			int c = scanner.nextInt();
			int s = scanner.nextInt();
			try {
				printWriter.println("Case #" + caseNumber + ": " + solve(k, c, s));
			} catch(Exception e) {
				System.err.println("Error in case " + caseNumber);
			}
		}
		printWriter.close();
		scanner.close();
	}

	private static String solve(int k, int c, int s) throws Exception {
		StringBuilder result = new StringBuilder();
		if (c==1) {
			if (s<k) {
				return IMPOSSIBLE;
			} else {
				for(int i=1; i<=k; i++) {
					result.append(i);
					result.append(" ");
				}
				return result.toString();
			}
		}
		
		if (k == 1) {
			return "1";
		}
		
		int minimumStudentsRequired = (k%2==0) ? k/2 : (k/2) + 1;
		if (s < minimumStudentsRequired) {
			return IMPOSSIBLE;
		}
		
		BigInteger position = new BigInteger("2");
		
		long increment = 1;
		for (int i=0; i<c-1; i++) {
			increment *= k;
		}
		increment *= 2;
		increment += 2;
		
		for (int student = 0; student<minimumStudentsRequired; student++) {
			if (position.compareTo(new BigInteger(String.valueOf(((increment -2)/2) * k))) > 0) {
				position = position.subtract(BigInteger.ONE);
			}
			if (position.compareTo(new BigInteger(String.valueOf(((increment -2)/2) * k))) > 0) {
				throw new Exception("Some issue");
			}
			result.append(position);
			result.append(" ");
			position = position.add(new BigInteger(String.valueOf(increment)));
		}
		return result.toString();
	}
}
