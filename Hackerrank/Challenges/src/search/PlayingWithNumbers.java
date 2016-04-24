package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlayingWithNumbers {
	
	private int n;
	private int q;
	private long[] array;
	private long[] queries;

	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		PlayingWithNumbers object = new PlayingWithNumbers();
	
		while (t-- > 0) {
			object.n = Integer.valueOf(bi.readLine());
			
			String[] inputArray = bi.readLine().trim().split("\\s+");
			object.array = new long[object.n];
			for (int i=0; i<object.n; i++) {
				object.array[i] = Integer.valueOf(inputArray[i]);
			}
			
			object.q = Integer.valueOf(bi.readLine());
			object.queries = new long[object.q];
			inputArray = bi.readLine().trim().split("\\s+");
			object.queries[0] = Long.valueOf(inputArray[0]);
			for (int i=1; i<object.q; i++) {
				object.queries[i] = object.queries[i-1] + Long.valueOf(inputArray[i]);
			}
			object.solve();
		}
		bi.close();
	}
	
	private void solve() {
		Arrays.sort(array);
		long[] prefixSum = new long[n];
		
		prefixSum[0] = array[0];
		for (int i=1; i<n; i++) {
			prefixSum[i] = prefixSum[i-1] + array[i];
		}
		
		for (int i=0; i<q; i++) {
			int index = findFirstPositiveIndex(queries[i], 0, n-1);
			long sumOfNegatives = findAbsoluteSumOfNegatives(prefixSum, index, queries[i]);
			long sumOfPositives = findAbsoluteSumOfPositives(prefixSum, index, queries[i]);
			System.out.println(sumOfNegatives + sumOfPositives);
		}
	}

	private long findAbsoluteSumOfPositives(long[] prefixSum, int index, long query) {
		if (array[index] + query < 0) {
			return 0;
		} else if (index == 0) {
			return Math.abs(prefixSum[n-1] + (query * n)); 
		} else {
			return Math.abs((prefixSum[n-1] - prefixSum[index-1]) + ((n - index) * query));
		}
	}

	private long findAbsoluteSumOfNegatives(long[] prefixSum, int index, long query) {
		if (array[index] + query < 0) {
			return Math.abs(prefixSum[index] + (query * (index + 1)));
		} else if (index == 0) {
			return 0;
		} else {
			return Math.abs(prefixSum[index-1] + (query * index));
		}
	}

	private int findFirstPositiveIndex(long query, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (mid == 0 || ((array[mid-1] + query) < 0 && (array[mid] + query) >= 0)) {
				return mid;
			} else if ((array[mid-1] + query) >= 0 && (array[mid] + query) >= 0 )  {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}
}
