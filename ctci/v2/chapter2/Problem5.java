package chapter2;

import java.util.Random;

public class Problem5 {
	
	class Node {
		int value;
		Node next = null;
	}
	
	private Node head1 = null;
	private Node head2 = null;
	private Random random = new Random();
	
	public Node getRandomNode(int size) {
		Node head = null;
		for (int i=0; i<size; i++) {
			Node node = new Node();
			node.value = random.nextInt(10);
			node.next = head;
			head = node;
		}
		return head;
	}

	public void add(Node head, int number) {
		Node node = new Node();
		node.value = number;
		node.next = head;
		head = node;
	}
	
	public void displayList(Node head) {
		Node runner = head;
		System.out.print("List : ");
		while (runner != null) {
			String seperator = runner.next != null ? " -> " : "";
			System.out.print(runner.value + seperator);
			runner = runner.next;
		}
		System.out.println();
	}
	
	public Node addition(Node node1, Node node2) {
		Node runner = null;
		Node resultHead = null;
		int carry = 0;
		while (node1 != null && node2 != null) {
			Node node = new Node();
			int sum = carry + node1.value + node2.value;
			node.value = sum % 10;
			carry = sum/10;
			node1 = node1.next;
			node2 = node2.next;
			if (runner == null && resultHead == null) {
				runner = node;
				resultHead = node;
			} else {
				runner.next = node;
				runner = node;
			}
		}
		
		while(node1 != null) {
			Node node = new Node();
			int sum = carry + node1.value;
			node1 = node1.next;
			node.value = sum % 10;
			carry = sum/10;
			runner.next = node;
			runner = node;
		}
		
		while(node2 != null) {
			Node node = new Node();
			int sum = carry + node2.value;
			node2 = node2.next;
			node.value = sum % 10;
			carry = sum/10;
			runner.next = node;
			runner = node;
		}
		
		if (carry != 0) {
			runner.next = new Node();
			runner = runner.next;
			runner.value = carry;
		}

		return resultHead;
	}
	
	public static void main(String[] args) {
		Problem5 object = new Problem5();
		object.head1 = object.getRandomNode(4);
		object.head2 = object.getRandomNode(4);
		object.displayList(object.head1);
		object.displayList(object.head2);
		Node sum = object.addition(object.head1, object.head2);
		object.displayList(sum);
	}
}
