public class MiddleElement {
	public static LL initialize() {
		LL<Integer> ll = new LL<Integer>();

		for (int i=100; i>0; i--)
			ll.add(i);

		return ll;
	}

	public static void removeMiddleElement(LL ll) {
		LLNode p1 = ll.getHead();
		LLNode p2 = ll.getHead();
		LLNode prev = null;

		if (p1 == null || p1.next == null) {
			ll.setHead(null);
			return;
		}

		while(p2.next != null && p2.next.next != null) {
			prev = p1;
			p1 = p1.next;
			p2 = p2.next.next;
		}

		if (prev == null) {
			ll.setHead(p1.next);
		} else {
			prev.next = prev.next.next;
		}
	}

	public static void main(String...args) {
	       LL ll = initialize();
	       System.out.println("Before : " + ll);
	       removeMiddleElement(ll);
	       System.out.println("After : " + ll);
	}
}
