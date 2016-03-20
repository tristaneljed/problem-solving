public class CheckUnique {

	public static boolean performCheck(String str) {
		boolean[] chars = new boolean[256];
		for(int i=0; i<str.length(); i++) {

			if(chars[(int)str.charAt(i)])
				return false;

			chars[(int)str.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String args[]) {
		if (args.length < 1)
			throw new IllegalArgumentException("Usage: java CheckUnique <String-1> <String-2> .... <String-n>");

		for (int i=0; i<args.length; i++)
			System.out.println(args[i] + " : " + performCheck(args[i]));
	}
}
