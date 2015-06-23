package ciscoapril2015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BigFileSystemSearch {
	
	private File[] allFiles;
	private int numOfFiles;
	private int numOfQueries;
	
	private final static int QUERY_ALL = 1;
	private final static int QUERY_ANY = 2;
	private final static int QUERY_SOME = 3;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BigFileSystemSearch obj = new BigFileSystemSearch();
		obj.numOfFiles = s.nextInt();
		obj.allFiles = new File[obj.numOfFiles];
		
		for (int i=0; i<obj.numOfFiles; i++) {
			int size = s.nextInt();
			Map<Integer, Integer> data = new HashMap<Integer, Integer>();
			for (int j=0; j<size; j++) {
				int temp = s.nextInt();
				if (data.containsKey(temp)) {
					data.put(temp, data.get(temp) + 1);
				} else {
					data.put(temp, 1);
				}
			}
			obj.allFiles[i] = obj.new File();
			obj.allFiles[i].setData(data);
		}
		
		obj.numOfQueries = s.nextInt();
		for (int i=0; i<obj.numOfQueries; i++) {
			int queryType= s.nextInt();
			int queryLen = s.nextInt();
			Map<Integer, Integer> queryData = new HashMap<Integer, Integer>();
			for (int j=0; j<queryLen; j++) {
				int data = s.nextInt();
				if (queryData.containsKey(queryData)) {
					queryData.put(data, queryData.get(data)+1);
				} else {
					queryData.put(data, 1);
				}
			}
			System.out.println(obj.solve(queryType, queryData, queryLen));
		}
		
		s.close();
	}
	
	private int solve(int queryType, Map<Integer, Integer> queryData, int queryLen) {
		int result = 0;
		for (int i=0; i<allFiles.length; i++) {
			int occurence = allFiles[i].numOfOccurences(queryData);
			if ((queryType == QUERY_ALL) && (occurence == queryLen)) {
					result++;
			} else if ((queryType == QUERY_ANY) && (occurence > 0)) {
				result++;
			} else if ((queryType == QUERY_SOME) && (occurence > 0) && (occurence < queryLen)) {
				result++;
			}
		}
		return result;
	}

	class File {
		private Map<Integer, Integer> data = new HashMap<>();

		public void setData(Map<Integer, Integer> index) {
			data = index;
		}
		
		public int numOfOccurences(Map<Integer, Integer> index) {
			int sum = 0;
			for (Map.Entry<Integer, Integer> entry : index.entrySet()) {
				if (data.containsKey(entry.getKey())) {
					sum += Math.min(data.get(entry.getKey()), entry.getValue());
				}
			}
			return sum;
		}
	}

}
