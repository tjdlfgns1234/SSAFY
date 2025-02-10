import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]); // 행
        int m = Integer.parseInt(input1[1]); // 열
        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];
		
        for (int i = 0 ; i < n ; i++) {
        	String[] input2 = br.readLine().split("");
        	for (int j = 0 ; j < m ; j++) {
        		map[i][j] = Integer.parseInt(input2[j]);
        	}
        }
        
        search(n, m, map, visited);
	}

	private static void search(int n, int m, int[][] map, boolean[][][] visited) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		bfs(n, m, map, visited, dx, dy);
	}

	private static void bfs(int n, int m, int[][] map, boolean[][][] visited, int[] dx, int[] dy) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 0, 0}); // 시작 좌표 x, y, 시간, 벽 부쉈는지 여부
		visited[0][0][0] = true;
		
		int result = 0;
		boolean ended = false;
		
		 while (!queue.isEmpty()) {
			 int[] node = queue.poll();
			 int x = node[0];
			 int y = node[1];
			 int t = node[2];
			 int able = node[3];
			 result = t;
			 
			 if (x == n-1 && y == m-1) {
				 ended = true;
				 System.out.println(result + 1); // 시작 칸 포함
				 break;
			 }
			 
			 for (int i = 0 ; i < 4 ; i++) {
				 int nx = x + dx[i];
				 int ny = y + dy[i];
				 int nt = t + 1;
				 int nAble = able;
				 
				 if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					 if (map[nx][ny] == 0 && !visited[nx][ny][nAble]) {
						 visited[nx][ny][nAble] = true;
						 queue.offer(new int[]{nx, ny, nt, nAble});
					 }
					 if (map[nx][ny] == 1 && nAble == 0 && !visited[nx][ny][1]) {
						 visited[nx][ny][1] = true;
						 queue.offer(new int[]{nx, ny, nt, 1});
					 }
				 }
			 }
		 }
		 
		 if (!ended) {
			 System.out.println(-1);
		 }
	}
}
