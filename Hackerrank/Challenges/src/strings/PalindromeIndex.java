package strings;
import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOfTestCases = s.nextInt();
		while (numOfTestCases-- > 0) {
			String str = s.next();
			System.out.println(findPalindromeIndex(str));
		}
		s.close();
	}
	
	public static int findPalindromeIndex(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				if (isPalindrome(str, left)) {
					return left;
				}
				return right;
			}
			left++;
			right--;
		}
		return -1;
	}

	private static boolean isPalindrome(String input, int index) {
		String str;
		
		if (index == 0) {
			str = input.substring(index+1);
		} else if (index == input.length() -1 ) {
			str = input.substring(0, index-1);
		} else {
			str = input.substring(0, index) + input.substring(index+1, input.length());
		}
		
		int i = 0;
		int j = str.length()-1;
		
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
