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
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static int[][] dist;
	static int N, M, result;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Queue<Point> q = new LinkedList<>();
        map = new int[N][M];
        int temp;
        for (int i = 0; i < N; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				temp = Integer.parseInt(st2.nextToken());
				map[i][j] = temp;
				if (temp == 1) {
					q.add(new Point(i, j));
				}
				
			}
		}
       
        
        bfs(q);
        
        if(check()) {
        	System.out.println(result - 1);
        }
        else {
        	System.out.println(-1);
        }
        
    }
    private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
			
		}
		return true;
	}
    
	public static void bfs(Queue<Point> q) {
		int nx, ny, x, y, size;
		Point p;
		
		while(!q.isEmpty()) {
			result += 1;
			size = q.size();
			for(int i = 0; i < size; i++) {
				p = q.poll();
				x = p.x;
				y = p.y;
				for (int j = 0; j < 4; j++) {
					nx = x + dx[j];
					ny = y + dy[j];
					if(0<= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new Point(nx, ny));
					}
				}
			}
			
		}
		
	}
	
    
    
}
