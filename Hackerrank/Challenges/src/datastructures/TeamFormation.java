package datastructures;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TeamFormation {

	public static void msain(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> array;
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			int arraySize = s.nextInt();
			array = new ArrayList<>();
			for (int i=0; i<arraySize; i++) {
				array.add(s.nextInt());
			}
			System.out.println();
		}
		s.close();
	}

}
