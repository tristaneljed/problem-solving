import java.util.Scanner;

public class InsertionSort1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int array[] = new int[n];
		for (int i=0; i<n-1; i++) {
			array[i] = s.nextInt();
		}
		int v = s.nextInt();
		int index = n-1;
		while ((index > 0) && (v < array[index-1])) {
			array[index] = array[index-1];
			index--;
			print(array);
		}
		array[index] = v;
		print(array);
		s.close();
	}
	
	public static void print(int [] array) {
		for (int i:array) {
			System.out.print(i + " ");;
		}
		System.out.println();
	}
}
