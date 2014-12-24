import java.util.Scanner;

public class Solution {

	static int findDigits(long number) {
		int count = 0;
		while(number != 0) {
			int digit = (int) (number - ((number/10) * 10));
			if ((digit != 0) && (number % digit == 0)) {
				count++;
			}
			number /= 10;
		}
		return count++;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases > 0) {
			System.out.println(findDigits(s.nextLong()));
			numOfTestCases--;
		}
		s.close();
	}

}
