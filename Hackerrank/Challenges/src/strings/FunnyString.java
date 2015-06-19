package strings;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			String str = s.next();
			char []strArr = str.toCharArray();
			int len = strArr.length;
			boolean isFunny = true;
			for (int i=0; i<(len/2); i++) {
				if(Math.abs(strArr[i] - strArr[i+1]) != Math.abs(strArr[len-i-1] - strArr[len-i-2])) {
					isFunny = false;
					break;
				}
			}
			
			if (isFunny) {
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");
			}
		}
		s.close();
	}
}
