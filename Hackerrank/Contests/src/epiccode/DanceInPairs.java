package epiccode;

import java.util.Arrays;
import java.util.Scanner;

public class DanceInPairs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[] boys = new int[n];
		int[] girls = new int[n];
		
		for (int i=0; i<n; i++) {
			boys[i] = s.nextInt();
		}
		for (int i=0; i<n; i++) {
			girls[i] = s.nextInt();
		}
		
		Arrays.sort(boys);
		Arrays.sort(girls);
		
		int numOfPairs = 0;
		
		int i=0, j=0;
		
		while ((i < boys.length) && (j < girls.length) ) {
			if (Math.abs(boys[i] - girls[j]) <= k) {
				numOfPairs++;
				i++;
				j++;
			} else if (boys[i] > girls[j]) {
				j++;
			} else {
				i++;
			}
		}
		
		System.out.println(numOfPairs);
		
		s.close();
	}

}
