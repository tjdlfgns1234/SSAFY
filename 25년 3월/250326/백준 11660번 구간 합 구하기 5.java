import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] arr;
	static int[][] dp;
	static boolean[] vit;
	static int n,m, ans = 0;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for(int i = 1; i <= n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n;i++) {
			for(int j = 1; j <= n;j++) {
				dp[i][j] = dp[i-1][j]
						+dp[i][j-1]
						-dp[i-1][j-1]
						+arr[i][j];
			}
		}
		
//		System.out.println();
//		for(int i = 0; i <= n;i++) {
//			for(int j = 0; j <= n;j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
		solve();
		
		System.out.println(sb);
	}

	private static void solve() throws IOException {
		int x1,y1,x2,y2;
		for(int i = 0; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append((dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]) + "\n");
		}
		
		
	}


}
