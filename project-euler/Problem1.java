import java.util.Scanner;

class Problem1 {
	public int findSum(int limit, int num1, int num2){
		int sum=0;
		int a=num1, b=num2;

		for(int i = min(num1, num2); i < limit; i = min(a,b)) {
			sum += i;
			
			if (a == b) {
				a += num1;
				b += num2;
			} else if ( a < b) {
				a += num1;
			} else {
				b += num2;
			}
		}
		return sum;
	}

	private int min(int a, int b){
		if (a < b)
			return a;
		else
			return b;
	}	

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int input;
		System.out.print("Enter the limit:");
		input = scan.nextInt();
		Problem1 obj = new Problem1();
		System.out.println("The sum is " + obj.findSum(input, 3, 5));
	}
}
