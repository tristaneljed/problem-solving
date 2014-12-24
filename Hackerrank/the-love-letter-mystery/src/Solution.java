import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = Integer.parseInt(s.nextLine());
		while(numOfTestCases-- > 0) {
			System.out.println(minimumNumberOfOperations(s.nextLine()));
		}
		s.close();
	}

	private static int minimumNumberOfOperations(String str) {
		int operationCount = 0;
		int len = str.length();
		for (int i=0; i<(len/2); i++) {
			operationCount += Math.abs(str.charAt(i) - str.charAt(len-1-i));
		}
		return operationCount;
	}

}
