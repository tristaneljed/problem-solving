package search;

import java.util.Scanner;

public class ConnectedCellInAGrid {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ConnectedCellInAGrid object = new ConnectedCellInAGrid();
		int t = 1;
		while (t-- > 0) {
			int m = s.nextInt();
			int n = s.nextInt();
			int[][] array = new int[m][n];
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					array[i][j] = s.nextInt();
					if (array[i][j] !=0 && array[i][j] != 1) {
						s.close();
						throw new IllegalArgumentException("Array value has " + array[i][j]);
					}
				}
			}
			object.solve(m, n, array);
		}
		s.close();
	}

	private void solve(int m, int n, int[][] array) {
		Cell[][] matrix = new Cell[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				Cell cell = new Cell(array[i][j], i, j);
				matrix[i][j] = cell;
			}
		}
		
		int maxConnectedComponents = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (!matrix[i][j].visited) {
					int connectedComponents = findNumberOfConnectedComponents(matrix, i, j, m, n);
					if (maxConnectedComponents < connectedComponents) {
						maxConnectedComponents = connectedComponents;
					}
				}
			}
		}
		
		System.out.println(maxConnectedComponents);
	}
	
	private int findNumberOfConnectedComponents(Cell[][] matrix, int i, int j, int m, int n) {
		int count = 1;
		
		matrix[i][j].visited = true;
		
		//Top left
		if (withinBoundary(i-1, j-1, m, n) && !matrix[i-1][j-1].visited 
				&& matrix[i][j].value == matrix[i-1][j-1].value) {
			count += findNumberOfConnectedComponents(matrix, i-1, j-1, m, n);
		}
		
		//Just above
		if (withinBoundary(i-1, j, m, n) && !matrix[i-1][j].visited
				&& matrix[i][j].value == matrix[i-1][j].value) {
			count += findNumberOfConnectedComponents(matrix, i-1, j, m, n);
		}
		
		//Top right
		if (withinBoundary(i-1, j+1, m, n) && !matrix[i-1][j+1].visited
				&& matrix[i][j].value == matrix[i-1][j+1].value) {
			count += findNumberOfConnectedComponents(matrix, i-1, j+1, m, n);
		}
		
		//Left
		if (withinBoundary(i, j-1, m, n) && !matrix[i][j-1].visited
				&& matrix[i][j].value == matrix[i][j-1].value) {
			count += findNumberOfConnectedComponents(matrix, i, j-1, m, n);
		}
		
		//Right
		if (withinBoundary(i, j+1, m, n) && !matrix[i][j+1].visited
				&& matrix[i][j].value == matrix[i][j+1].value) {
			count += findNumberOfConnectedComponents(matrix, i, j+1, m, n);
		}
		
		//Bottom Left
		if (withinBoundary(i+1, j-1, m, n) && !matrix[i+1][j-1].visited
				&& matrix[i][j].value == matrix[i+1][j-1].value) {
			count += findNumberOfConnectedComponents(matrix, i+1, j-1, m, n);
		}
		
		//Just Below
		if (withinBoundary(i+1, j, m, n) && !matrix[i+1][j].visited
				&& matrix[i][j].value == matrix[i+1][j].value) {
			count += findNumberOfConnectedComponents(matrix, i+1, j, m, n);
		}
		
		//Below Right
		if (withinBoundary(i+1, j+1, m, n) && !matrix[i+1][j+1].visited
				&& matrix[i][j].value == matrix[i+1][j+1].value) {
			count += findNumberOfConnectedComponents(matrix, i+1, j+1, m, n);
		}

		return count;
	}

	private boolean withinBoundary(int i, int j, int m, int n) {
		return  (i >= 0) &&
				(i < m) &&
				(j >= 0) &&
				(j < n);
	}

	class Cell {
		int x;
		int y;
		int value;
		boolean visited = false;
		
		public Cell(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
			if (value == 0) {
				visited = true;
			}
		}
	}
	
}
