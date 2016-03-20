package dynamicprogramming;

import java.util.Scanner;

public class Maxsubarray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i=0; i<t; i++) {
			int size = s.nextInt();
			int array[] = new int[size];
			for (int j=0; j<size; j++) {
				array[j] = s.nextInt();
			}
			System.out.println(contiguousSum(array) + " " + nonContiguousSum(array));
		}
		s.close();
	}

	private static int contiguousSum(int[] array) {
		int maxOverall = array[0];
		int maxCurrent = array[0];
		
		for (int i=1; i<array.length; i++) {
			maxCurrent += array[i];
			if (maxCurrent < array[i]) {
				maxCurrent = array[i];
			}
			if (maxOverall < maxCurrent) {
				maxOverall = maxCurrent;
			}
		}
		
		return maxOverall;
	}
	
	private static int nonContiguousSum(int[] array) {
		int sum = array[0];
		for (int i=1; i<array.length; i++) {
			if (sum < 0) {
				if (sum < array[i]) {
					sum = array[i];
				}
			} else {
				if (array[i] > 0) {
						sum += array[i];
					}
				}
			}
		return sum;
	}

}
