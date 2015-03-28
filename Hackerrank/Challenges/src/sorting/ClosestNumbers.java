package sorting;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in );
		int size = s.nextInt();
		int array[] = new int[size];
		for (int i=0; i<size; i++) {
			array[i] = s.nextInt();
		}
		solve(array);
		s.close();
	}

	private static void solve(int[] array) {
		int numOfPairs = 0;
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(array);
		
		//Find num of pairs having min value
		for (int i=0; i<array.length - 1; i++) {
			int diff = array[i+1] - array[i];
			if (diff < minDiff) {
				minDiff = diff;
				numOfPairs = 1;
			} else if (diff == minDiff) {
				numOfPairs++;
			}
		}
		
		//Print the pairs
		for (int i=0; (i<array.length-1) && (numOfPairs > 0); i++) {
			int diff = array[i+1] - array[i];
			if (diff == minDiff) {
				System.out.print(array[i] + " " + array[i+1] + " ");
				numOfPairs--;
			}
		}
	}
}
