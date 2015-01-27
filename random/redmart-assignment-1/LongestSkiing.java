import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestSkiing {

	private int m;
	private int n;
	private int [][] elevationMatrix;
	private int [][] longestRouteMatrix;
	private ArrayList<Path> longestPathsList;
	
	private class Path implements Comparable<Path>{
		private ArrayList<Integer> path;
		private int pathSize;
		private int totalDrop;
		
		Path() {
			this.path = new ArrayList<Integer>();
		}
		
		@Override
		public int compareTo(Path that) {
			if (this.pathSize != that.pathSize) {
				return this.pathSize - that.pathSize;
			} else {
				return this.totalDrop - that.totalDrop;
			}
		}
		
		public void addToPath(int node) {
			this.path.add(node);
			pathSize += 1;
			this.totalDrop = path.get(path.size()-1) - path.get(0);
		}
		
		public void printPath() {
			for (int i=path.size()-1; i>0; i--) {
				System.out.print(path.get(i) + " -> ");
			}
			System.out.print(path.get(0));
		}
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: java LongestSkiing <path-of-map-file>");
			System.exit(-1);
		}
		
		LongestSkiing obj = new LongestSkiing();
		obj.readData(args[0]);
		obj.calculateLongestPath();
	}

	public void calculateLongestPath() {
		int maxDistance = -1;
		Path tempLongestPath;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if(isNewNode(i,j)) {
					tempLongestPath = skii(i,j);
					longestRouteMatrix[i][j] = tempLongestPath.pathSize;
					if (longestRouteMatrix[i][j] > maxDistance) {
						longestPathsList = new ArrayList<Path>();
						longestPathsList.add(tempLongestPath);
						maxDistance = longestRouteMatrix[i][j];
					} else if (longestRouteMatrix[i][j] == maxDistance) {
						longestPathsList.add(tempLongestPath);
					}
				}
			}
		}
		
		//display();		
		Collections.sort(longestPathsList, Collections.reverseOrder());
		longestPathsList.get(0).printPath();
	}
	
	private Path skii(int i, int j) {
		ArrayList<Path> listOfPaths = new ArrayList<Path>();
		
		if ((i>0) && (elevationMatrix[i][j]>elevationMatrix[i-1][j]) ) {
			listOfPaths.add(skii(i-1, j));
		} else {
			listOfPaths.add(new Path());
		}
		
		if ((i<m-1) && (elevationMatrix[i][j]>elevationMatrix[i+1][j]) ) {
			listOfPaths.add(skii(i+1, j));
		} else {
			listOfPaths.add(new Path());
		}
		
		if ((j>0) && (elevationMatrix[i][j]>elevationMatrix[i][j-1]) ) {
			listOfPaths.add(skii(i, j-1));
		} else {
			listOfPaths.add(new Path());
		}
		
		if ((j<n-1) && (elevationMatrix[i][j]>elevationMatrix[i][j+1]) ) {
			listOfPaths.add(skii(i, j+1));
		} else {
			listOfPaths.add(new Path());
		}
		
		Collections.sort(listOfPaths, Collections.reverseOrder());
		listOfPaths.get(0).addToPath(elevationMatrix[i][j]);
		return listOfPaths.get(0);
	}

	private boolean isNewNode(int i, int j) {
		if (longestRouteMatrix[i][j] == -1) {
			return true;
		}
		return false;
	}

	/*
	private void display() {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(longestRoute[i][j] + "\t");
			}
			System.out.println();
		}
	}
	*/

	public void readData(String filePath) {
		Scanner s = null;
		try {
			s = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File not found lah !!");
			System.exit(-1);
		}
		
		m = s.nextInt();
		n = s.nextInt();
		
		elevationMatrix = new int[m][n];
		longestRouteMatrix = new int[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				elevationMatrix[i][j] = s.nextInt();
				longestRouteMatrix[i][j] = -1;
			}
		}
		s.close();
	}
}
