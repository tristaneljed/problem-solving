public class Addition {

	private static LL initialize1() {
		LL<Integer> ll = new LL<Integer>();
		for (int i=1; i<5; i++)
			ll.add(i);

		return ll;
	}
	
	private static LL initialize2() {
		LL<Integer> ll = new LL<Integer>();
		for (int i=4; i>0; i--)
			ll.add(i);

		return ll;
	}

	public static LL sum(LL ll1, LL ll2) {
		//So boring
		return null;
	}

	public static void main(String...args) {
		LL ll1 = initialize1();
		LL ll2 = initialize2();
		System.out.println("Numbers : " + ll1 + " and " + ll2);
		LL ll = sum(ll1, ll2);
		System.out.println("Sum : " + ll);
	}
}
