import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/icecream-parlor
 */

public class IcecreamParlor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			int m = s.nextInt();
			int n = s.nextInt();
			int array[] = new int[n];
			for (int i=0; i<n; i++) {
				array[i] = s.nextInt();
			}
			System.out.println(findIndexPair(array, m));
		}
		s.close();
	}

	private static String findIndexPair(int[] array, int m) {
		for (int i=0; i<array.length-1; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[i] + array[j] == m) {
					return (i+1) + " " + (j+1);
				}
			}
		}
		return null;
	}

}
