public class Partition {

	public static void partition(LL ll, int k) {
		LLNode less1 = null;
		LLNode less2 = null;
		LLNode high1 = null;
		LLNode high2 = null;
		LLNode runner = null;
		LLNode nextRunner = null;

		runner = ll.getHead();
		while (runner != null) {
			nextRunner = runner.next;
			if ((Integer)runner.item > k) {
				if (high1 == null && high2 == null)
					high1 = high2 = runner;
				else {
					high2.next = runner;
					high2 = high2.next;
				}
			} else {
				if (less1 == null && less2 == null)
					less1 = less2 = runner;
				else {
					less2.next = runner;
					less2 = less2.next;
				}
			}
			runner = nextRunner;
		}

		if (less2 != null)
			less2.next = high1;

		if (high2 != null)
			high2.next = null;

		ll.setHead(less1);
	}

	private static LL initialize() {
		LL<Integer> ll = new LL<Integer>();
		for (int i=1; i<101; i++)
			ll.add(i);

		for (int i=1; i<101; i++)
			ll.add(i);

		return ll;
	}

	public static void main(String...args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Usage:java Partition <value-of-k>");

		LL ll = initialize();
		int k = Integer.parseInt(args[0]);
		System.out.println("Before : " + ll);
		partition(ll, k);
		System.out.println("After : " + ll);
	}
}
