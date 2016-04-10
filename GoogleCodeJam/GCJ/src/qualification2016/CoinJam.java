package qualification2016;

import java.math.BigInteger;

public class CoinJam {
	final static int n = 32;
	final static int j = 500;
	
	public static void main(String[] args) {
		int counter = 0;
		StringBuilder result = new StringBuilder();
		result.append("Case #1:\n");
		
		for(int i=0; i<j; i++) {
			
			String factors = "";
			
			do {
				factors = factorsOfAllBase(buildNumber(counter));
				counter++;
			} while(factors.equals(""));
			result.append(buildNumber(counter-1));
			result.append(" ");
			result.append(factors);
			result.append("\n");
		}
		System.out.println(result.toString());
	}
	


	private static String factorsOfAllBase(String number) {
		int base = 2;
		StringBuilder result = new StringBuilder();
		for (base = 2; base<=10; base++) {
			BigInteger bg = new BigInteger(number, base);
			int factor = getFactor(bg);
			if (factor == -1) {
				break;
			}
			result.append(factor);
			result.append(" ");
		}
		
		return (base == 11) ? result.toString() : "";
	}

	private static int getFactor(BigInteger bg) {
		int max = 1<<10;
		for (int i=2; i<=max; i++) {
			if(bg.mod(new BigInteger(String.valueOf(i))).equals(BigInteger.ZERO)) {
				return i;
			}
		}
		return -1;
	}

	private static String buildNumber(int number) {
		String result = Integer.toString(number, 2);
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		for (int i=0; i<n-2-result.length(); i++) {
			sb.append('0');
		}
		sb.append(result);
		sb.append('1');
		return sb.toString();
	}
	
}
