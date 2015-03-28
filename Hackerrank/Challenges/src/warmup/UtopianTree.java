package warmup;
import java.util.Scanner;

public class UtopianTree {
	private static long[] heightArray;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		preCalculation();
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(heightArray[s.nextInt()]);
		}
		s.close();
	}

	private static void preCalculation() {
		heightArray = new long[61];
		long height = 1;
		heightArray[0] = height;
		for (int cycle=1; cycle<61; cycle++) {
			if (cycle % 2 == 1) {
				height *= 2;
			} else {
				height += 1;
			}
			heightArray[cycle] = height;
		}
	}

}
