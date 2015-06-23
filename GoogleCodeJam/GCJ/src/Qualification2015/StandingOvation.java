package Qualification2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class StandingOvation {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		if (args.length != 2) {
			System.out.println("Usage: java StandingOvation <input-file> <output-file>");
			System.exit(-1);
		}
		
		Scanner s = new Scanner(new File(args[0]));
		PrintWriter outputFile = new PrintWriter(args[1], "UTF-8");
		int t = s.nextInt();
		for (int i=1; i<=t; i++) {
			int smax = s.nextInt();
			String shyness = s.next();
			outputFile.println("Case #" + i + ": " + solve(smax, shyness));
		}
		outputFile.close();
		s.close();
	}

	private static int solve(int smax, String shyness) {
		int count = 0;
		int numOfFriends = 0;
		for (int i=0; count<smax; i++) {
			if (shyness.charAt(i) == '0' && (count < i + 1)) {
				numOfFriends++;
				count++;
			} else {
				count += (int) (shyness.charAt(i) - '0'); 
			}
		}
		return numOfFriends;
	}
}
