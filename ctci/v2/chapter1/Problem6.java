package chapter1;

import java.util.Scanner;

public class Problem6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] matrix = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		rotate(matrix);
		print(matrix);
		
		inplaceRotate(matrix);
		print(matrix);
		
		s.close();
	}
	
	private static void print(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void rotate(int matrix[][]) {
		int n = matrix.length;
		int[][] tempMatrix = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				tempMatrix[j][n-i-1] = matrix[i][j];
			}
		}
		
		//Copying or could simply return also.
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = tempMatrix[i][j];
			}
		}
	}
	
	private static void inplaceRotate(int matrix[][]) {
		if (matrix == null || matrix.length <= 1) {
			return;
		}
		int n = matrix.length;
		for (int i=0; i<n/2; i++) {
			for (int j=i; j<n-1-i; j++) {
				move(i, j, matrix);
			}
		}
	}

	private static void move(int i, int j, int[][] matrix) {
		int n = matrix.length;
		int value1 = matrix[j][n-1-i];
		matrix[j][n-1-i] = matrix[i][j];
		int value2 = matrix[n-1-i][n-1-j];
		matrix[n-1-i][n-1-j] = value1;
		value1 = matrix[n-1-j][i];
		matrix[n-1-j][i] = value2;
		matrix[i][j] = value1;
	}
}
