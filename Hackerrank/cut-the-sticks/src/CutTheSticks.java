import java.util.Arrays;
import java.util.Scanner;


public class CutTheSticks {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int len = s.nextInt();
		int [] array = new int[len];
		for (int i=0; i<len; i++) {
			array[i] = s.nextInt();
		}
		
		Arrays.sort(array);
		System.out.println(len);
		
		int prev = array[0];
		for (int i=1; i<len; i++) {
			if (array[i] == prev) {
				continue;
			} else {
				prev = array[i];
				System.out.println(len - i);
			}
		}
		
		s.close();
	}

}
