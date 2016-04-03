package chapter1;

import java.util.Scanner;

public class Problem7 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] matrix = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		
		zerofy(matrix);
		print(matrix);
		
		s.close();
	}
	
	private static void print(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void zerofy(int[][] matrix) {
		if(matrix == null) {
			return;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] isRowZero = new boolean[m];
		boolean[] isColumnZero = new boolean[n];
		
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (matrix[i][j] == 0) {
					isRowZero[i] = true;
					isColumnZero[j] = true;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			if(isRowZero[i]) {
				zerofyRow(matrix, i);
			}
		}
		
		for (int i=0; i<n; i++) {
			if(isColumnZero[i]) {
				zerofyColumn(matrix, i);
			}
		}
	}

	private static void zerofyColumn(int[][] matrix, int columnNumber) {
		int rows = matrix.length;
		for (int i=0; i<rows; i++) {
			matrix[i][columnNumber] = 0;
		}
	}

	private static void zerofyRow(int[][] matrix, int rowNumber) {
		int columns = matrix[0].length;
		for(int i=0; i<columns; i++) {
			matrix[rowNumber][i] = 0;
		}
	}
}
