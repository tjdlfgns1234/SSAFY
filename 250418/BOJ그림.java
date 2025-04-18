import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;

class BOJ그림 {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int maxCnt = 0;
	static int num = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int[][] map = new int[n][m];
		for(int i = 0; i< n; i++) {
			line = br.readLine().split(" ");
			for(int j = 0; j< m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		boolean[][] v = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				Queue<int[]> queue = new ArrayDeque<>();
				
				int cnt = 0;
				if(!v[i][j] && map[i][j] == 1) {
					queue.offer(new int[] {i,j});
					v[i][j] = true;
					cnt++;
					num++;
					while(!queue.isEmpty()) {
						int[] pos = queue.poll();
						int cx = pos[0];
						int cy = pos[1];
						for(int k = 0; k < 4; k++) {
							int nx = cx + dx[k];
							int ny = cy + dy[k];
							if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !v[nx][ny]) {
								queue.offer(new int[] {nx,ny});
								v[nx][ny] = true;
								cnt++;
							}
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}

			}
		}
		
		System.out.println(num);
		System.out.println(maxCnt);
		
				
	}
}