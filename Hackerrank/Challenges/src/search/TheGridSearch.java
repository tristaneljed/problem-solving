package search;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/the-grid-search
 */
public class TheGridSearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			String[] matrix1, matrix2;
			
			int r1 = s.nextInt(); s.nextInt();
			matrix1 = new String[r1];
			for (int i=0; i<r1; i++) {
				matrix1[i] = s.next();
			}
			
			int r2 = s.nextInt(); s.nextInt();
			matrix2 = new String[r2];
			for (int i=0; i<r2; i++) {
				matrix2[i] = s.next();
			}
			System.out.println(gridSearch(matrix1, matrix2));
		}
		s.close();
	}

	private static String gridSearch(String[] matrix1, String[] matrix2) {
		int r1 = matrix1.length;
		int r2 = matrix2.length;
		
		for (int i=0; i<=(r1-r2); i++) {
			int count = 0;
			int prevIndex = -100;
			int curIndex;
			while (count < r2) {
				curIndex = matrix1[i + count].indexOf(matrix2[count]);
				if ((curIndex != -1) && ((prevIndex == -100) || (prevIndex == curIndex))) {
					count++;
					prevIndex = curIndex;
				} else {
					break;
				}
			}
			if (count == r2) {
				return "YES";
			}
		}
		return "NO";
	}

}
