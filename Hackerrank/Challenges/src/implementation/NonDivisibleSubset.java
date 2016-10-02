package implementation;

import java.util.Scanner;

public class NonDivisibleSubset {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		NonDivisibleSubset object = new NonDivisibleSubset();
		int n = s.nextInt();
		int k = s.nextInt();
		int[] modFrequency = new int[100];
		for (int i=0; i<n; i++) {
			modFrequency[s.nextInt() % k] += 1;
		}
		object.solve(modFrequency, k, n);
		s.close();
	}

	private void solve(int[] modFrequency, int k, int n) {
		int result = n;
		if (modFrequency[0] > 1) {
			result -= modFrequency[0] - 1;
		}
		if ((k % 2 == 0) && modFrequency[k/2] > 1) {
			result -= modFrequency[k/2] - 1;
		}
		int temp = 1;
		for (int i=k-1; i>k/2; i--, temp++) {
			int min = Math.min(modFrequency[i], modFrequency[temp]);
			result -= min;
		}
		System.out.println(result);
	}
}
