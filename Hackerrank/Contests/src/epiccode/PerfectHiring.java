package epiccode;

import java.util.Scanner;

public class PerfectHiring {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p = s.nextInt();
		int x = s.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = s.nextInt();
		}
		System.out.println(solve(n, p, x, a));
		s.close();
	}

	private static int solve(int n, int p, int x, int[] a) {
		long maxRating = -1L;
		int index = -1;
		
		for (int i=0; i<n; i++) {
			long rating = (long) (a[i]) * p;
			if (rating > maxRating) {
				index = i;
				maxRating = rating;
			}
			p -= x;
		}
		
		return index+1;
	}
}
