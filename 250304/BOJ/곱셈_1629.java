import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_1629 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		long result = solve(A, B, C) % C;
		System.out.println(result);
	}
	
	public static long solve(long x, long n, long C) {
		if (n == 1) {
			return x;
		}

		long y = solve(x, n/2, C) % C;
		return n % 2 == 0 ? y * y : ((y * y)%C) * (x%C);
	}

}

