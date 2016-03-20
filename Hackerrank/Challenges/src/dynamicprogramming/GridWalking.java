//package dynamicprogramming;
//
//import java.math.BigInteger;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class GridWalking {
//	
//	private static int n;
//	private static int m;
//	private static int[] d;
//	private static Map<String, BigInteger> pathMap = null;
//	
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int numOfTestCases = s.nextInt();
//		while (numOfTestCases-- > 0) {
//			n = s.nextInt();
//			m = s.nextInt();
//			d = new int[n];	
//			int[] initialPosition = new int[n];
//			
//			for (int i=0; i<n; i++) {
//				initialPosition[i] = s.nextInt();
//			}
//			
//			for (int i=0; i<n; i++) {
//				d[i] = s.nextInt();
//			}
//			
//			pathMap = new HashMap<String, BigInteger>(); 
//			BigInteger result = numberOfPaths(initialPosition, m);
//			System.out.println(result.mod(new BigInteger("1000000007")));
//		}
//		s.close();
//	}
//
//	private static BigInteger numberOfPaths(int[] initialPosition, int steps) {
//		if (steps == 0) {
//			return new BigInteger("0");
//		}
//		
//		if (pathMap.containsKey(getKey(initialPosition, steps))) {
//			return pathMap.get(getKey(initialPosition, steps));
//		}
//		
//		if (steps == 1) {
//			BigInteger numOfPaths = new BigInteger("0");
//			for (int i=0; i<n; i++) {
//				if (isInsideGrid(initialPosition[i] + 1 , i)) {
//					numOfPaths = numOfPaths.add(new BigInteger("1"));
//				}
//				if (isInsideGrid(initialPosition[i] - 1 , i)) {
//					numOfPaths = numOfPaths.add(new BigInteger("1"));
//				}
//			}
//			pathMap.put(getKey(initialPosition, steps), numOfPaths);
//			return numOfPaths;
//		}
//		
//		BigInteger result = new BigInteger("0");
//		int[] currentPosition = new int[n];
//		for (int index=0; index<n; index++) {
//			currentPosition[index] = initialPosition[index];
//		}
//		for (int i=0; i<n; i++) {
//			currentPosition[i] = initialPosition[i] + 1;
//			if (isInsideGrid(currentPosition[i], i)) {
//				result = result.add(numberOfPaths(currentPosition, steps - 1));
//			}
//			currentPosition[i] = initialPosition[i] - 1;
//			if (isInsideGrid(currentPosition[i], i)) {
//				result = result.add(numberOfPaths(currentPosition, steps - 1));
//			}
//			currentPosition[i] = initialPosition[i];
//		}
//		pathMap.put(getKey(initialPosition, steps), result);
//		return result;
//	}
//
//	private static boolean isInsideGrid(int value, int dimension) {
//		return (value <= d[dimension]) && (value > 0);
//	}
//	
//	class Position {
//		private String key = "";
//		private int[] positions;
//		private int steps;
//		
//		public String getKey() {
//			return key;
//		}
//		private void setKey(String key) {
//			this.key = key;
//		}
//		public int[] getPosition() {
//			return positions;
//		}
//		public void setPositions(int[] positions) {
//			this.positions = positions;
//			StringBuilder sb = new StringBuilder();
//			for (int index:positions) {
//				sb.append(String.valueOf(index)).append(" ");
//			}
//			setKey(sb.toString() + String.valueOf(steps));
//		}
//		public int getSteps() {
//			return steps;
//		}
//		public void setSteps(int steps) {
//			this.steps = steps;
//			setKey(key + String.valueOf(steps));
//		}
//	}
//}
