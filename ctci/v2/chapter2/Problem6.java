package chapter2;

public class Problem6 {
	
	class Node {
		int value;
		Node next = null;
	}
	
	private Node head = null;
	private Node tail = null;

	public void add(int number) {
		Node node = new Node();
		node.value = number;
		node.next = head;
		head = node;
		if (tail == null) {
			tail = head;
		}
		
		//Hard coding cycle here
		if (number == 4) {
			tail.next = head;
		}
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
	
	public Node startOfLoop() {
		Node firstRunner = head;
		Node secondRunner = head;
		
		while(firstRunner != null &&
			  secondRunner != null) {
			
			firstRunner = firstRunner.next;
			secondRunner = secondRunner.next != null ? 
							secondRunner.next.next : null;
			
			if (firstRunner == secondRunner) {
				break;
			}
		}
		
		if (firstRunner == null || secondRunner == null) {
			return null;
		}
		
		Node thirdRunner = head;
		
		while(firstRunner != thirdRunner) {
			firstRunner = firstRunner.next;
			thirdRunner = thirdRunner.next;
		}
		
		return firstRunner;
	}
	
	public static void main(String[] args) {
		Problem6 object = new Problem6();
		object.add(1);
		object.add(2);
		object.add(3);
		object.add(4);
		object.add(5);
		object.add(6);
		object.add(7);
		object.add(8);
		object.add(9);
		System.out.println("Start of loop is from => " + object.startOfLoop().value);
	}
}
