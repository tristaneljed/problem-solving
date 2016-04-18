package chapter2;

public class Problem4 {
	
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
	
	public void reorganizeList(int x) {
		Node smallerHead = null;
		Node smallerTail = null;
		Node largerHead = null;
		Node largerTail = null;
		Node runner = head;
		
		while(runner != null) {
			if (runner.value < x) {
				Node node = new Node();
				node.value = runner.value;
				if (smallerHead == null && smallerTail == null) {
					smallerHead = node;
					smallerTail = node;
				} else {
					node.next = smallerHead;
					smallerHead = node;
				}
			} else {
				Node node = new Node();
				node.value = runner.value;
				if (largerHead == null && largerTail == null) {
					largerHead = node;
					largerTail = node;
				} else if (runner.value == x) {
					node.next = largerHead;
					largerHead = node;
				} else {
					largerTail.next = node;
					largerTail = node;
				}
			}
			runner = runner.next;
		}
		
		if (smallerHead == null) {
			head = largerHead;
		} else if (largerHead == null) {
			head = smallerHead;
		} else {
			smallerTail.next = largerHead;
			head = smallerHead;
		}
	}
	
	public static void main(String[] args) {
		Problem4 object = new Problem4();
		
		for (int i=0; i<100; i++) {
			object.add(i);
		}
		
		object.displayList();
		object.reorganizeList(10);
		object.displayList();
	}
}
