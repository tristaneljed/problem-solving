package bitmanipulation;
import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(flippedUnsigned(s.nextLong()));
		}
		s.close();
	}

	private static long flippedUnsigned(long num) {
		return (~num) & 0x00000000ffffffffL;
	}
}
