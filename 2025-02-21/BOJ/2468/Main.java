import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	
	static int N, result, max_height = 0;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int temp;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(max_height < temp) {
					max_height = temp;
				}
			}
		}
		
		// 비온 높이가 0일때
		result = 1;
		
		for (int i = 1; i < max_height; i++) {
			check(i, new boolean[N][N]);
		}
		
		System.out.println(result);
		
	}
	private static void check(int height, boolean[][] visit) {
		int temp_result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > height && !visit[i][j]) {
					bfs(i, j, visit, height);
					temp_result += 1;
				}
			}
		}
		if(result < temp_result) result = temp_result;
	}
	private static void bfs(int x, int y, boolean[][] visit, int height) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		Point p;
		int nx, ny;
		while(!q.isEmpty()) {
			p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(!visit[nx][ny] && map[nx][ny] > height) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
						
			}
			
		}
		
	}
	
}
