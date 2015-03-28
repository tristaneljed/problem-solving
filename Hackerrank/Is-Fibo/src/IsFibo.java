import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsFibo {

	static Map<String, Boolean> fiboNums;
	
	static void preCalculation() {
		fiboNums = new HashMap<>();
		long f1=0;
		long f2=1;
		long fsum=1;
		
		
		fiboNums.put(String.valueOf(f1), true);
		fiboNums.put(String.valueOf(f2), true);
		
		for (int i=0; i<80; i++) {
			fsum = f1 + f2;
			fiboNums.put(String.valueOf(fsum), true);
			f1 = f2;
			f2 = fsum;
		}
	}
	
	static String isFibo(String input) {
		if (fiboNums.get(input) != null) {
			return "IsFibo";
		} else {
			return "IsNotFibo";
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		preCalculation();
		while(numOfTestCases > 0) {
			System.out.println(isFibo(String.valueOf(s.nextLong())));
			numOfTestCases--;
		}
		s.close();
	}

}
