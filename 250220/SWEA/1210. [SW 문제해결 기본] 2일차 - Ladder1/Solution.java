import java.io.*;
import java.util.*;
 
public class Solution {
	static int finalResult;
	static int[][] map;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        
        for (int k = 0 ; k < 10 ; k++) {
        	int T = Integer.parseInt(br.readLine());
        	map = new int[100][100];
        	visited = new boolean[100][100];
        	int startRow = 0;
        	int startCol = 0;
        	for (int i = 0 ; i < 100 ; i++) {
        		String[] input = br.readLine().split(" ");
        		for (int j = 0 ; j < 100 ; j++) {
        			map[i][j] = Integer.parseInt(input[j]);
        			if (map[i][j] == 2) {
        				startRow = i;
        				startCol = j;
        			}
        		}
        	}
        	
        	finalResult = 0;
        	bfs(startRow, startCol);
        	System.out.printf("#%d %d\n", T, finalResult);
        }

    }
	private static void bfs(int startRow, int startCol) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startRow, startCol});
		visited[startRow][startCol] = true;
		
		int[] dRow = {0, 0, -1};
		int[] dCol = {1, -1, 0}; // 좌우 먼저, 밑으로 내려가는 경우는 없음
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int currentRow = node[0];
			int currentCol = node[1];
			
			if (currentRow == 0) { 
				finalResult = currentCol;
				return;
			}
			
			boolean moved = false;
			for (int i = 0 ; i < 3 ; i++) {
				int nextRow = currentRow + dRow[i];
				int nextCol = currentCol + dCol[i];
				
				if (nextRow >= 0 && nextRow < 100 && nextCol >= 0 && nextCol < 100 && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1 && !moved) {
					if (i == 0 || i == 1) { // 좌우를 먼저 이동했을 경우 위로는 가지 않음
						moved = true;
					}
					visited[nextRow][nextCol] = true;
					queue.offer(new int[] {nextRow, nextCol});
				}
			}
		}
		
	}
}
