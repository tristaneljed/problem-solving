public class LL<T> {
	private LLNode head = null;

	public void add(T item) {
		LLNode<T> node = new LLNode<T>();
		node.item = item;
		node.next = head;
		head = node;
	}

	@Override
	public String toString() {
		LLNode temp = head;
		String output = "";
		
		if (temp == null)
			return output;

		while (temp.next != null) {
			output += temp.item.toString() + " -> ";
			temp = temp.next;
		}
		
		output += temp.item.toString();
		return output;
	}

	public LLNode getHead() {
		return head;
	}
	
	public void setHead(LLNode node) {
		head = node;
	}
}
