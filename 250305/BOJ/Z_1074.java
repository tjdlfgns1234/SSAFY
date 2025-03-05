import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

	static int targetR, targetC, N;
	static int result;
	static boolean finished;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		targetR = Integer.parseInt(st.nextToken());
		targetC = Integer.parseInt(st.nextToken());
		finished = false;
		
		int size = (int) Math.pow(2, N);
		
		result = divide(0, 0, size);
		System.out.println(result);
	}

	public static int divide(int r, int c, int size) {
		if (finished) return 0;
		
		if (!contains(r, c, size)) {
			return size * size;
		}
		
		int count = 0;
		
		if (size == 2) {
			for (int i=r; i<r+size; ++i) {
				for (int j=c; j<c+size; ++j) {
					if (i == targetR && j == targetC) {
						finished = true;
						return count;
					}
					++count;
				}
			}
		}
		

		int newSize = size / 2;
		count += divide(r, c, newSize);
		count += divide(r, c+newSize, newSize);
		count += divide(r+newSize, c, newSize);
		count += divide(r+newSize, c+newSize, newSize);
		
		
		
		return count;
	}

	public static boolean contains(int r, int c, int size) {
		return targetR >= r && targetR < r + size && targetC >= c && targetC < c + size;
	}
}
