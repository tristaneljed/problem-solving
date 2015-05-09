package warmup;

import java.util.Scanner;

public class IdentifySmithNumber {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(isSmithNumber(s.nextInt()) ? 1: 0);
		s.close();
	}

	private static boolean isSmithNumber(final int number) {
		int sumOfPrimeFactors = 0;
		int sumOfDigits = sumOfDigits(number);
		int numCopy = number;
		
		for (int i=2; i <= numCopy; i = (i==2) ? 3 : i+2 ) {
			while (numCopy % i == 0) {
				sumOfPrimeFactors += sumOfDigits(i);
				numCopy /= i;
			}
		}
		return sumOfDigits == sumOfPrimeFactors;
	}

	private static int sumOfDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}
