public class CheckPermutation {

	public static boolean check(String str1, String str2) {
		int len;
		len = str1.length();

		if(len != str2.length())
			return false;

		int[] chars = new int[256];
		
		for(int i=0; i<len; i++)
			chars[(int) str1.charAt(i)]++;

		for(int i=0; i<len; i++) {
			chars[(int) str2.charAt(i)]--;
			if (chars[(int) str2.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	public static void main(String...args) {
		if(args.length != 2)
			throw new IllegalArgumentException("Usage: java CheckPermutation <String-1> <String-2>");

		if(check(args[0], args[1]))
			System.out.println("It is a permutation!!");
		else
			System.out.println("It is not a permutation!!");
	}
}
