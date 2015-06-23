import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;


public class Solution {
	private static int N;
	private static int K;
	private static int[] dataArray;
	private static int[] metaData;
	
	public static void main(String[] args) {
		try{
			BufferedReader inpStream = new BufferedReader(new InputStreamReader(System.in));
			String input;
			
			//Input N and K
			if((input = inpStream.readLine()) != null) {
				String[] inp = input.split(" ");
				N = Integer.parseInt(inp[0]);
				K = Integer.parseInt(inp[1]);
			} else {
				System.out.println("Input issue!!");
			}

			//Input N integers
			String[] data = null;
			if((input = inpStream.readLine()) != null) {
				data = input.split(" ");
			} else {
				System.out.println("Input issue!!");
			}
			dataArray = new int[data.length];
			for (int i=0; i<N; i++) {
				dataArray[i] = Integer.parseInt(data[i]);
			}
			} catch (IOException err) {
				err.printStackTrace();
			}
		check();
	}

	private static void check() {
		for (int i=0; i<dataArray.length; i++) {
			if (i == 0) {
				
			}
		}
	}

}
