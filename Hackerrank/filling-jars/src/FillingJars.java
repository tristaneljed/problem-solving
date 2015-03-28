import java.util.Scanner;

public class FillingJars {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long m = s.nextLong();
		long total = 0;
		for (int i=0; i<m; i++) {
			long a = s.nextLong();
			long b = s.nextLong();
			long k = s.nextLong();
			total += (b-a+1)*k;
		}
		System.out.println(total/n);
		s.close();
	}

}
