package chutzpah;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class GenerateRandomNumbers {
	public static void main(String[] args) {
		try {
			PrintWriter printWriter = new PrintWriter("numbers.txt", "UTF-8");
			int numberOfLongs = 1<<27;
			int pass = 0;
			Random random = new Random();
			long startTime = System.currentTimeMillis();
			for (int i=0; i<numberOfLongs; i++) {
				if(i % 1000000 == 0) {
					pass++;
					System.out.println("Pass = " + pass);
				}
				printWriter.println(random.nextLong());
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken : " + ((endTime - startTime)/1000) + " seconds");
			
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
