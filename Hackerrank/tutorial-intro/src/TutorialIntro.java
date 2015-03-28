import java.util.Scanner;

public class TutorialIntro {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int n = s.nextInt();
		int index = -1;
		int [] ar = new int[n];
		for (int i=0; i<n; i++) {
			ar[i] = s.nextInt();
			if (ar[i] == v) {
				index = i;
			}
		}
		System.out.println(index);
		s.close();
	}

}
