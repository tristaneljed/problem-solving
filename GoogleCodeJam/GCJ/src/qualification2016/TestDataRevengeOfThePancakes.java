package qualification2016;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class TestDataRevengeOfThePancakes {
	private static Random random = new Random();

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter("resource/testRevengeOfThePancakes5.in");
		printWriter.println(100);
				
		for(int i=0; i<100; i++) {
			printWriter.println(generateRandomString());
		}
		
		printWriter.close();
	}

	private static String generateRandomString() {
		int size = random.nextInt(100);
		size++;
		char[] charArray = new char[size];
		
		while(size-- > 0) {
			charArray[size] = (random.nextInt(2) == 0) ? '+' : '-';
		}
		
		return String.valueOf(charArray);
	}
}
