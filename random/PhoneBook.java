import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PhoneBook {

	private static Map<String, ArrayList<Integer>> phoneBook;
	
	public static void main(String[] args) {
		phoneBook = new HashMap<>();
		updatePhonebook("Xyz",61234567);
		updatePhonebook("CDe", 69910293);
		updatePhonebook("xYZ", 90029309);
		updatePhonebook("FgH", 93090932);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name:");
		searchPhonebook(s.next());
		s.close();
	}

	private static void searchPhonebook(String name) {
		if (phoneBook.containsKey(name.toLowerCase())) {
			ArrayList<Integer> list = phoneBook.get(name.toLowerCase());
			for (int number: list) {
				System.out.println(number);
			}
		}
	}

	private static void updatePhonebook(String name, int number) {
		if (phoneBook.containsKey(name.toLowerCase())) {
			ArrayList<Integer> list = phoneBook.get(name.toLowerCase());
			list.add(number);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(number);
			phoneBook.put(name.toLowerCase(), list);
		}
	}

}
