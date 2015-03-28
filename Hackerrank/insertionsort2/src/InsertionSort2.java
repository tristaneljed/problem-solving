import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int array[] = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = s.nextInt();
		}
		
		for (int i=1; i<n; i++) {
			int v = array[i];
			int index = i;
			while ((index > 0) && (v < array[index-1])) {
				array[index] = array[index-1];
				index--;
			}
			array[index] = v;
			print(array);
		}
		s.close();
	}
	
	public static void print(int [] array) {
		for (int i:array) {
			System.out.print(i + " ");;
		}
		System.out.println();
	}
}