package dynamicprogramming;

import java.util.Scanner;

public class CoinChange {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] c = new int[m];
		
		for (int i=0; i<m; i++) {
			c[i] = s.nextInt();
		}
		System.out.println(solve(n, c, m));
		s.close();
	}

	private static int solve(int n, int[] c, int m) {
		if (n == 0) {
			return 1;
		}
		if (n < 0 || m <= 0) {
			return 0;
		}
		return solve(n, c, m-1) + solve(n - c[m-1], c, m);
	}
}
