import java.util.Scanner;

public class AcmIcpcTeam {
	private static int n,m;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] input = s.nextLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		String[] skills = new String[n];
		for (int i=0; i<n; i++) {
			skills[i] = s.next();
		}
		calculate(skills);
		s.close();
	}

	private static void calculate(String[] skills) {
		int count = 0;
		int maxSkills = 0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				int temp = totalSkills(skills[i], skills[j]);
				if (temp == maxSkills) {
					count++;
				} else if (temp > maxSkills) {
					maxSkills = temp;
					count = 1;
				} 
			}
		}
		System.out.println(maxSkills);
		System.out.println(count);
	}

	private static int totalSkills(String str1, String str2) {
		int count = 0;
		for (int i=0; i<m; i++) {
			if (str1.charAt(i) == '1' || str2.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
}
