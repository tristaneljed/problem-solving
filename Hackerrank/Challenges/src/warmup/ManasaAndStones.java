package warmup;
import java.util.Scanner;

public class ManasaAndStones {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			possibleValues(s.nextInt(), s.nextInt(), s.nextInt());
		}
		s.close();
	}

	private static void possibleValues(int numOfStones, int a, int b) {
		if (a == b) {
			System.out.println(a * (numOfStones - 1));
			return;
		}
		int small = Math.min(a, b);
		int big = Math.max(a, b); 
		for(int i=0; i<numOfStones; i++) {
			int value = (small * (numOfStones - 1 - i)) + (big * i); 
			System.out.print(value);
			if (i != numOfStones-1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
