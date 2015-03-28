import java.util.Scanner;

public class SherlockAndTheBeast {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(maxDecentNumber(s.nextInt()));
		}
		s.close();
	}

	private static String maxDecentNumber(int numOfDigits) {
		int numOfFiveSets;
		int numOfFives;
		int numOfThrees = 0;
		for (numOfFiveSets=(numOfDigits/3) ; numOfFiveSets>=0; numOfFiveSets--) {
			numOfThrees = numOfDigits - (3 * numOfFiveSets);
			if(numOfThrees % 5 == 0) {
				break;
			}
		}
		if (numOfFiveSets < 0) {
			return "-1";
		}
		numOfFives = numOfFiveSets * 3;
		char[] decentNumber = new char[numOfDigits];
		for (int i=0; i<numOfDigits; i++) {
			if (numOfFives > 0) {
				decentNumber[i] = '5';
				numOfFives--;
			} else {
				decentNumber[i] = '3';
			}
		}
		return String.valueOf(decentNumber);
	}
}
