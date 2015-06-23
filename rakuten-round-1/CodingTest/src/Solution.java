
public class Solution {
	
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
    	long a1 = getArea(K, L, M, N);
    	long a2 = getArea(P, Q, R, S);
    	long totalArea = a1 + a2;
    	
    	int x1 = Math.max(K, P);
    	int y1 = Math.max(L, Q);
    	int x2 = Math.min(M, R);
    	int y2 = Math.min(N, S);
    	
    	if ((x1 < x2) && (y1 < y2)) {
    		long intersectionArea = getArea(x1, y1, x2, y2);
    		totalArea = totalArea - intersectionArea;
    	}
    	
    	if (totalArea <= 2147483647)
    		return (int)totalArea;
    	else
    		return -1;
    }
    
    private long getArea(int a, int b, int c, int d) {
    	long length = (long)Math.abs(c - a);
    	long width = (long)Math.abs(d -b);
    	return length * width; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
