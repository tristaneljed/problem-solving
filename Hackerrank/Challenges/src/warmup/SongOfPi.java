package warmup;

import java.util.Scanner;

public class SongOfPi {
	
	private static int[] pi = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 
		9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4,3 ,3, 8, 3, 3};
	private static String piSong = "It's a pi song.";
	private static String notPiSong = "It's not a pi song.";
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		
		while(t-- > 0) {
			System.out.println(solve(s.nextLine()));
		}
		
		s.close();
	}

	private static String solve(String song) {
		String[] songWords = song.split(" ");
		for (int i=0; i<songWords.length; i++) {
			if (songWords[i].length() != pi[i]) {
				return notPiSong;
			}
		}
		return piSong;
	}

}
