import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N, M;
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if((((1 << N) - 1) & M) == ((1<<N) - 1)) System.out.printf("#%d ON\n", t);
			else System.out.printf("#%d OFF\n", t);
		}

	}

}
