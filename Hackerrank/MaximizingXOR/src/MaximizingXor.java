import java.util.Scanner;

public class MaximizingXor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] twoPower = new int[] {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023};
		int l = s.nextInt();
		int r = s.nextInt();
		boolean flag = true;
		
		for (int i=10; i>=0 && flag; i--) {
			for (int j=l; j<=r; j++) {
				int xor = j ^ twoPower[i];
				if ((xor <=r) && (xor>=l)) {
					System.out.println(twoPower[i]);
					flag = false;
					break;
				}
			}
		}
		s.close();
	}

}