package chapter2;

public class Problem2 {
	
	class Node {
		int value;
		Node next;
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
	
	public int kthElementFromLast(int k) throws Exception {
		Node firstRunner = head;
		Node secondRunner = head;
		
		for (int i=0; i<k-1 && secondRunner != null; i++) {
			secondRunner = secondRunner.next;
		}
		
		if (secondRunner == null) {
			throw new Exception("List has less than " + k + " elements.");
		}
		
		while(secondRunner.next != null) {
			firstRunner = firstRunner.next;
			secondRunner = secondRunner.next;
		}
		
		return firstRunner.value;
	}
	
	public static void main(String[] args) throws Exception {
		Problem2 object = new Problem2();
		
		for (int i=1; i<=1000; i++) {
			object.add(i);
		}
		
		System.out.println(object.kthElementFromLast(10));
	}
}
