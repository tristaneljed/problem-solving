package search;
import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int punctual = 0;
			for (int i=0; i<n; i++) {
				if (s.nextInt() < 1) {
					punctual++;
				}
			}
			if (punctual < k) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}
}
