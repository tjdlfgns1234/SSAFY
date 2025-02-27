import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방_1861_DP {
	static int N, max, maxValue;
	static int[][] map, dp;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	
	static class Point {
		int r;
		int c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			
			max = Integer.MIN_VALUE;
			maxValue = -1;
			
			for (int i=0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<N; ++i) {
				for (int j=0; j<N; ++j) {
					int cnt = recursive(i, j);
					if (max < cnt) {
						max = cnt;
						maxValue = map[i][j];
					}
					else if (max == cnt) {
						maxValue = Math.min(maxValue, map[i][j]);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(maxValue).append(" ").append(max);
			System.out.println(sb);
		}
	}
	
	public static int recursive(int r, int c) {
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		
		int count = 1;
		
		for (int d=0; d<4; ++d) {
			int nextR = r + dr[d];
			int nextC = c + dc[d];
			if (isValid(nextR, nextC) && map[r][c]+1 == map[nextR][nextC]) {
				count = 1 + recursive(nextR, nextC);
				break;
			}
		}
		
		return dp[r][c] = count;
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
