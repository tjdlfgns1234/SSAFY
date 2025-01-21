//오목문제
import java.util.Scanner;

public class Main {
	
	static int[] dx = {-1,  0,  1, 1};
	static int[] dy = {-1, -1, -1, 0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 19;
		int[] result = {0, 20, 20};
		int[] temp_result = {0, 20, 20};
		int[][] map = new int[n][n];
		// 지도 정보 입력 받기
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) {
					temp_result = win_check(i, j, map, n);
					if (temp_result[0] == 1 || temp_result[0] == 2) {
						if (temp_result[2] < result[2]) {
							result[1] = temp_result[1];
							result[2] = temp_result[2];
							result[0] = temp_result[0];
						}
					}
				}
			}
		}
		if (result[0] == 0) {
			System.out.println(0);
		}
		else {
			System.out.println(result[0]);
			System.out.printf("%d %d\n",result[1] + 1, result[2] + 1);
		}
		

	}
	public static int[] win_check(int x, int y, int[][]temp_list, int n) {
		int nx, ny;
		int cnt;
		int result_x = 20, result_y = 20;
		int[] result = new int[3];
		for(int i = 0; i < 4; i++) {
			nx = x;
			ny = y;
			cnt = 1;
			while(true) {
				if(0 <= nx + dx[i] && nx + dx[i] < n && 0 <= ny + dy[i] && ny + dy[i] < n) {
					nx += dx[i];
					ny += dy[i];
					if (temp_list[x][y] == temp_list[nx][ny]) {
						cnt += 1;
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			nx = x;
			ny = y;
			while(true) {
				if(0 <= nx - dx[i] && nx - dx[i] < n && 0 <= ny - dy[i] && ny - dy[i] < n) {
					nx -= dx[i];
					ny -= dy[i];
					if (temp_list[x][y] == temp_list[nx][ny]) {
						cnt += 1;
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			if (cnt == 5) {
				result[1] = x;
				result[2] = y;
				result[0] = temp_list[x][y];
			}
		}
		return result;
	}
}
