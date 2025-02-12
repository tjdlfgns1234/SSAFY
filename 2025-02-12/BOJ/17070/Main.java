import java.io.*;
import java.util.*;

public class Main {
	
	static int n, result;
	static int[][] board;
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
				
		}
		result = 0;
		dfs(0, 1, 0);
		System.out.println(result);
	}
	private static void dfs(int x, int y, int dire) {
		
		if(x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) return;
		
		if(x == n-1 && y == n - 1) {
			result += 1;
			return;
		}
		
		if(dire == 0 || dire == 1) {
			dfs(x + dx[dire], y + dy[dire], dire);
		}
		else {
			dfs(x + dx[0], y + dy[0], 0);
			dfs(x + dx[1], y + dy[1], 1);
		}
		
		if(x+1 >= 0 && x + 1 < n && y + 1 >= 0 && y + 1 < n && board[x+1][y] != 1 && board[x][y+1] != 1) {
			dfs(x+1, y+1, 2);
		}
	}
	
}

