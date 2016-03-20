package godaddyhackathon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HexagonalWar {
	
	private static int N;
	private static int M;
	private static final int PERSIANS = 1;
	private static final int ROMANS = 2;
	private static Node[][] village = null;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		
		village = new Node[N+1][N+1];
		
		for (int move=0; move<M; move++) {
			int r = s.nextInt();
			int c = s.nextInt();
			village[r][c] = new Node(r,c);
			village[r][c].wall = (move % 2 == 0) ? ROMANS : PERSIANS;
			updateNeighbours(r,c);
		}
		s.close();
		
		if (M < N) {
			System.out.print("NEITHER");
			System.exit(0);
		}
		
		//Check safety of Persians
		for (int col=1; col<=N; col++) {
			if (village[1][col] == null) {
				continue;
			}
			if (isSafe(1,col)) {
				System.out.println("PERSIANS");
				System.exit(0);
			}
		}
		
		//Check safety of Romans
		for (int row=1; row<=N; row++) {
			if(village[row][1] == null) {
				continue;
			}
			if (isSafe(row, 1)) {
				System.out.print("ROMANS");
				System.exit(0);
			}
		}
		
		System.out.print("NEITHER");
	}
	
	private static boolean isSafe(int row, int col) {
		Node node = village[row][col];
		
		if (node.wall == PERSIANS && row == N) {
			return true;
		} else if (node.wall == ROMANS && col == N) {
			return true;
		}
		
		for (Node neighbour: node.neighbours) {
			if (isSafe(neighbour.row, neighbour.col)) {
				return true;
			}
		}
		
		return false;
	}

	private static void updateNeighbours(int r, int c) {
		Node node = village[r][c];
		Node neighbour = null;
		
		neighbour = node.getFirstNeighbour();
		addNeighbours(node, neighbour);
		neighbour = node.getSecondNeighbour();
		addNeighbours(node, neighbour);
		neighbour = node.getThirdNeighbour();
		addNeighbours(node, neighbour);
		neighbour = node.getFourthNeighbour();
		addNeighbours(node, neighbour);
		neighbour = node.getFifthNeighbour();
		addNeighbours(node, neighbour);
		neighbour = node.getSixthNeighbour();
		addNeighbours(node, neighbour);
	}

	private static void addNeighbours(Node node, Node neighbour) {
		if ((neighbour != null) && (node.wall == neighbour.wall)) {
			if (node.row == neighbour.row) {
				node.neighbours.add(neighbour);
				neighbour.neighbours.add(node);
			} else if (node.row < neighbour.row) {
				node.neighbours.add(neighbour);
			} else {
				neighbour.neighbours.add(node);
			}

		}
	}

	static class Node {
		Set<Node> neighbours = new HashSet<>();
		boolean visited = false;
		int wall;
		int row, col;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public Node getFirstNeighbour() {
			if(row == 1) {
				return null;
			} else {
				return village[row-1][col];
			}
		}
		
		public Node getSecondNeighbour() {
			if (col == N || row == 1) {
				return null;
			} else {
				return village[row-1][col+1];
			}
		}
		
		public Node getThirdNeighbour() {
			if (col == N) {
				return null;
			} else {
				return village[row][col+1];
			}
		}
		
		public Node getFourthNeighbour() {
			if (row == N) {
				return null;
			} else {
				return village[row+1][col];
			}
		}
		
		public Node getFifthNeighbour() {
			if (row == N || col == 1) {
				return null;
			} else {
				return village[row+1][col-1];
			}
		}
		
		public Node getSixthNeighbour() {
			if (col == 1) {
				return null;
			} else {
				return village[row][col-1];
			}
		}
	}
}
