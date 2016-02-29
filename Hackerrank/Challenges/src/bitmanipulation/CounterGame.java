package bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestcases = s.nextInt();
		while (numberOfTestcases-- > 0) {
			BigInteger number = s.nextBigInteger();
			int numberOfTurns = number.getLowestSetBit() + number.bitCount();
			String winner = (numberOfTurns %2 == 1) ? "Richard" : "Louise";
			System.out.println(winner);
		}
		s.close();
	}
}
