import java.util.Map;
import java.util.HashMap;

public class LLDup {
	public static void checkDuplicates(LL<Integer> ll) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		LLNode cur = ll.getHead();
		LLNode prev = null;
		while(cur != null) {
			Integer item = (Integer) cur.item; 
			if (map.get(item) == null) {
				map.put(item, true);
				prev = cur;
			} else {
				prev.next = cur.next;
			}
			cur = cur.next;
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
