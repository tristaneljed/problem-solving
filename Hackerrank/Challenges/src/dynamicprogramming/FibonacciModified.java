package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	private static BigInteger a,b;
	
	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		a = s.nextBigInteger();
		b = s.nextBigInteger();
		int n = s.nextInt();
//		long startTime = System.currentTimeMillis();
		System.out.println(solve(n));
//		long endTime = System.currentTimeMillis();
//		System.out.println("Time : " + (endTime - startTime));
		s.close();
	}

	private static BigInteger solve(int n) {
		return (n == 1) ? a :
			   (n == 2) ? b :
			   (solve(n - 1).multiply(solve(n - 1)).add(solve(n - 2)));
	}
}
