import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if(i % j == 0) {
					result++;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}
