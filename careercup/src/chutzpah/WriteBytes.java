package chutzpah;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WriteBytes {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("/Users/siddharthgoel/code/problem-solving/careercup/writing-bytes.txt"));
		while(s.hasNextByte()) {
			System.out.println("Hello");
			System.out.println(s.nextByte());
		}
		s.close();
	}
}
