import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int k = 0 ; k < t; k++) {
        	int n = Integer.parseInt(br.readLine()); // 한 변
        	int[][] map = new int[n+1][n+1];
        	int maxVal = 0;
        	for (int i = 0 ; i < n ; i++) {
        		String[] input = br.readLine().split(" ");
        		for (int j = 0 ; j < n ; j++) {
        				map[i][j] = Integer.parseInt(input[j]);
        				if (map[i][j] > maxVal) {
        					maxVal = map[i][j];
        				}
        		}
        	}
        	
        	int result = search(n, map, maxVal);
        	if (result == 0) {
        		result = 1;
        	}
        	System.out.printf("#%d %d\n", k+1, result);
        	
//        	for (int i = 0 ; i < n ; i++) {
//        		for (int j = 0 ; j < n ; j++) {
//        			System.out.printf("%d ", map[i][j]);
//        		}
//        		System.out.println();
//        	}
        }
    }

	private static int search(int n, int[][] map, int maxVal) {
		final int[] dx = {1, -1, 0, 0};
		final int[] dy = {0, 0, 1, -1};
		int[] resultArr = new int[101];
		boolean[][] visited;
		int count;
		
		for (int i = 1 ; i <= maxVal ; i++) {
			count = 0;
			visited = new boolean[n+1][n+1];
			for (int x = 0 ; x < n ; x++) {
				for (int y = 0 ; y < n ; y++) {
					if (map[x][y] > i && !visited[x][y]) {
						bfs(x, y, n, map, dx, dy, i, visited);
						count++;
					}
				}
			}
			resultArr[i] = count;
		}
		
		int result = Integer.MIN_VALUE;
		for (int i = 1 ; i <= 100 ; i++) {
			if (result < resultArr[i]) {
				//System.out.println(resultArr[i]);
				result = resultArr[i];
			}
		}
		
		return result;
	}

	private static void bfs(int x, int y, int n, int[][] map, int[] dx, int[] dy, int i, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int cx = node[0];
			int cy = node[1];
			
			for (int k = 0 ; k < 4 ; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] > i) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
}
