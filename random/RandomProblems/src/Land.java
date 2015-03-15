import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TODO: Add problem statement

public class Land {
	
	private static int n;
	private static int m;
	private static int [][]land;
	private static int [][]rowSum;
	private static int [][]colSum;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("resource/input/land8.in"));
		n = s.nextInt();
		m = s.nextInt();
		land = new int[n+1][n+1];
		for (int i=0; i<m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			land[x][y] = 1;
		}
		
		preProcess();
		System.out.println(largestSquare());
		s.close();
	}

	private static int largestSquare() {
		if (m >= (n*n)) {
			return 0;
		}
		
		for (int i=n; i>0; i--) {
			if (squareExists(i)) {
				return i;
			}
		}
		
		return 0;
	}

	private static boolean squareExists(int squareSize) {
		for (int row=1; row<=(n+1-squareSize); row++) {
			for (int col=1; col<=(n+1-squareSize); col++) {
				if ((colSum[row][col] != colSum[row+squareSize-1][col]) || (colSum[row][col+squareSize-1] != colSum[row+squareSize-1][col+squareSize-1])) {
					continue;
				}
				int i;
				for (i=0; i<squareSize; i++) {
					if ((land[row+i][col] == 1) || (rowSum[row+i][col] != rowSum[row+i][col+squareSize-1])) {
						//System.out.println(land[row+i][col] + " " + rowSum[row+i][col] + " " + rowSum[row+i][col+squareSize-1]);
						break;
					}
				}
				if (i == squareSize) {
					return true;
				}
			}
		}
		return false;
	}

	private static void preProcess() {
		if (m >= (n*n)) {
			return;
		}
		rowSum = new int[n+1][n+1];
		colSum = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			int sum = 0;
			for (int j=1; j<=n; j++) {
				sum += land[i][j];
				rowSum[i][j] = sum;
			}
		}
		
		for (int i=1; i<=n; i++) {
			int sum = 0;
			for (int j=1; j<=n; j++) {
				sum += land[j][i];
				colSum[j][i] = sum;
			}
		}
	}
}
