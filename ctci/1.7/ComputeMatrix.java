import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class ComputeMatrix {
	private static int [][] input;
	private static int m;
	private static int n;
	private static boolean zeroRow[];
	private static boolean zeroCol[];

	public static void compute() {
		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++)
				if (zeroRow[i] || zeroCol[j])
					input[i][j] = 0;
	}

	public static void computeEfficient() {
		for (int i=0; i<m; i++)
			if (zeroRow[i]) nullifyRow(i);
	
		for (int i=0; i<m; i++)
			if (zeroCol[i]) nullifyCol(i);
	}

	private static void nullifyRow(int row) {
		for (int i=0; i<n; i++)
			input[row][i] = 0;
	}
	
	private static void nullifyCol(int col) {
		for (int i=0; i<m; i++)
			input[i][col] = 0;
	}

	public static void display() {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++)
				System.out.print(input[i][j] + "\t");
			System.out.println();
		}

	}

	public static void main(String...args) {
		if(args.length != 2)
			throw new IllegalArgumentException("Usage: java ComputeMatrix <value-of-M> <value-of-N>");

		m = Integer.parseInt(args[0]);
		n = Integer.parseInt(args[1]);
		String[] inp = null;

		input = new int[m][n];
		zeroRow = new boolean[m];
		zeroCol = new boolean[n];

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
			inp = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (inp.length != m * n)
			throw new InputMismatchException("Number of inputs should be " + m * n);

		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++) {
				int temp = Integer.parseInt(inp[(i*n) + j]);
				input[i][j] = temp;
				if (temp == 0) {
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
			}

		//compute();
		computeEfficient();
		display();
	}
}
