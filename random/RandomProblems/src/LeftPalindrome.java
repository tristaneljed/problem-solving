
public class LeftPalindrome {
	
	public static String solve(String str) {
		int len = str.length();
		int i,j,k;
		i = len-1;
		
		while (i > 0) {
			j = 0;
			k = i;
			while (j < k) {
				if (str.charAt(j) == str.charAt(k)) {
					j++;
					k--;
				} else {
					break;
				}
			}
			
			if (j>=k) {
				break;
			}
			i--;
		}
		
		String prefix = new StringBuffer(str.substring(i+1)).reverse().toString();
		return prefix + str;
	}
	
	public static void main(String[] args) {
		System.out.println(solve("abbaa"));
	}
}
