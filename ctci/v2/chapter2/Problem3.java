package chapter2;

import java.util.Random;

public class Problem3 {
	
	class Node {
		int value;
		Node next = null;
	}

	private static final int SIZE = 100;
	
	private Node head = null;

	public void add(int number) {
		Node node = new Node();
		node.value = number;
		node.next = head;
		head = node;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void displayList() {
		Node runner = head;
		System.out.print("List : ");
		while (runner != null) {
			String seperator = runner.next != null ? " -> " : "";
			System.out.print(runner.value + seperator);
			runner = runner.next;
		}
		System.out.println();
	}

	public void deleteElement(Node node) throws Exception {
		if (node.next == null) {
			throw new Exception("Cannot delete last element of the list like this");
		}
		
		node.value = node.next.value;
		node.next = node.next.next;
	}
	
	public Node getRandomNode() {
		Random random = new Random();
		int randomNodeIndex = random.nextInt(SIZE);
		System.out.println("Index of random node will is " + randomNodeIndex);
		Node runner = head;
		for (int i=0; i<randomNodeIndex - 1 && runner != null; i++ , runner = runner.next ) {}
		return runner;
	}
	
	public static void main(String[] args) throws Exception {
		Problem3 object = new Problem3();
		
		for (int i=0; i<SIZE; i++) {
			object.add(i);
		}
		object.displayList();
		object.deleteElement(object.getRandomNode());
		object.displayList();
	}
}
