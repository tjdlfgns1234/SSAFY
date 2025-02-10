import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine()); // 수영장의 크기
            int[][] map = new int[n][n];
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            String[] input3 = br.readLine().split(" ");
            int c = Integer.parseInt(input3[0]);
            int d = Integer.parseInt(input3[1]);

            search(n, map, visited, a, b, c, d, k + 1);
        }
    }

    private static void search(int n, int[][] map, boolean[][] visited, int a, int b, int c, int d, int t) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int result = bfs(n, map, visited, a, b, c, d, dx, dy);
        System.out.printf("#%d %d\n", t, result);
    }

	private static int bfs(int n, int[][] map, boolean[][] visited, int a, int b, int c, int d, int[] dx, int[] dy) {
		visited[a][b] = true;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {a, b, 0});
		int result = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0 ; k < size ; k++) {
				int[] node = queue.poll();
				int x = node[0];
				int y = node[1];
				int time = node[2];
				
				if (x == c && y == d) {
					result = time;
					return result;
				}
				
				for (int i = 0 ; i < 4 ; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nextTime = time + 1;
					
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && (map[nx][ny]!=1)) {
						if (map[nx][ny] == 2 && nextTime%3!=0) {
							nx = x;
							ny = y;
						}
						queue.offer(new int[] {nx, ny, nextTime});
						visited[nx][ny] = true;
					}
				}
			}
		}
		if (result == 0) {
			result = -1;
		}
		return result;
	}
}
