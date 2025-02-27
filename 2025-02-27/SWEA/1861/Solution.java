import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	
	static int N, result_num, result_cnt;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result_num = Integer.MAX_VALUE; 
			result_cnt = 0;
			int temp;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp = bfs(i, j);
					if(result_cnt <= temp) {
						if(result_cnt < temp) {
							result_cnt = temp;
							result_num = map[i][j];
						}
						else {
							result_num = Math.min(result_num, map[i][j]);
						}
						
						
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, result_num, result_cnt);
		}
		
	}
	private static int bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x,y));
		
		int nx, ny;
		int now_num = map[x][y];
		int cnt = 1;
		Point p;
		while(!q.isEmpty()) {
			p = q.poll();
			x = p.x;
			y = p.y;
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(map[nx][ny] == now_num + 1) {
					q.add(new Point(nx, ny));
					now_num += 1;
					cnt += 1;
					break;
				}
			}
		}
		
		return cnt;
	}

}
