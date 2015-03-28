import java.util.Scanner;


public class CavityMap {

	private static char cavityMap[][]; 
	private static byte size;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		size = s.nextByte();
		cavityMap = new char[size][size];
		
		for(int i=0; i<size; i++) {
			String input = s.next();
			cavityMap[i] = input.toCharArray();
		}
		
		findCavity();
		
		for (int i=0; i<size; i++) {
			System.out.println(cavityMap[i]);
		}
		s.close();
	}

	private static void findCavity() {
		for (int i=1; i<size-1; i++) {
			for (int j=1; j<size-1; j++) {
				if (isCavity(i,j)) {
					cavityMap[i][j] = 'X';
				}
			}
		}
	}

	private static boolean isCavity(int i, int j) {
		if (i==0 || i==size-1 || j==0 || j==size-1) {
			return false;
		}
		
		char middle = cavityMap[i][j];
		char left = cavityMap[i][j-1];
		char right = cavityMap[i][j+1];
		char up = cavityMap[i-1][j];
		char down = cavityMap[i+1][j];
		
		if (left == 'X' || right == 'X' || up == 'X' || down == 'X') {
			return false;
		}
		
		if (up >= middle || down >= middle || left >= middle || right >= middle) {
			return false;
		}
		
		return true;
	}

}
