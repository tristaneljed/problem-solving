package warmup;

import java.util.Scanner;

public class KaprekarNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long low  = s.nextInt();
		long high = s.nextInt();
		boolean kaprekarExist = false;
		
		for (long i = low; i<=high; i++ ) {
			if (isKaprekar(i)) {
				kaprekarExist = true;
				System.out.print(i + " ");
			}
		}
		
		if (!kaprekarExist) {
			System.out.print("INVALID RANGE");
		}
		
		s.close();
	}

	private static boolean isKaprekar(long num) {
		long square = num * num;
		int d = numOfDigits(square);
		d = d - (d/2);
		double power = Math.pow(10, d);
		long right = (long) (square % power);
		long left = (long) (square / power);
		return ((left + right) == num );
	}

	private static int numOfDigits(long num) {
		int count = 0;
		while (num > 0) {
			count++;
			num /= 10;
		}
		return count;
	}
}
