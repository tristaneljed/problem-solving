package dynamicprogramming;

import java.util.Scanner;

public class StockMaximize {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfTestcases = s.nextInt();
		
		while (numberOfTestcases-- > 0) {
			int days = s.nextInt();
			long[] price = new long[days];
			for (int i=0; i<days; i++) {
				price[i] = s.nextLong();
			}
			System.out.println(maxProfit(price, 0, days-1));
		}
		s.close();
	}

	private static long maxProfit(long[] price, int startingDay, int endingDay) {
		long profit = 0;
		
		if (startingDay >= endingDay) {
			return 0;
		}
		
		int dayWithMaxRate = startingDay;
		for (int i=startingDay; i<=endingDay; i++) {
			if(price[i] > price[dayWithMaxRate]) {
				dayWithMaxRate = i;
			}
		}
		
		if (dayWithMaxRate == startingDay) {
			return maxProfit(price, dayWithMaxRate + 1, endingDay);
		}
		
		long costOfShares = 0;
		for (int i=startingDay; i<dayWithMaxRate; i++) {
			costOfShares += price[i];
		}
		
		profit = ( (dayWithMaxRate - startingDay) * price[dayWithMaxRate] ) - costOfShares;
		
		if (profit < 0) {
			System.out.println("Cost of shares = " + costOfShares + "; days = " + 
					(dayWithMaxRate - startingDay) + "; selling price = "  + price[dayWithMaxRate]);
			System.out.println("Profit < 0");
			return 0;
		}
		
		return profit + maxProfit(price, dayWithMaxRate + 1, endingDay);
	}
}
