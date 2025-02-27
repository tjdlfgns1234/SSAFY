import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정사각형방_1861 {
	
	static int N, max, maxValue;
	static int[][] map;
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
					bfs(i, j);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(maxValue).append(" ").append(max);
			System.out.println(sb);
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c));
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		int count = 0;
		int value = map[r][c];
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			++count;
			
			for (int d=0; d<4; ++d) {
				int nextR = curr.r + dr[d];
				int nextC = curr.c + dc[d];
				if (isValid(nextR, nextC) && !visited[nextR][nextC] && map[curr.r][curr.c]+1 == map[nextR][nextC]) {
					visited[nextR][nextC] = true;
					q.add(new Point(nextR, nextC));
				}
			}
		}
		
		if (count == max) {
			maxValue = Math.min(value, maxValue);
		}
		else if (count > max) {
			max = count;
			maxValue = value;
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
