package epiccode;

import java.util.Scanner;

public class WhiteFalconAndSequence {

	private static int [] arr;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		
		long multArray[][] = new long[n][n];
		
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				multArray[i][j] = (long) arr[i] * arr[j];
			}
		}
		
		long maxSum = Long.MIN_VALUE;
		long sum = 0;
		boolean flag = true;
		
		   for( int k = 0 ; k < n * 2 ; k++ ) {
			   flag = true;
		        for( int j = 0 ; j <= k ; j++ ) {
		            int i = k - j;
		            if( i < n && j < n && i < j) {
		            	
		            	if (flag) {
		            		sum = multArray[i][j];
		            		flag = false;
		            		continue;
		            	} else {
		            		if (multArray[i][j] < 0) {
		    					if (sum < multArray[i][j]) {
		    						sum = multArray[i][j];
		    					} else {
		    						if (sum > 0) {
		    							sum += multArray[i][j];
		    						}
		    					}
		    				} else {
		    					if (sum < 0) {
		    						sum = multArray[i][j];
		    					} else {
		    						sum += multArray[i][j];
		    					}
		    				}
		    				if (sum > maxSum) {
		    					maxSum = sum;
		    				}
		            	}
		            }
		        }
		    }
		
		System.out.println(maxSum);
		s.close();
	}


}
