import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Travel {
	
	private static Node[] graph = null;
	private static int n;
	private static int m;
	
	public static void main(String[] args) {
		Travel travel = new Travel();
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		graph = new Node[n+1];
		for (int i=0; i<n-1; i++) {
			int node1 = s.nextInt();
			int node2 = s.nextInt();
			travel.connect(node1, node2);
		}
		
		for (int i=0; i<m; i++) {
			int type = s.nextInt();
			int node = s.nextInt();
			if (type == 1) {
				graph[node].makeFestive();
			} else {
				System.out.println(solve(node, -1));
			}
		}
		s.close();
	}

	private static int solve(int node, int from) {
		System.out.println("Calling for "+graph[node].number);
		int min = Integer.MAX_VALUE-1;
		if (graph[node].isFestive) {
			return 0;
		}
		for (Node neighbour:graph[node].neighbours) {
			if (neighbour.number == from) {
				continue;
			}
			int dist = solve(neighbour.number, node);
			if (dist < min) {
				min = dist;
			}
		}
		return min+1;
	}

	private void connect(int node1, int node2) {
		if (graph[node1] == null) {
			graph[node1] = new Node(node1);
		}
		if (graph[node2] == null) {
			graph[node2] = new Node(node2);
		}
		graph[node1].addNeighbour(graph[node2]);
		graph[node2].addNeighbour(graph[node1]);
	}

	class Node {
		int number;
		boolean isFestive = false;
		Set<Node> neighbours = new HashSet<>();
		
		public Node(int number) {
			this.number = number;
			if (number == 2) {
				isFestive = true;
			}
		}
		public void addNeighbour(Node node) {
			neighbours.add(node);
		}
		public void makeFestive() {
			isFestive = true;
		}
	}
}
