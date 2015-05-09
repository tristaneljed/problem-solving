package warmup;

import java.util.Scanner;

public class TaumAndBday {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			long b = s.nextInt();
			long w = s.nextInt();
			long x = s.nextInt();
			long y = s.nextInt();
			long z = s.nextInt();
			
			long result = (b * Math.min(x, y+z)) + (w * Math.min(y, x+z)); 
			System.out.println(result);
		}
		s.close();
	}
}
