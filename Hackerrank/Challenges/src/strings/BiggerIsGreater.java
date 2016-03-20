package strings;
import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(solve(s.next()));
		}
		s.close();
	}

	private static String solve(String str) {
		System.out.println("::" + str);
		char[] input = str.toCharArray();
		
		int index = -1;
		for (int i=0; i<input.length-1; i++) {
			if (input[i] < input[i+1]) {
				index = i;
			}
		}
		
		if (index == -1) {
			return "no answer";
		}
		
		int min = index;
		
		for (int i=index+1; i<input.length; i++) {
//			if ((input[i] > input[index]) && ())
		}
		
		return null;
	}

}
