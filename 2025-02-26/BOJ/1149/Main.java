

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		
		int r, g, b;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
		}
		
		int[][] dp = new int[n][n];
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
		}
		int result = Math.min(dp[n-1][0], dp[n-1][1]);
		result = Math.min(result, dp[n-1][2]);
		System.out.println(result);
		
		
	}
}
