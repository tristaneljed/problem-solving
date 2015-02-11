import java.util.Scanner;

/*
 *  https://www.hackerrank.com/challenges/service-lane
 */

public class Solution {
	
	private static class ServiceLane {
		short laneWidth1[];
		short laneWidth2[];
		short laneWidth3[];
		
		public ServiceLane(int size) {
			laneWidth1 = new short[size];
			laneWidth2 = new short[size];
			laneWidth3 = new short[size];
		}
		
		public void preProcess (short val, int index) {
			int prevIndex = index -1;
			if (val == 1) {
				laneWidth1[index] = (short)(laneWidth1[prevIndex] + 1);
				laneWidth2[index] = laneWidth2[prevIndex];
				laneWidth3[index] = laneWidth3[prevIndex];
			} else if (val == 2) {
				laneWidth1[index] = laneWidth1[prevIndex];
				laneWidth2[index] = (short)(laneWidth2[prevIndex] + 1);
				laneWidth3[index] = laneWidth3[prevIndex];
			} else {
				laneWidth1[index] = laneWidth1[prevIndex];
				laneWidth2[index] = laneWidth2[prevIndex];
				laneWidth3[index] = (short)(laneWidth3[prevIndex] + 1);
			}
		}
		
		public short process (int leftIndex, int rightIndex) {
			if (laneWidth1[leftIndex-1] != laneWidth1[rightIndex]) {
				return 1;
			}
			
			if (laneWidth2[leftIndex-1] != laneWidth2[rightIndex]) {
				return 2;
			}
			
			return 3;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ServiceLane obj = new ServiceLane(n+1);
		int numOfTestCases = s.nextInt();
		for (int i=0; i<n; i++) {
			short temp = s.nextShort();
			obj.preProcess(temp, i+1);
		}
		while (numOfTestCases-- > 0) {
			System.out.println(obj.process(s.nextInt()+1, s.nextInt()+1));
		}
		s.close();
	}
}