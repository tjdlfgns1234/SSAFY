import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static boolean[][] check;
	static int result;
	static int max_cheese;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t < T+1; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int temp = 0;
			max_cheese = 0;
			result = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					if (max_cheese < temp) max_cheese = temp;
					map[i][j] = temp;
				}
			}
			
			for (int i = 0; i <= max_cheese+1; i++) {
				check = new boolean [N][N];
				temp = 0;
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(map[j][k] > i && !check[j][k]) {
							bfs(j, k, i, N);
							temp += 1;
						}
					}
				}
				
				if (result < temp) {
					result = temp;
				}
			}
			System.out.printf("#%d %d\n",t, result);
			
			
			
		}
    }
    static void bfs(int x, int y, int limit, int N) {
    	Queue<Point> q = new LinkedList<Point>();
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
    			if(0 <= nx && nx < N && 0 <= ny && ny < N && !check[nx][ny] && map[nx][ny] > limit) {
    				check[nx][ny] = true;
    				q.add(new Point(nx, ny));
    			}
			}
    		
    	}
    	
    	
    }

}
