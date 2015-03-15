import java.util.Scanner;
/*
 * Take input an array of unique integers and output an array 
 * such that it follows following relation :-
 * [first_num] > [second_num] < [third_num] > [fourth_num] .. and so on
 * 
 *   Input format :-
 *   <array-size>
 *   <first integer>
 *   <second integer>
 *   .... <all other integers>
 *   
 *   Output format :-
 *   <Print array with one integer on each line>
 */

public class FancyOutput {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = s.nextInt();
		}
		printFancyOutput(arr);
		s.close();
	}

	private static void printFancyOutput(int[] a) {
		boolean greater = true;
		for (int i=0; i<a.length - 1; i++) {
			if ( (greater && (a[i] < a[i+1])) || (!greater && (a[i] > a[i+1])) ) {
					swap(a, i);
			}
			greater = !greater;
			System.out.println(a[i] + " ");
		}
	}

	private static void swap(int[] a, int i) {
		int temp;
		temp = a[i];
		a[i] = a[i+1];
		a[i+1] = temp;
	}
}
