public class KthElement {

	private static LL initialize() {
		LL<Integer> ll = new LL<Integer>();
		for (int i=100; i>0; i--)
			ll.add(i);

		return ll;
	}

	public static Integer findKthElement(LL ll, int k) {
		LLNode p1 = ll.getHead();
		LLNode p2 = ll.getHead();

		while (k>1 && p2 != null) {
			p2 = p2.next;
			k--;
		}

		if (k != 1 || p2 == null)
			return null;

		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return (Integer)p1.item;
	}

	public static void main(String...args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Usage:java KthElement <value-of-k>");

		int k = Integer.parseInt(args[0]);
		LL ll = initialize();
		System.out.println(ll);
		System.out.println("Kth element is " + findKthElement(ll, k));
	}
}
