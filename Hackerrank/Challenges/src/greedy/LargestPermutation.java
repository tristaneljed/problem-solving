package greedy;

import java.util.Scanner;

public class LargestPermutation {
	
	private static int array[];
	private static int revLookup[];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		array = new int[n];
		revLookup = new int[n+1];
		
		for(int i=0; i<n; i++) {
			array[i] = s.nextInt();
			revLookup[array[i]] = i;
		}
		
		solve(n, k);
		s.close();
	}

	private static void solve(int n, int k) {
		int swapCount = 0;
		for (int i=0; (i < n) && (swapCount < k); i++) {
			if (array[i] != (n-i)) {
				swap(i, revLookup[n-i]);
				swapCount++;
			}
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static void swap(int i, int j) {
		//Swap array
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		//Swap revLookup
		int num1 = array[i];
		int num2 = array[j];
		temp = revLookup[num1];
		revLookup[num1] = revLookup[num2];
		revLookup[num2] = temp;
	}

}
