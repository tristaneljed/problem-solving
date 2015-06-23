package ciscoapril2015;

import java.util.Scanner;

public class SecurePasswordSystem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int m = s.nextInt();
			int M = s.nextInt();
			System.out.println(solve(m, M));
		}
		s.close();
	}

	private static String solve(int m, int M) {
		if (M > 6) {
			return "YES";
		} else if (M < 6) {
			return "NO";
		} else if (m == M) {
			return "NO";
		} else {
			return "YES";
		}
	}

}
