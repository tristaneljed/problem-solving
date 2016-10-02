package implementation;

import java.util.Scanner;

public class StrangeCode {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long t = s.nextLong();
		StrangeCode object = new StrangeCode();
		object.solve(t);
		s.close();
	}

	private void solve(long t) {
		long cycle = (long)Math.ceil(Math.log(((double)t/3) + 1) / Math.log(2));
		long lastOfCyle = (long) (3 *(Math.pow(2, cycle) - 1));
		System.out.println(lastOfCyle - t + 1);
	}
}
