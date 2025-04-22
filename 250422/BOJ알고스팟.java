import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class BOJ알고스팟 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int minCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int m = Integer.parseInt(line[0]);
		int n = Integer.parseInt(line[1]);
		
		int[][] map = new int[n][m];
		
		for(int i = 0;i < n ;i++) {
			String lines = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = lines.charAt(j) - '0';
			}
		}
		
		//setting
		int cx = 0;
		int cy = 0;
		
		int destX = n-1;
		int destY = m-1;
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			return Integer.compare(map[o1[0]][o1[1]], map[o2[0]][o2[1]]);
		});
		int[][] v = new int[n][m];
		for(int i = 0;i < n; i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE);
		}
		
		v[0][0] = 0;
		queue.offer(new int[] {cx, cy});
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			cx = pos[0];
			cy = pos[1];
			for(int d = 0; d < 4; d++) {
				int nx = cx + dx[d], ny = cy + dy[d];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(v[cx][cy] + map[nx][ny] < v[nx][ny]) {
						v[nx][ny] = v[cx][cy] + map[nx][ny];
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
//		for(int i = 0;i < n; i++) {
//			System.out.println(Arrays.toString(v[i]));
//		}
		
		System.out.println(v[n-1][m-1]);
		
		
		
	}

}