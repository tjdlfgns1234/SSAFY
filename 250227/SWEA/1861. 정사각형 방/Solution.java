import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int roomNum;
	static int canVisit;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 1 ; k <= T ; k++) {
        	N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	for (int i = 0 ; i < N ; i++) {
        		String[] input = br.readLine().split(" ");
        		for (int j = 0 ; j < N ; j++) {
        			map[i][j] = Integer.parseInt(input[j]);
        		}
        	}
        	roomNum = Integer.MAX_VALUE;
        	canVisit = Integer.MIN_VALUE;
        	search();
        	System.out.printf("#%d %d %d\n", k, roomNum, canVisit);
        }
    }
	private static void search() {
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				boolean[][] visited = new boolean[N][N];
				visited[i][j] = true;
				bfs(visited, i, j);
			}
		}
	}
	
	private static void bfs(boolean[][] visited, int a, int b) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {a, b, 1});
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int row = node[0];
			int col = node[1];
			int count = node[2];
			
			for (int i = 0 ; i < 4 ; i++) {
				int nRow = row + dx[i];
				int nCol = col + dy[i];
				int nCount = count + 1;
				
				if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && !visited[nRow][nCol]) {
					if (map[nRow][nCol] == map[row][col] + 1) {
						queue.offer(new int[] {nRow, nCol, nCount});
						visited[nRow][nCol] = true;
						if (nCount > canVisit) {
							roomNum = map[a][b];
							canVisit = nCount;
						} else if (nCount == canVisit) {
							if (roomNum > map[a][b]) {
								roomNum = map[a][b];
							}
						}
					}
				}
			}
		}
	}
}
