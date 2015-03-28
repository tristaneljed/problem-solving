import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static long[] candies;
	private static int n,k;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		k = s.nextInt();
		candies = new long[n];
		for (int i=0; i<n; i++) {
			candies[i] = s.nextLong();
		}
		System.out.println(minUnfairness());
		s.close();
	}
	
	private static long minUnfairness() {
		Arrays.sort(candies);
		long minUnfairness = candies[n-1] - candies[0];
		for (int i=0; i<n-k+1; i++) {
			long temp = candies[i+k-1] - candies[i];
			if (temp < minUnfairness) {
				minUnfairness = temp;
			}
		}
		return minUnfairness;
	}

}
