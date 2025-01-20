import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] dx = {-1,  0,  1, 1, 1, 0, -1, -1};
	static int[] dy = {-1, -1, -1, 0, 1, 1,  1,  0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n, m;
		int[][] board;
		int x, y, stone;
		int b_cnt, w_cnt;
		for(int t = 1; t < T + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			board = new int[n][n];
			// 1: black, 2: white			
			board[n/2][n/2] = 2;
			board[n/2][n/2-1] = 1;
			board[n/2-1][n/2] = 1;
			board[n/2-1][n/2-1] = 2;
			
			b_cnt = 0;
			w_cnt = 0;
			
			for(int i = 0; i < m; i++) {
				StringTokenizer numst = new StringTokenizer(br.readLine());
				x = Integer.parseInt(numst.nextToken());
				y = Integer.parseInt(numst.nextToken());
				stone = Integer.parseInt(numst.nextToken());
				board[y-1][x-1] = stone;
				board = change(y-1, x-1, board, stone, n);
			}
			
			b_cnt = cnt_board(board,n, 1);
			w_cnt = cnt_board(board,n, 2);
			System.out.printf("#%d %d %d\n", t, b_cnt, w_cnt);
			board = null;
		}
	}
	
	// 1: black, 2: white
	public static int[][] change(int nx, int ny, int[][] temp_list, int color, int n) {
		int temp_x, temp_y;
		for (int i = 0; i < 8; i++) {
			if (check(nx, ny, temp_list, color, dx[i], dy[i], n) == true) {
				temp_x = nx;
				temp_y = ny;
				while (true) {
					temp_x += dx[i];
					temp_y += dy[i];
					if (temp_list[temp_x][temp_y] == color) {
						break;
					}
					temp_list[temp_x][temp_y] = color;
				}
			}
		}
		return temp_list;
	}
	
	public static boolean check(int nx, int ny, int[][] temp_list, int color, int dire_x, int dire_y, int n) {

		if ((0 <= nx + dire_x && nx + dire_x < n) && (0 <= ny + dire_y && ny + dire_y < n)) {
			while(true) {
				nx += dire_x;
				ny += dire_y;
				if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
					if (temp_list[nx][ny] == 0) {
						return false;
					}
					else {
						if (temp_list[nx][ny] == color) {
							return true;
						}
						else {
							continue;
						}
					}
					
				}
				else {
					return false;
				}
				
				
			}
				
		}
		return false;
	}

	public static int cnt_board(int[][] temp_list, int n, int color) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(temp_list[i][j] == color) {
					cnt ++;
				}
			}
		}
		
		return cnt;
	}
}
