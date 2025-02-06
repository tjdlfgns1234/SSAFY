import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main
{
	static int[][] board;
	static boolean[][] visit;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
    public static void main(String args[]) throws Exception
    {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	int K, x, y, result;
    	
    	for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			visit = new boolean[N][M];
			result = 0;
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st2.nextToken());
				y = Integer.parseInt(st2.nextToken());
				
				board[x][y] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j] == 1 && !visit[i][j]) {
						result += 1;
						visit[i][j] = true;
						bfs(i, j);
								
					}
				}
				
			}
			System.out.println(result);
		}
    
    }
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
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
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					if(board[nx][ny] == 1 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new Point(nx, ny));
						
					}
				}
			}
			
		}
		
	}
}
