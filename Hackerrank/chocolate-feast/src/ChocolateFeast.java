import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			int n = s.nextInt();
			int c = s.nextInt();
			int m = s.nextInt();
			System.out.println(totalChocolates(n,c,m));
		}
		s.close();
	}

	private static int totalChocolates(int n, int c, int m) {
		boolean flag = true;
		int numOfChocolates = n/c;
		int totalChocolates = numOfChocolates;
		int extraChocolates = 0;
		while(flag) {
			extraChocolates = numOfChocolates % m;
			numOfChocolates /= m;
			totalChocolates += numOfChocolates;
			if (numOfChocolates + extraChocolates < m) {
				flag = false;
			}
			numOfChocolates += extraChocolates;
		}
		return totalChocolates;
	}

}
