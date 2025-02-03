import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	
	static int[][] map;
	static boolean[][] visited;
	static int N, M, result;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	if(N == 0 && M == 0) break;
        	
        	map = new int[M][N];
        	visited = new boolean[M][N];
        	result = 0;
        	
        	for (int i = 0; i < M; i++) {
        		StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
        	
        	for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						result += 1;
					}
				}
			}
        	System.out.println(result);
        }
	}
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		int x, y, nx, ny;
		Point p;
		while(!q.isEmpty()) {
			p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int k = 0; k < 8; k++) {
				nx = x + dx[k];
				ny = y + dy[k];
				if(0 <= nx && nx < M && 0 <= ny && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		
	}
	
    
    
}
