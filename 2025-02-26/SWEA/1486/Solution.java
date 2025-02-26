import java.util.*;
import java.io.*;

public class Solution {

	static int N, B,result;
	static int[] heights;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			heights = new int[N];
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0, new boolean[N], 0);
			System.out.printf("#%d %d\n", t, result);
		}

	}
	private static void powerSet(int sum, boolean[] visit, int idx) {
		if(idx == N) {
			if(sum - B >= 0) {
				result = Math.min(sum - B, result);
			}
			return;
		}
		
		visit[idx] = true;
		powerSet(sum + heights[idx], visit, idx + 1);
		
		visit[idx] = false;
		powerSet(sum, visit, idx + 1);
		
	}

}

// 416
// 116 128 239 299
