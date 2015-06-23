import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Solution {
	
	private static int N;
	private static ArrayList<UnitTestStats> unitTests;
	
	static class UnitTestStats implements Comparable<UnitTestStats>{
		public int time;
		public float prob;
		public Float mult;
		public UnitTestStats(int time, float prob) {
			this.time = time;
			this.prob = prob;
			this.mult = (float) time / prob;
		}
		
		@Override
		public int compareTo(UnitTestStats o) {
			return Float.compare(this.mult, o.mult);
		}
	}

	public static void main(String[] args) {
		unitTests = new ArrayList<>();
		try{
			BufferedReader inpStream = new BufferedReader(new InputStreamReader(System.in));
			String input;
			
			//Input number of circles
			if((input = inpStream.readLine()) != null) {
				N = Integer.parseInt(input);
			} else {
				System.out.println("Input issue!!");
			}

			//Input coordinates
			for (int i=0; i<N; i++) {
				int t;
				float p;
				if((input = inpStream.readLine()) != null) {
					String[] coord = input.split(" ");
					t = Integer.parseInt(coord[0]);
					p = Float.parseFloat(coord[1]);
					UnitTestStats obj = new UnitTestStats(t, p);
					unitTests.add(obj);
				} else {
					System.out.println("Input issue!!");
				}
			}
			Collections.sort(unitTests, Collections.reverseOrder());
			} catch (IOException err) {
				err.printStackTrace();
			}
		float expectedTime = 0f;
		int timeSum = 0;
		float passProb = 1f;
		float failProb = 1f;
		
		//String str = "";
		for (int i=0; i<unitTests.size(); i++) {
			UnitTestStats unitTest = unitTests.get(i); 
			timeSum += unitTest.time;
			if (i != 0) {
				passProb *= unitTests.get(i-1).prob;
			}
			if (i != unitTests.size() -1) {
				failProb = 1 - unitTest.prob;
			} else {
				failProb = 1f;
			}
			
			expectedTime += (failProb * passProb * timeSum);
			//str += " ( " + passProb + " * " + failProb + " * ( " + timeSum + " )) +";
		}
		System.out.println(expectedTime);
		//System.out.println(expectedTime + "\n" + str);
		
	}

}
