import java.util.Scanner;


public class Solution {

	private static int a[] = new int[201];
	private static int b[] = new int[201];
	private static int missing[] = new int[201];
	private static int n;
	private static int m;
	private static int factor;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		factor = s.nextInt() - 100;
		a[100]++;
		for (int i=0; i<n-1; i++) {
			a[s.nextInt() - factor]++;
		}
		
		m = s.nextInt();
		for (int i=0; i<m; i++) {
			b[s.nextInt() - factor]++;
		}
		
		for (int i=0; i<201; i++) {
			missing[i] = b[i] - a[i];
			if (missing[i] > 0) {
				System.out.print( (i+factor) + " " );
			}
		}
		s.close();
	}

}
