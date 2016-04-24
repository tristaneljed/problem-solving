package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CutTheTree {
	
	private Node[] nodes;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = 1;
		CutTheTree object = new CutTheTree();

		while (t-- > 0) {
			int n = s.nextInt();
			object.nodes = new Node[n+1];
			for (int i=1; i<=n; i++) {
				object.nodes[i] = object.new Node(i, s.nextInt());
			}
			for (int i=0; i<n-1; i++) {
				object.nodes[s.nextInt()].addEdge(object.nodes[s.nextInt()]);
			}
			object.solve(n);
		}
		s.close();
	}

	private void solve(int n) {
		int totalValue = nodes[1].getValueOfSubtree();
		for (int i=2; i<=n; i++) {
			if (nodes[i].getValueOfSubtree() > totalValue) {
				totalValue = nodes[i].getValueOfSubtree();
			}
		}
		
		int minimumDifference = totalValue;
		for (int i=1; i<=n; i++) {
			int difference = Math.abs((2*nodes[i].getValueOfSubtree()) - totalValue);
			if (minimumDifference > difference) {
				minimumDifference = difference;
			}
		}
		
		System.out.println(minimumDifference);
	}
	
	class Node {
		int id;
		int value;
		List<Node> neighbours = new ArrayList<>();
		int valueOfSubtree = 0;
		boolean isVisited = false;
		
		public Node(int id, int value) {
			this.id = id;
			this.value = value;
		}
		
		public int getValueOfSubtree() {
			if (valueOfSubtree == 0) {
				isVisited = true;
				valueOfSubtree = value;
				for (Node neighbour:neighbours) {
					if (!neighbour.isVisited) {
						valueOfSubtree += neighbour.getValueOfSubtree();
					}
				}
			}
			return valueOfSubtree;
		}
		
		public void addEdge(Node that) {
			this.neighbours.add(that);
			that.neighbours.add(this);
		}
		
		@Override
		public String toString() {
			return "[ id = " + id + ", value = " + value + ", valueOfSubtree = " + valueOfSubtree + " ]";
		}
	}
}
