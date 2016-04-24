package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MaximiseSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-- > 0) {
			MaximiseSum maximiseSum = new MaximiseSum();
			int n = s.nextInt();
			long m = s.nextLong();
			long[] array = new long[n];
			for (int i=0; i<n; i++) {
				array[i] = s.nextLong() % m;
			}
			System.out.println(maximiseSum.solve(array, m, n));
		}
		s.close();
	}

	private long solve(long[] array, long m, int n) {
		long[] prefixSum = new long[n+1];
		prefixSum[0] = 0;
		for (int i=1; i<n+1; i++) {
			prefixSum[i] = (prefixSum[i-1] + array[i-1]) % m;
		}
		
		Map<Long, MaxMinIndex> prefixSumMap = new HashMap<Long, MaximiseSum.MaxMinIndex>();
		List<Long> distinctPrefixSum = new ArrayList<>();
		
		for (int i=0; i<n+1; i++) {
			if (prefixSumMap.containsKey(prefixSum[i])) {
				prefixSumMap.get(prefixSum[i]).add(i);
			} else {
				MaxMinIndex maxMinIndex = new MaxMinIndex(i);
				prefixSumMap.put(prefixSum[i], maxMinIndex);
				distinctPrefixSum.add(prefixSum[i]);
			}
		}
		prefixSum = null;
		Collections.sort(distinctPrefixSum);
		long max = distinctPrefixSum.get(distinctPrefixSum.size() - 1);

		for (int i=0; i<distinctPrefixSum.size()-1; i++) {
			if (prefixSumMap.get(distinctPrefixSum.get(i)).hasGreaterIndex(
					prefixSumMap.get(distinctPrefixSum.get(i+1)))) {
				long value = (distinctPrefixSum.get(i) - distinctPrefixSum.get(i+1) + m) % m;
				if (value > max) {
					max = value;
				}
			}
		}
		
		return max;
	}
	
	class MaxMinIndex {
		int min;
		int max;
		
		public MaxMinIndex(int index) {
			min = index;
			max = index;
		}
		
		public void add(int index) {
			if (index < min) {
				min = index;
			} else if (index > max) {
				max = index;
			}
		}
		
		public boolean hasGreaterIndex(MaxMinIndex that) {
			return this.max > that.min;
		}
	}
}
