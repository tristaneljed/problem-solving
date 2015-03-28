package warmup;
import java.util.Scanner;

public class SherlockAndGcd {
	private static final String yes = "YES";
	private static final String no = "NO";

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			int size = s.nextInt();
			int array[] = new int[size];
			for (int i=0; i<size; i++) {
				array[i] = s.nextInt();
			}
			System.out.println(solve(array));
		}
		s.close();
	}

	private static String solve(int[] array) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (gcd(array[i], array[j]) == 1) {
					return yes;
				}
			}
		}
		return no;
	}

	private static int gcd(int i, int j) {
		int big = Math.max(i, j);
		int small = Math.min(i, j);
		
		if (big % small == 0) {
			return small;
		} else {
			return gcd(small, big % small);
		}
	}

}
