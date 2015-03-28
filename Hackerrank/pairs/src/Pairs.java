import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int array[] = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = s.nextInt();
		}
		System.out.println(pairCount(array, n, k));
		s.close();
	}

	private static int pairCount(int[] array, int n, int k) {
		int count = 0;
		Arrays.sort(array);
		for (int i=1; i<n; i++) {
			int key = array[i-1] + k;
			if (Arrays.binarySearch(array, key) > 0) {
				count++;
			}
		}
		return count;
	}

}
