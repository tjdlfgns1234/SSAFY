import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int[][] board = new int[9][9];
			int result = 1;
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if (block_check(board,i * 3,j * 3) == false || row_check(board, i * 3) == false || col_check(board, j * 3) == false) {
						result = 0;
						break;
					}
					
				}
				if (result == 0) {
					break;
				}
			}
			System.out.printf("#%d %d\n", t+1, result);
		}
	}
	static boolean block_check(int[][] arr, int x, int y) {
		boolean[] check = new boolean[10];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				check[arr[y+i][x+j]] = true;
			}
		}
		for(int i = 1; i < 10; i++) {
			if (check[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	static boolean row_check(int[][] arr, int y) {
		boolean[] check = new boolean[10];
		for(int i = 0; i < 9; i++) {
			check[arr[y][i]] = true;
		}
		for(int i = 1; i < 10; i++) {
			if (check[i] == false) {
				return false;
			}
		}
		return true;
	}

	static boolean col_check(int[][] arr, int x) {
		boolean[] check = new boolean[10];
		for(int i = 0; i < 9; i++) {
			check[arr[i][x]] = true;
		}
		for(int i = 1; i < 10; i++) {
			if (check[i] == false) {
				return false;
			}
		}
		return true;
	}
	
}
