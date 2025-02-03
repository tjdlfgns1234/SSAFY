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
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {1, -1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[][][] map;
	static int N, M, H, result;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        map = new int[H][N][M];
        int temp;
        
        for (int i = 0; i < H; i++) {
        	
			for (int j = 0; j < N; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					
					temp = Integer.parseInt(st2.nextToken());
//					System.out.println(i + " " + j + " " + k + " " + temp);
					map[i][j][k] = temp;
					if (temp == 1) {
						q.add(new int[] {i, j, k});
					}
					
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
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						return false;
					}
				}
				
			}
			
		}
		return true;
	}
    
	public static void bfs(Queue<int[]> q) {
		int nx, ny, nz, x, y, z, size;
		int[] p;
		
		while(!q.isEmpty()) {
			result += 1;
			size = q.size();
//			for (int i = 0; i < H; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.println(Arrays.toString(map[i][j]));
//				}
//			}
//			System.out.println();
			for(int i = 0; i < size; i++) {
				p = q.poll();
				x = p[0];
				y = p[1];
				z = p[2];
				for (int j = 0; j < 6; j++) {
					nx = x + dx[j];
					ny = y + dy[j];
					nz = z + dz[j];
					if(0<= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M && map[nx][ny][nz] == 0) {
						map[nx][ny][nz] = 1;
						q.add(new int[] {nx, ny, nz});
					}
				}
			}
			
		}
		
	}
	
    
    
}
