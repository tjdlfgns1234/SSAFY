import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static int[][] dist;
	static int N, start_x, start_y, end_x, end_y;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t < T+1; t++) {
        	N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st2.nextToken());
			start_y = Integer.parseInt(st2.nextToken());
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st3.nextToken());
			end_y = Integer.parseInt(st3.nextToken());
			
			
			bfs(start_x, start_y, new boolean[N][N]);
			
			if(dist[end_x][end_y] == 0) System.out.printf("#%d %d\n",t, -1); 
			else System.out.printf("#%d %d\n",t, dist[end_x][end_y]);
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			
		}
    }
    static void bfs(int x, int y, boolean[][] check) {    	
    	int nx, ny;
    	check[x][y] = true;
    	Queue<Point> q = new LinkedList<>();
    	q.add(new Point(x, y));
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		x = p.x;
    		y = p.y;
    		
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
			
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != 1) {
					if(dist[nx][ny] == 0) {
						if(map[nx][ny] == 0) {
							dist[nx][ny] = dist[x][y] + 1;
							q.add(new Point(nx, ny));
						}
						else {
							dist[nx][ny] = dist[x][y] + (3 - (dist[x][y] % 3));
							q.add(new Point(nx, ny));
						}
					}
					else {
						if(dist[nx][ny] < dist[x][y] + 1) {
							continue;
						}
						else {
							if(map[nx][ny] == 0) {
								dist[nx][ny] = dist[x][y] + 1;
								q.add(new Point(nx, ny));
							}
							else {
								dist[nx][ny] = dist[x][y] + (3 - (dist[x][y] % 3));
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}
    	
		}
    	
    }

}
