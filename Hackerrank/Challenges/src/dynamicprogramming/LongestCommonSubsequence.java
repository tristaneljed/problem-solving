package dynamicprogramming;

import java.util.Scanner;
import java.util.Stack;

public class LongestCommonSubsequence {
	
	private static int c[][] = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[m];
		
		for (int i=0; i<n; i++) {
			a[i] = s.nextInt();
		}
		
		for (int i=0; i<m; i++) {
			b[i] = s.nextInt();
		}
		
		c = new int[m+1][n+1];
		
		for (int i=1; i<m+1; i++) {
			for (int j=1; j<n+1; j++) {
				if (a[j-1] == b[i-1]) {
					c[i][j] = c[i-1][j-1] + 1;
				}
				else {
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
				}
			}
		}
		
		int i = m, j = n ;
		Stack<Integer> lcs = new Stack<>();
		while(i>0 && j>0) {
			if (c[i][j] == c[i-1][j]) {
				i--;
			} else if (c[i][j] == c[i][j-1]){
				j--;
			} else {
				lcs.push(a[j-1]);
				i--;
				j--;
			}
		}
		
		while (!lcs.isEmpty()) {
			System.out.print(lcs.pop() + " ");
		}
		
		s.close();
	}

}
