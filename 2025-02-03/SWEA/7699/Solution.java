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
	static char[][] map;
	static int result = 0;
	static int max_cheese, R, C;
    public static void main(String args[]) throws Exception
    {	
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t < T+1; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			String temp;
			max_cheese = 0;
			result = 0;
			for (int i = 0; i < R; i++) {
				temp = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			
			boolean[] alpha_check = new boolean[26];
			alpha_check[map[0][0] - 'A'] = true;
			dfs(0, 0, 1, alpha_check);
			
			System.out.printf("#%d %d\n",t, result);
			
			
			
		}
    }
    static void dfs(int x, int y, int temp_result, boolean[] alpha_check) {
    	if(result < temp_result) {
    		result = temp_result;
    	}
    	
    	int nx, ny;
    	for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(0 <= nx && nx < R && 0 <= ny && ny < C && !alpha_check[map[nx][ny] - 'A']) {
				alpha_check[map[nx][ny] - 'A'] = true;
				dfs(nx, ny, temp_result+1, alpha_check );
				alpha_check[map[nx][ny] - 'A'] = false;
			}
		}
    	
    }

}
