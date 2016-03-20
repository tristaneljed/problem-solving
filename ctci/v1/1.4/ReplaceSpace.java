public class ReplaceSpace {
	public static String replace(String str) {
		char[] strArray = str.toCharArray();
		int len = strArray.length;
		int i = len-1;
		int j = i;
		while(strArray[j] == ' ') j--;
		
		while(j > -1 && i > -1) {
			if(strArray[j] != ' ') {
				strArray[i] = strArray[j];
				j--;
				i--;
				continue;
			}

			strArray[i--] = '0';
			strArray[i--] = '2';
			strArray[i--] = '%';
			j--;
		}
		while(i > -1)
			strArray[i--] = ' ';

		return new String(strArray).trim();
	}

	public static void main(String...args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Usage: java ReplaceSpace <String>");

		System.out.println(replace(args[0]));

	}
}
