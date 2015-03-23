package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int array[] = new int[size];
		
		for (int i=0; i<size; i++) {
			array[i] = s.nextInt();
		}
		
		System.out.println(solve(array));
		s.close();
	}

	private static int solve(int[] array) {
		Arrays.sort(array);
		int count = 1;
		int val = array[0] + 5;
		for (int i=1; i<array.length; i++) {
			if (array[i] < val) {
				continue;
			} else {
				val = array[i] + 5;
				count++;
			}
		}
		return count;
	}
}
