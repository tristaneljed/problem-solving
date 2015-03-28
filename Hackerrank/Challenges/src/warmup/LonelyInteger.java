package warmup;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LonelyInteger {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int len = s.nextInt();
		int [] array = new int[len];
		for (int i=0; i<len; i++) {
			array[i] = s.nextInt();
			if (map.containsKey(array[i])) {
				int count = map.get(array[i]);
				map.put(array[i], count+1);
			} else {
				map.put(array[i], 1);
			}
		}
		
		for (int i=0; i<len; i++) {
			if (map.get(array[i]) % 2 == 1) {
				System.out.println(array[i]);
				break;
			}
		}
		
		s.close();
	}

}
