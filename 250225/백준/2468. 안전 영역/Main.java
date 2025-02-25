import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxVal = 0;
        for (int i = 0 ; i < N ; i++) {
        	String[] input = br.readLine().split(" ");
        	for (int j = 0 ; j < N ; j++) {
        		map[i][j] = Integer.parseInt(input[j]);
        		if (map[i][j] > maxVal) {
        			maxVal = map[i][j];
        		}
        	}
        }
        
        int result = 0;
        for (int k = 0 ; k < maxVal ; k++) {
        	visited = new boolean[N][N];
        	int temp = 0;
        	for (int i = 0 ; i < N ; i++) {
        		for (int j = 0 ; j < N ; j++) {
        			if (map[i][j] > k && !visited[i][j]) {
        				bfs(i, j, k);
        				temp++;
        			}
        		}
        	}
        	if (temp > result) {
        		result = temp;
        	}
        }
        System.out.println(result);
        
    }

	private static void bfs(int a, int b, int K) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {a, b});
		
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int row = node[0];
			int col = node[1];
			
			for (int i = 0 ; i < 4 ; i++) {
				int nRow = row + dx[i];
				int nCol = col + dy[i];
				
				if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < N && map[nRow][nCol]>K && !visited[nRow][nCol]) {
					queue.offer(new int[] {nRow, nCol});
					visited[nRow][nCol] = true;
				}
			}
		}
	}
}
