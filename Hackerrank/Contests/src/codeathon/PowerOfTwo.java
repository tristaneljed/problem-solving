package codeathon;

import java.util.Arrays;
import java.util.Scanner;

public class PowerOfTwo {
	private static int bitCount[] ;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-- > 0) {
			boolean isTwoPower = false;
			int size = s.nextInt();
			while (size-- > 0) {
				if (isPowerOfTwo(s.nextInt())) {
					isTwoPower = true;
				}
			}
			if (isTwoPower) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}

	private static boolean isPowerOfTwo(int num) {
		while (num != 0) {
			if (num % 2 == 1) {
				if (num != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static String check() {
		int count = 1;
		Arrays.sort(bitCount);
		System.out.println("bitCount => " + bitCount);
		for (int i=1; i<32; i++) {
			if (bitCount[i] == bitCount[i-1]) {
				count++;
			} else {
				if (count == 1) {
					return "YES";
				} else {
					count = 1;
				}
			}
		}
		
		return (count == 1) ? "YES": "NO";
	}

}
