package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TwoArrays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			Integer a[] = new Integer[n];
			Integer b[] = new Integer[n];
			
			for (int i=0; i<n; i++) {
				a[i] = s.nextInt();
			}
			
			for (int i=0; i<n; i++) {
				b[i] = s.nextInt();
			}
			
			System.out.println(solve(a, b, k));
		}
		s.close();
	}

	private static String solve(Integer[] a, Integer[] b, int k) {
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		for(int i=0; i<a.length; i++) {
			if (a[i] + b[i] < k) {
				return "NO";
			}
		}
		return "YES";
	}
}
