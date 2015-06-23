package ciscoapril2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Picking {
	
	private static Map<Integer, Set<Integer>> intersectingPoints;
	private static int n;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i=1; i<=t; i++) {
			intersectingPoints = new HashMap<Integer, Set<Integer>>();
			n = s.nextInt();
			for (int j=0; j<n; j++) {
				addLine(j, s.nextInt(), s.nextInt());
			}
			System.out.println("Case " + i + ": " + solution());
		}
		s.close();
	}

	private static int solution() {
		int maxIntersectingLines = -1;
		List<Integer> keyset = new ArrayList<Integer>(intersectingPoints.keySet());
		Map<Integer, Integer> cardinality = new HashMap<>();
		
		int maxCardinality = -1;
		int maxCardPoint = -1;
		
		for (int i=0; i<keyset.size(); i++) {
			int point = keyset.get(i);
			int card = intersectingPoints.get(point).size();
			cardinality.put(point, card);
			if (card > maxCardinality) {
				maxCardinality = card;
				maxCardPoint = point;
			}
		}
		
		maxIntersectingLines = maxCardinality;
		Set<Integer> largestSet = intersectingPoints.get(maxCardPoint);
		maxIntersectingLines += findOtherLargestSet(keyset, largestSet); 
		
		/*
		for (int i=0; i<keyset.size()-1; i++) {
			for (int j=i+1; j<keyset.size(); j++) {
				Set<Integer> lineSet1 = intersectingPoints.get(keyset.get(i));
				Set<Integer> lineSet2 = intersectingPoints.get(keyset.get(j));
				int numOfIntersectingLines = findIntesectingLines(lineSet1, lineSet2);
				if (numOfIntersectingLines > maxIntersectingLines) {
					maxIntersectingLines = numOfIntersectingLines;
				}
			}
		}
		*/
		
		return maxIntersectingLines;
	}

	private static int findOtherLargestSet(List<Integer> keyset,
			Set<Integer> largestSet) {
		int maxUncoveredSetSize = -1;
		for (int i=0; i<keyset.size(); i++) {
			Set<Integer> set = new HashSet<>(intersectingPoints.get(keyset.get(i)));
			set.remove(largestSet);
			int size = set.size();
			if (size > maxUncoveredSetSize) {
				maxUncoveredSetSize = size;
			}
		}
		return maxUncoveredSetSize;
	}

	private static int findIntesectingLines(Set<Integer> lineSet1,
			Set<Integer> lineSet2) {
		Set<Integer> unionSet = new HashSet<>(lineSet1);
		unionSet.addAll(lineSet2);
		return unionSet.size();
	}

	private static void addLine(int lineNumber, int startPoint, int endPoint) {
		for (int i=startPoint; i<=endPoint; i++) {
			if (intersectingPoints.containsKey(i)) {
				Set<Integer> set = intersectingPoints.get(i);
				set.add(lineNumber);
				intersectingPoints.put(i, set);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(lineNumber);
				intersectingPoints.put(i, set);
			}
		}
	}
	
}
