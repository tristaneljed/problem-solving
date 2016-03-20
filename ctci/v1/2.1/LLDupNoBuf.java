public class LLDupNoBuf {
	public static void checkDuplicates(LL<Integer> ll) {
		LLNode itr = ll.getHead();
		LLNode prev = null;
		LLNode cur = null;
		while(itr.next != null) {
			Integer item = (Integer) itr.item;
			prev = itr;
			cur = itr.next;
			while (cur != null) {
				if (cur.item == itr.item) {
					prev.next = cur.next;
				} else {
					prev = cur;
				}
				cur = cur.next;
			}
			itr = itr.next;
		}
	}

	public static void main(String...args) {
		if (args.length == 0)
			throw new IllegalArgumentException("Usage:java LLDup <num1> <num2> ... <numN>");

		LL<Integer> ll = new LL<Integer>();
		for (String str: args)
			ll.add(Integer.parseInt(str));

		System.out.println( "Before : " + ll);
		checkDuplicates(ll);
		System.out.println( "After : " + ll);
	}
}
