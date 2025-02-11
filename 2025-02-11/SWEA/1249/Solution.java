import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] board;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			dist = new int[n][n];
			visited = new boolean[n][n];
			
			String temp;
			for (int i = 0; i < n; i++) {
				temp = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = temp.charAt(j) - '0';
				}
			}
			
			bfs(0,0);
			
			System.out.printf("#%d %d",t,dist[n-1][n-1]);
			
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		Point temp;
		int nx, ny;
		while(!q.isEmpty()) {
			temp = q.poll();
			x = temp.x;
			y = temp.y;
			for (int i = 0; i <4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx == 0 && ny == 0) continue;
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				
				if(!visited[nx][ny]) {
					dist[nx][ny] = dist[x][y] + board[nx][ny];
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
				else {
					if(dist[nx][ny] > dist[x][y] + board[nx][ny]){
						dist[nx][ny] = dist[x][y] + board[nx][ny];
						
						q.add(new Point(nx, ny));
					}
				}
				
			}
			
		}
		
	}
	
}

