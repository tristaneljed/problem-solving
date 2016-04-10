package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class DanceAroundTheClock {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner s = new Scanner(new File("DanceAroundTheClock-large.in"));
		PrintWriter pw = new PrintWriter("DanceAroundTheClock-large.out", "UTF-8");
		
		int t = s.nextInt();
		
		for (int cases=1; cases<=t; cases++) {
			int d = s.nextInt();
			int k = s.nextInt();
			int n = s.nextInt() % d;
			
			int positionOfKthDancer = positionOfKthDancer(k, n, d);
			int dancerOnLeft = dancerOnXthPosition(positionOfKthDancer+1, 
					n, d, ((k+1)%2 == 0));
			int dancerOnRight = dancerOnXthPosition(positionOfKthDancer-1, 
					n, d, ((k-1)%2 == 0));
			
			String output = "Case #" + cases + ": " + dancerOnLeft + " " + dancerOnRight;
			System.out.println(output);
			pw.println(output);
		}
		
		pw.close();
		s.close();
	}
	
	private static int positionOfKthDancer(int k, int n, int d) {
		return (k % 2 == 0) ? ((k + d - n - 1) % d) + 1 : ((k + n - 1) % d) + 1;
	}
	
	private static int dancerOnXthPosition(int x, int n, int d, boolean isEvenDancer ) {
		 return (isEvenDancer) ? (( x + n + d - 1) % d) + 1: ((x - n + d - 1) % d) + 1;
	}

}
