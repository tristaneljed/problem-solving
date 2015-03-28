import java.util.Scanner;


public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			int sum = 0;
			int len = s.nextInt();
			int [] array = new int[len];
			for (int i=0; i<len; i++) {
				array[i] = s.nextInt();
				sum += array[i];
			}
			System.out.println(sherlockArrayScan(array, sum));
		}
		s.close();
	}

	private static String sherlockArrayScan(int[] array, int sum) {
		if (array.length == 1) {
			return "YES";
		}
		
		int leftSum = 0;
		int rightSum = 0;
		for (int i=0; i<array.length; i++) {
			if (i == 0) {
				leftSum = 0;
			} else {
				leftSum += array[i-1];
			}
			rightSum = sum - leftSum - array[i];
			if (leftSum == rightSum) {
				return "YES";
			}
		}
		return "NO";
	}

}
