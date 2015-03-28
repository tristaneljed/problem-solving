import java.util.Scanner;

public class SolveMeSecond {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while(numOfTestCases-- > 0) {
			System.out.println(s.nextInt() + s.nextInt());
		}
		s.close();
	}

}
