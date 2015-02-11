import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {

	private static Map<String, Integer> columnFlippingStat;
	private static int maxWishes = -1;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();
		int cols = s.nextInt();
		columnFlippingStat = new HashMap<>();
		
		char [][] box = new char[rows][cols];
		for (int i=0; i<rows; i++) {
			String column = s.next();
			box[i] = column.toCharArray();
			findFlippingSet(box[i]);
		}
		System.out.println(maxWishes);
		s.close();
	}

	private static void findFlippingSet(char[] row) {
		StringBuilder allP = new StringBuilder();
		StringBuilder allT = new StringBuilder();
		
		for (int i=0; i<row.length; i++) {
			if (row[i] == 'P' ) {
				allP.append('0');
				allT.append('1');
			} else {
				allP.append('1');
				allT.append('0');
			}
		}
		
		int allPFreq = updateSet(allP.toString());
		int allTFreq = updateSet(allT.toString());
		
		maxWishes = Math.max(maxWishes, Math.max(allPFreq, allTFreq));
	}

	private static int updateSet(String flippedCols) {
		int freq = 0;
		if (columnFlippingStat.containsKey(flippedCols)) {
			freq = columnFlippingStat.get(flippedCols);
		}
		columnFlippingStat.put(flippedCols, freq+1);
		return freq+1;
	}

}
