import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		while (s.hasNext()) {
			str.append(s.next());
		}
		
		int len = str.length();
		int rows = (int)Math.pow(str.length(), 0.5);
		int cols = ((rows * rows) >= len ) ? rows : rows + 1;  
		
		StringBuilder output = new StringBuilder();
		int i = 0;
		while(i < cols) {
			int j = 0;
			int index = i + (j * cols);
			while (index < len) {
				output.append(str.charAt(index));
				j++;
				index = i + (j * cols);
			}
			output.append(" ");
			i++;
		}
		
		System.out.println(output);
		s.close();
	}

}