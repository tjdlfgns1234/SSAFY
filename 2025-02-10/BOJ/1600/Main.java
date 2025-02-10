import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Path{
		int x, y, cnt, horse_cnt;
		public Path(int x, int y, int cnt, int horse_cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.horse_cnt = horse_cnt;
		}
	}
	static int W, H;
	static int[][] board;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[] horse_dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] horse_dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		// 각 index는 말이 뛴 횟수때 지나간 루트 
		visited = new boolean[H][W][k+1];
		
		for (int i = 0; i < H; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		

		int result;
		result = bfs(0, 0, 0, k);
		System.out.println(result);
		
	}
	private static int bfs(int x, int y, int cnt, int horse_cnt) {
		Queue<Path> q = new LinkedList<>();
		q.add(new Path(x, y, cnt, horse_cnt));
		Path path; 
		visited[x][y][horse_cnt] = true;
		while(!q.isEmpty()) {
			path = q.poll();
			x = path.x;
			y = path.y;
			cnt = path.cnt;
			horse_cnt = path.horse_cnt;
			
			if (x == H - 1 && y == W - 1) {
				return cnt;
			}
			
			int nx, ny;
			
			
			if(horse_cnt > 0) {
				for (int i = 0; i < 8; i++) {
					nx = x + horse_dx[i];
					ny = y + horse_dy[i];
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					
					// 내가 놓친 부분
					if(visited[nx][ny][horse_cnt-1]) continue;
					
					if(board[nx][ny] == 0 && !visited[nx][ny][horse_cnt]) {
						q.add(new Path(nx, ny, cnt + 1, horse_cnt -1));
						visited[nx][ny][horse_cnt - 1] = true;
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
				
				if(board[nx][ny] == 0 && !visited[nx][ny][horse_cnt]) {
					q.add(new Path(nx, ny, cnt + 1, horse_cnt));
					
					visited[nx][ny][horse_cnt] = true;
				}
			}
			
			// 말이 방문한 다음 뒤로가는거 생가하기
			
			
		}
		return -1;
		
	}
	
}
