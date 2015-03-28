import java.util.Scanner;

public class ReverseGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			System.out.println(solve(n, k));
		}
		s.close();
	}

	/* Observation in problem is that the after the iteration the final result 
	 * is of the following form => 
	 * last_num, first_num, second_last_num, second_num, ....
	 * Using that logic getting the position in O(1). 
	 */
	private static int solve(int n, int k) {
		k = k + 1;
		// If the number is in first half then it will be second part of pair
		int loc = (k > n/2) ? 1 : 2;
		// Fetch the pair number
		int pairNumber = (k > n/2) ? (n + 1 - k) : k;
		return ((pairNumber - 1) * 2) + loc - 1;
	}
}
