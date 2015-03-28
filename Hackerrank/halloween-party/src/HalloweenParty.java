import java.util.Scanner;

public class HalloweenParty {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			System.out.println(numOfPieces(s.nextInt()));
		}
		s.close();
	}

	private static long numOfPieces(int num) {
		long num1 = num/2;
		long num2 = num - num1;
		return num1 * num2;
	}
}
