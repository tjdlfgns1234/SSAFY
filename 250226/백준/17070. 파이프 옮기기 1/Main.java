import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N;
	static boolean[][] visited;
	static int result;
	static int[] dx = {0, 1, 1}; // 3방향만 탐색
	static int[] dy = {1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0 ; i < N ; i++) {
        	String[] input = br.readLine().split(" ");
        	for (int j = 0 ; j < N ; j++) {
        		map[i][j] = Integer.parseInt(input[j]);
        	}
        }
        result = 0;
        dfs(0, 1 , "H");
        System.out.println(result);
    }
    
	private static void dfs(int row, int col, String status) {
		if (row == N-1 && col == N-1) {
			result++;
			return;
		}
		
		if (status.equals("H")) { // 가로
			int nRow = row + 1;
			int nCol = col + 1;
			if (nCol < N && !visited[row][nCol] && map[row][nCol] != 1) { // 그대로 가로
				dfs(row, nCol, "H");
			}
			if (nRow < N && nCol < N && !visited[nRow][nCol]) { // 대각선
				if (check(row, col)) {
					dfs(nRow, nCol, "D");
				}
			}
		}
		if (status.equals("V")) {
			int nRow = row + 1;
			int nCol = col + 1;
			if (nRow < N && !visited[nRow][col] && map[nRow][col] != 1) { // 그대로 세로
				dfs(nRow, col, "V");
			}
			if (nRow < N && nCol < N && !visited[nRow][nCol]) { // 대각선
				if (check(row, col)) {
					dfs(nRow, nCol, "D");
				}
			}
		}
		
		if (status.equals("D")) {
			int nRow = row + 1;
			int nCol = col + 1;
			if (nCol < N && !visited[row][nCol] && map[row][nCol] != 1) { // 가로
				dfs(row, nCol, "H");
			}
			if (nRow < N && !visited[nRow][col] && map[nRow][col] != 1) { // 세로
				dfs(nRow, col, "V");
			}
			if (nRow < N && nCol < N && !visited[nRow][nCol]) { // 대각선
				if (check(row, col)) {
					dfs(nRow, nCol, "D");
				}
			}
		}
		
		//return;
	}
	private static boolean check(int row, int col) {
		int count = 0;
		for (int i = 0 ; i < 3 ; i++) {
			int sRow = row + dx[i];
			int sCol = col + dy[i];
			
			if (map[sRow][sCol] != 1) {
				count++;
			}
		}
		if (count == 3) {
			return true;
		}
		return false;
	}
}
