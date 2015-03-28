package search;
/*
 * https://www.hackerrank.com/challenges/circle-city 
 */

import java.util.Scanner;

public class CircleCity {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			System.out.println(solve(s.nextInt(), s.nextInt()));
		}
		s.close();
	}

	private static String solve(int r, int k) {
		int count = 0;
		int rad = isSquare(r) ? (int) Math.sqrt(r) : (int) Math.sqrt(r) + 1;
		int x = 0;
		int y = 0;
		
		while ( (x < rad) && (count <= k) ) {
			y = r - (x * x);
			if (isSquare(y)) {
				count += 4;
			}
			x++;
		}
		
		if (count <= k) {
			return "possible";
		} else {
			return "impossible";
		}
	}

	private static boolean isSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		return (sqrt * sqrt == num);
	}
}
