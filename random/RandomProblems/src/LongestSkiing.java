import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSkiing {

	private int m;
	private int n;
	private Node [][] elevationMatrix;
	
	private class Node {
		int value;
		List<Node> longestPaths = new ArrayList<>();
		int longestPathLength = -1;
		int longestPathDepth = -1;
		boolean visited = false;
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: java LongestSkiing <path-of-map-file>");
			System.exit(-1);
		}
		long startTime = System.currentTimeMillis();
		LongestSkiing obj = new LongestSkiing();
		obj.readData(args[0]);
		long readTime = System.currentTimeMillis();
		obj.calculateLongestPath();
		long endTime = System.currentTimeMillis();
		System.out.println("Data Read Time = " + (readTime - startTime) + " milliseconds");
		System.out.println("Computation Time = " + (endTime - readTime) + " milliseconds");
		System.out.println("Total time taken = " + (endTime - startTime) + " milliseconds");
	}

	public void calculateLongestPath() {
		int maxPathLength = -1;
		int maxDepth = -1;
		int maxI = -1, maxJ = -1;
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				skii(i,j);
				int length = elevationMatrix[i][j].longestPathLength;
				int depth = elevationMatrix[i][j].longestPathDepth;
				if (maxPathLength < length) {
					maxPathLength = length;
					maxDepth = depth;
					maxI = i;
					maxJ = j;
				} else if (maxPathLength == length) {
					if (maxDepth < depth) {
						maxDepth = depth;
						maxI = i;
						maxJ = j;
					}
				}
			}
		}
		System.out.println("Max Length = " + maxPathLength + " | Max Depth = " + maxDepth);

		Node node = elevationMatrix[maxI][maxJ];
		display(node);
	}
	
	private void display(Node node) {
		if (node.longestPaths == null) {
			System.out.println(node.value + " (" + node.longestPathLength 
					+ ", "+ node.longestPathDepth + " )");
			return;
		}
		
		System.out.print(node.value + " (" + node.longestPathLength 
				+ ", "+ node.longestPathDepth + " ) => ");
		
		for (Node adj:node.longestPaths) {
			display(adj);
		}
	}
	
	private void skii(int i, int j) {
		if (elevationMatrix[i][j].visited) {
			return;
		}
		
		List<Node> paths = new ArrayList<>();
		int maxDist = -1;
		elevationMatrix[i][j].visited = true;
		
		if ((i>0) && (elevationMatrix[i][j].value > elevationMatrix[i-1][j].value) ) {
			skii(i-1, j);
			paths.add(elevationMatrix[i-1][j]);
			if (elevationMatrix[i-1][j].longestPathLength > maxDist) {
				maxDist = elevationMatrix[i-1][j].longestPathLength;
			}
		}
		
		if ((i<m-1) && (elevationMatrix[i][j].value > elevationMatrix[i+1][j].value) ) {
			skii(i+1, j);
			paths.add(elevationMatrix[i+1][j]);
			if (elevationMatrix[i+1][j].longestPathLength > maxDist) {
				maxDist = elevationMatrix[i+1][j].longestPathLength;
			}
		}
		
		if ((j>0) && (elevationMatrix[i][j].value >elevationMatrix[i][j-1].value) ) {
			skii(i, j-1);
			paths.add(elevationMatrix[i][j-1]);
			if (elevationMatrix[i][j-1].longestPathLength > maxDist) {
				maxDist = elevationMatrix[i][j-1].longestPathLength;
			}
		}
		
		if ((j<n-1) && (elevationMatrix[i][j].value > elevationMatrix[i][j+1].value) ) {
			skii(i, j+1);
			paths.add(elevationMatrix[i][j+1]);
			if (elevationMatrix[i][j+1].longestPathLength > maxDist) {
				maxDist = elevationMatrix[i][j+1].longestPathLength;
			}
		}
		
		if (maxDist == -1) {
			elevationMatrix[i][j].longestPathLength = 1;
			elevationMatrix[i][j].longestPathDepth = 0;
			elevationMatrix[i][j].longestPaths = null;
		} else {
			for (Node path : paths) {
				if (path.longestPathLength == maxDist) {
					elevationMatrix[i][j].longestPathLength = path.longestPathLength + 1;
					elevationMatrix[i][j].longestPaths.add(path);
				}
			}
			Node deepestPath = elevationMatrix[i][j].longestPaths.get(0);

			for (Node path : elevationMatrix[i][j].longestPaths) {
				int deepestLength = elevationMatrix[i][j].value - deepestPath.value + deepestPath.longestPathDepth;
				int pathLength = elevationMatrix[i][j].value - path.value + path.longestPathDepth;
				if (pathLength > deepestLength) {
					deepestPath = path;
				}
			}
			
			elevationMatrix[i][j].longestPathDepth = elevationMatrix[i][j].value - deepestPath.value + deepestPath.longestPathDepth;
		}
	}

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
		
		elevationMatrix = new Node[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				elevationMatrix[i][j] = new Node();
				elevationMatrix[i][j].value = s.nextInt();
			}
		}
		s.close();
	}
}