package search;
import java.util.Scanner;


public class CountLuck {
	
	private static boolean visited[][];
	private static char forest[][];
	private static int row;
	private static int col;
	private static int startX = -1;
	private static int startY = -1;
	private static int endX = -1;
	private static int endY = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			row = s.nextInt();
			col = s.nextInt();
			forest = new char[row][col];
			visited = new boolean[row][col];
			
			boolean foundHermione = false;
			boolean foundExit = false;
			for (int i=0; i<row; i++) {
				String rowData = s.next();
				System.out.println(rowData);
				forest[i] = rowData.toCharArray();
				if (!foundHermione) {
					int index = rowData.indexOf('M');
					System.out.println("Index of M : " + index);
					if (index != -1) {
						startX = i;
						startY = index;
						foundHermione = true;
					}
				}
				if (!foundExit) {
					int index = rowData.indexOf('*');
					System.out.println("Index of * : " + index);
					if (index != -1) {
						endX = i;
						endY = index;
						foundExit = true;
					}
				}
			}
			
			int k = s.nextInt();
			System.out.println(solve(k));
		}
		s.close();
	}

	private static String solve(int k) {
		int wandWaves = roamForest(startX, startY);
		System.out.println("Total wand waves : " + wandWaves);
		if (wandWaves == k) {
			return "Impressed";
		} else {
			return "Oops!"; 
		}
	}

	private static int roamForest(int x, int y) {
		System.out.println("Trying to move at :" + x + ", " + y);
		if ( !isMovableCoordinate(x, y)) {
			return -1;
		}
		
		visited[x][y] = true;
		
		if (x == endX && y == endY) {
			return 0;
		}
		
		int leftCount = roamForest(x, y-1);
		int rightCount = roamForest(x, y+1);
		int upCount = roamForest(x-1, y);
		int downCount = roamForest(x+1, y);
		
		int count = Math.max(Math.max(leftCount, rightCount), Math.max(upCount, downCount));
		
		if (wandWaveNeeded(x, y)) {
			return count + 1;
		} else {
			return count;
		}
		
	}
	
	private static boolean isMovableCoordinate(int x, int y) {
		return (isValidCoordinate(x, y) && (forest[x][y] == '.' || forest[x][y] == '*') && !visited[x][y]);
	}
	
	private static boolean isValidCoordinate(int x, int y) {
		return (x > -1 && x < row && y > -1 && y < col);
	}

	private static boolean wandWaveNeeded(int x, int y) {
		int count = 0;
		
		System.out.println("Checking wand wave at : " + x + ", " + y);
		
		/*if path on left*/
		if (isValidCoordinate(x, y-1) && forest[x][y-1] == '.') {
			count++;
		}
		
		/*if path on right*/
		if (isValidCoordinate(x, y+1) && forest[x][y+1] == '.') {
			count++;
		}
		
		/*if path on top*/
		if (isValidCoordinate(x-1, y) && forest[x-1][y] == '.') {
			count++;
		}
		
		/*if path below*/
		if (isValidCoordinate(x-1, y) && forest[x-1][y] == '.') {
			count++;
		}
		
		return (count>1);
	}

}
