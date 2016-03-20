public class Test {
	public static void main(String...args) {
		String str1 = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";
		String str2 = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm";

		SGStringBuffer comp1 = new SGStringBuffer("");
		String comp2 = "";

		long startTime1 = System.currentTimeMillis();

		for(int i=0; i<5000; i++) {
			comp1.append(str1);
			comp1.append(str2);
		}
		String res1 = comp1.toString();

		long endTime1 = System.currentTimeMillis();

		long startTime2 = System.currentTimeMillis();
		
		for(int i=0; i<5000; i++) {
			comp2 += str1;
		        comp2 += str2;
		}
		String res2 = comp2;

		long endTime2 = System.currentTimeMillis();

		if (res2.equals(res1))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		System.out.println("SGStringBuffer = " + (endTime1 - startTime1) + " ms, Java concat = " + (endTime2 - startTime2) + " ms");
	}
}
