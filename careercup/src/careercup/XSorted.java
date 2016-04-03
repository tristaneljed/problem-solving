package careercup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * https://careercup.com/question?id=5648257217724416
 * 
 * A list L is too big to fit in memory. L is partially sorted. 
 * Partially sorted in a specific way: x-sorted L[i] < L[i+x]. 
 * Any element is at most x indices out of position. 
 * You can look at the condition in a different way too. 
 * L[i] >= L[i-x] 
 * Sort the list L.
 * 
 */

public class XSorted {
	
	public static void main(String[] args) throws Exception {
		Scanner s;
		try {
			s = new Scanner(new File("test.txt"));
			int x = s.nextInt();
			int[] input = new int[x];
			
			int i=0;
			for (i=0; i<x && s.hasNext(); i++) {
				input[i] = s.nextInt();
			}
			
			if (i<x) {
				s.close();
				throw new Exception("Input is expected to be huge");
			}
			
			PrintWriter output = null;
			try {
				output = new PrintWriter("output.txt", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				System.err.println(e.getMessage());
			}
			
			while(s.hasNext()) {
				heapify(input);
				output.println(input[0]);
				input[0] = s.nextInt();
			}
			
			Arrays.sort(input);
			for (i=0; i<x; i++) {
				output.println(input[i]);
			}
		
			output.close();
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void heapify(int[] input) {
		for(int i=0; i<input.length/2; i++) {
		}
	}
}
