package dynamicprogramming;

import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] ratings = new int[n];
		for (int i=0; i<n; i++) {
			ratings[i] = s.nextInt();
		}
		System.out.println(solve(ratings, n));
		s.close();
	}

	private static int solve(int[] ratings, int n) {
		if (n==1) {
			return 1;
		}
		
		int[] candies = new int[n];
		
		if (ratings[0] < ratings[1]) {
			ratings[0] = 1;
		}
		
		if (ratings[n-1] < ratings[n-2]) {
			candies[n-1] = 1;
		}
		
		for(int i=1; i<n-1; i++) {
			if (ratings[i-1] > ratings[i] && ratings[i+1] > ratings[i]) {
				candies[i] = 1;
			}
		}
		
		
		return 0;
	}
}
