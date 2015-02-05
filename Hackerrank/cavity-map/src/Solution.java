import java.util.Scanner;


public class Solution {

	private static byte cavityMap[][]; 
	private static byte size;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		size = s.nextByte();
		cavityMap = new byte[size][size];
		
		for(int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				String input = s.next();
			}
		}
		
		s.close();
	}

}
