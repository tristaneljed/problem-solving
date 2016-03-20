package fbHackGitSingapore;

import java.util.Scanner;


public class MergeArrays {

	private static int[] mergeArrays(int[] a, int[] b) {
		int m = a.length;
		int[] mergedArray = new int[2*m];
		int i=0, j=0, k=0;
		
		while(i<m && j<m) {
			if (a[i] < b[j]) {
				mergedArray[k++] = a[i++];
			} else {
				mergedArray[k++] = b[j++];
			}
		}
		while(i<m) {
			mergedArray[k++] = a[i++];
		}
		while(j<m) {
			mergedArray[k++] = b[j++];
		}
		
		return mergedArray;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }
        
        
        int[] _b = new int[_a_size];
        int _b_item;
        for(int _b_i = 0; _b_i < _a_size; _b_i++) {
            _b_item = Integer.parseInt(in.nextLine());
            _b[_b_i] = _b_item;
        }
        
        res = mergeArrays(_a, _b);
        in.close();
        
        for (int num:res) {
        	System.out.println(num);
        }
	}

}
