package strings;

import java.util.Scanner;

public class AshtonAndString {
	
	private static int numOfOccurance = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			String str = s.next();
			int k = s.nextInt();
			System.out.println(solve(str, k));
		}
		s.close();
	}

	private static char solve(String str, int k) {
		/*
		char startingChar = 'a';
		char [] strArr = str.toCharArray();
		SubstringUtil obj = new AshtonAndString.SubstringUtil(str, strArr);
		char chr = 'a';
		for (int i=0; i<26; i++) {
			chr = (char) (startingChar + i);
			int len = obj.checkSubstringLengthStartingWithChar(chr);
			if (len >= k) {
				break;
			} else {
				k -= len;
			}
		}
		
		obj.computeSubstringStartingWithChar(chr);
		obj.computeResult();
		return obj.getOutputString().charAt(k-1);
		*/
		
		String sub = "";
		String substr;
		char startingChar = 'a';
		
		while (k > 0 ) {
			substr = sub + startingChar;
			//System.out.println(k + " \n" + sub + "\n " +substr);
			int substrSum = sumOfSubstringSize(str, substr);
			if (substrSum < k) {
				k -= substrSum;
				startingChar = (char) (startingChar + 1);
			} else if (k <= substr.length()) {
				return substr.charAt(k-1);
			} else {
				if (k == substrSum) {
					sub = substr;
				} else {
					startingChar--;
					sub += startingChar;
				}
				startingChar = 'a';
				k -= numOfOccurance * substr.length();
			}
		}
		
		return 'a';
	}
	
	private static int sumOfSubstringSize(String input, String subStr) {
		int sum = 0;
		numOfOccurance = 0;
		for (int i= input.indexOf(subStr, 0); (i != -1 && input.indexOf(subStr, i) != -1) ; i = input.indexOf(subStr, i+1)) {
			numOfOccurance++;
			sum += (input.length() - i + subStr.length()) * (input.length() - i - subStr.length() + 1) / 2;
		}
		return sum;
	}
	
	
	
	/*
	static class SubstringUtil {
		private int len = 0;
		private StringBuilder concat;
		private String input;
		private char[] inputArr;
		private Map<String, Boolean> occurrence;
		private ArrayList<String> subStrings;
		
		public SubstringUtil(String input, char[] inputArr) {
			this.input = input;
			this.inputArr = inputArr;
		}
		
		public int checkSubstringLengthStartingWithChar(char startingChar) {
			int substrLen = 0;
			for (int i=0; i<inputArr.length; i++) {
				if (inputArr[i] == startingChar) {
					int n = inputArr.length - i;
					substrLen += (n * (n+1))/2;
				}
			}
			return substrLen;
		}
		
		public void computeSubstringStartingWithChar(char startingChar) {
			len = 0;
			System.out.println("Starting with char => " + startingChar);
			occurrence = new HashMap<>();
			subStrings = new ArrayList<>();
			concat = new StringBuilder();
			for (int i=0; i<inputArr.length; i++) {
				if (inputArr[i] == startingChar) {
					computeSubstringStaringWithIndex(i);
				}
			}
		}
		
		public void computeResult() {
			Collections.sort(subStrings);
			for (String s: subStrings) {
				concat.append(s);
			}
		}
		
		private void computeSubstringStaringWithIndex(int index) {
			for (int i=index; i<input.length(); i++) {
				String substr = input.substring(index, i+1);
				if (occurrence.containsKey(substr)) {
					continue;
				} else {
					occurrence.put(substr, true);
					subStrings.add(substr);
					setLen(getLen() + substr.length());
				}
			}
		}

		public int getLen() {
			return len;
		}

		private void setLen(int len) {
			this.len = len;
		}
		
		public String getOutputString() {
			return concat.toString();
		}
		
	}
	*/

}
