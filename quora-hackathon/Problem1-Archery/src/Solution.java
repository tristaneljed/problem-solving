import java.io.*;
import java.util.Arrays;

public class Solution {
	private static int N;
	private static int M;
	private static double[] R;
	private static double x1;
	private static double y1;
	private static double x2;
	private static double y2;
	private static int count = 0;
	
	public static void main(String[] args) {
		try{
			BufferedReader inpStream = new BufferedReader(new InputStreamReader(System.in));
			String input;
			
			//Input number of circles
			if((input = inpStream.readLine()) != null) {
				N = Integer.parseInt(input);
			} else {
				System.out.println("Input issue!!");
			}
			
			//Input radii
			R = new double[N];
			if((input = inpStream.readLine()) != null) {
				String[] radii = input.split(" ");
				for (int i=0; i<N; i++) 
					R[i] = Integer.parseInt(radii[i]);
				Arrays.sort(R);
			} else {
				System.out.println("Input issue!!");
			}
			
			//Input number of arrows
			if((input = inpStream.readLine()) != null) {
				M = Integer.parseInt(input);
			} else {
				System.out.println("Input issue!!");
			}
			
			//Input coordinates
			for (int i=0; i<M; i++) {
				if((input = inpStream.readLine()) != null) {
					String[] coord = input.split(" ");
					x1 = Double.parseDouble(coord[0])/1000.0;
					y1 = Double.parseDouble(coord[1])/1000.0;
					x2 = Double.parseDouble(coord[2])/1000.0;
					y2 = Double.parseDouble(coord[3])/1000.0;
					check();
				} else {
					System.out.println("Input issue!!");
				}
			}			
			} catch (IOException err) {
				err.printStackTrace();
			}
			System.out.println(count);
		}
	
	private static void check() {
		double val1 = Math.sqrt((x1 * x1) + (y1 * y1)) * 1000.0; 
		double val2 = Math.sqrt((x2 * x2) + (y2 * y2)) * 1000.0;
		
		count += startRadiusIndex(Math.max(val1, val2)) - startRadiusIndex(Math.min(val1, val2));
		
		/*
		for (int i=startRadiusIndex(Math.min(val1, val2)); i<N; i++) {
			if (R[i] < Math.max(val1, val2) && R[i] > Math.min(val1, val2))
				count++;
			if (R[i] > Math.max(val1, val2))
				break;
		}
		*/
	}

	private static int startRadiusIndex(double val) {
		int low=0;
		int high=N-1;
		
		if (R[low] > val)
			return low-1;
		
		if(R[high] < val)
			return high;
		
		while (low < high - 1) {
			int mid = low+ (high - low)/2;
			if (R[mid] < val)
				low = mid;
			else 
				high = mid - 1;
		}
 		if (R[high] < val)
 			return high;
 		else
 			return low;
	}
}
    