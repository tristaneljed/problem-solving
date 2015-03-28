package numbertheory;
import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			int l = s.nextInt();
			int b = s.nextInt();
			System.out.println(solve(l, b));
		}
		s.close();
	}

	private static int solve(int l, int b) {
		if (l == b) {
			return 1;
		}
		int hcf = gcd(l, b);
		return (l * b) / (hcf * hcf);
	}

	private static int gcd (int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		
		if (big % small == 0) {
			return small;
		} else {
			return gcd (small, big % small);
		}
	}
}