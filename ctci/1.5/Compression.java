public class Compression {
	public static String compress(String str) {
		int len = str.length();
		char[] strArray = str.toCharArray();
		char[] cmpr = new char[len];
		int i=1, j=0;
		int count=1;
		char prev, cur;
		cur = strArray[0];
		prev = strArray[0];

		while(i < len) {
			if (prev == strArray[i]) {
				count++;
				i++;
				continue;
			}
			j = cpy(prev, count, j, cmpr);
			if (j >= len) break;
			prev = strArray[i];
			count = 1;
			i++;
		}

		if (j < len-2) {
			cpy(prev, count, j, cmpr);
			return new String(cmpr);
		} else {
			return str;
		}
	}

	private static int cpy(char chr, int count, int pos, char[] chrArray ) {
		int i=0;
		int len = chrArray.length;
		char[] countArr = Integer.toString(count).toCharArray();
		int clen = countArr.length;
		if (pos + 1 + clen >= len)
			return len;

		chrArray[pos++] = chr;
		while(i<clen)
			chrArray[pos++] = countArr[i++];
		return pos;
	}

	public static void main(String...args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Usage: java Compression <string>");
		
		System.out.println(compress(args[0]));
	}
}
