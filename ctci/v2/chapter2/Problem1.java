package chapter2;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
	
	class Node {
		int value;
		Node next = null;
	}
	
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
	
	/*
	 * Assumption here is that use of an extra buffer is allowed
	 */
	public void deleteDuplicatesWithBuffer() {
		if (isEmpty()) {
			return;
		}
		
		Set<Integer> uniqueElements = new HashSet<>();
		Node prev = head;
		uniqueElements.add(prev.value);
		Node runner = prev.next;
		while (runner != null) {
			if (uniqueElements.contains(runner.value)) {
				prev.next = runner.next;
			} else {
				prev = runner;
				uniqueElements.add(prev.value);
			}
			runner = runner.next;
		}
	}
	
	/*
	 * Assumption extra buffer is not allowed to use.
	 */
	public void deleteDuplicatesWithoutBuffer() {
		if (isEmpty()) {
			return;
		}
		Node firstRunner = head;
		while(firstRunner != null) {
			Node secondRunner = firstRunner.next;
			Node prev = firstRunner;
			while(secondRunner != null) {
				if (firstRunner.value == secondRunner.value) {
					prev.next = secondRunner.next;
				} else {
					prev = secondRunner;
				}
				secondRunner = secondRunner.next;
			}
			firstRunner = firstRunner.next;
		}
	}
	
	public static void main(String[] args) {
		Problem1 object = new Problem1();
		for (int i=0; i<100; i++) {
			for (int j=1; j<=100; j++) {
				object.add(j%2);
			}
		}
		object.displayList();
		object.deleteDuplicatesWithBuffer();
		object.displayList();
	}
}
