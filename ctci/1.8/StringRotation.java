public class StringRotation {
	public static boolean isSubstring(String str1, String str2) {
		return str1.contains(str2);
	}

	public static void main(String...args) {
		if(args.length != 2)
			throw new IllegalArgumentException("Usage:java StringRotation <string1> <string2>");

		if (args[0].length() != args[1].length()) {
			System.out.println("It is not a rotation");
			return;
		}

		String str = args[0] + args[0];

		if (isSubstring(str, args[1]))
			System.out.println("It is a rotation");
		else	
			System.out.println("It is not rotation");
	}
}
