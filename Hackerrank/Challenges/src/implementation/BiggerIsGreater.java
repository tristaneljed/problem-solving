package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		BiggerIsGreater object = new BiggerIsGreater();

		while (t-- > 0) {
			String input = s.next();
			object.solve(input);
		}

		s.close();
	}

	private void solve(String input) {
		
		if (input.length() == 1) {
			System.out.println("no answer");
			return;
		}
		
		char[] inputArray = input.toCharArray();
		int pivot = -1;
		for (int i=input.length()-2; i>=0; i--) {
			if (inputArray[i] < inputArray[i+1]) {
				pivot = i;
				break;
			}
		}
		
		if (pivot == -1) {
			System.out.println("no answer");
			return;
		}
		
		for (int i=input.length()-1; i>pivot; i--) {
			if (inputArray[i] > inputArray[pivot]) {
				char temp = inputArray[i];
				inputArray[i] = inputArray[pivot];
				inputArray[pivot] = temp;
				break;
			}
		}
		
		Arrays.sort(inputArray, pivot+1, input.length());
		System.out.println(new String(inputArray));
	}
}
