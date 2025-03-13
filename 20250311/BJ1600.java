
import java.util.*;
import java.io.*;

class Monkey {
	int x, y;
	int horse;
	int cnt;
	
	Monkey(int x, int y, int horse, int cnt) {
		this.x = x;
		this.y = y;
		this.horse = horse;
		this.cnt = cnt;
	}
}

public class BJ1600 {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] jumpX = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] jumpY = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	static void bfs() {
		boolean[][][] v = new boolean[K+1][H][W];
		Queue<Monkey> q = new ArrayDeque<>();
		int x = 0;
		int y = 0;
		q.add(new Monkey(x, y, K, 0));
		v[0][y][x] = true;
		
		while(!q.isEmpty()) {
			Monkey tmp = q.poll();
			if(tmp.x == W-1 && tmp.y == H-1) {
				min = Math.min(min, tmp.cnt);
				break;
			}
			
			for(int d=0; d<4; d++) {
				int tx = tmp.x + dx[d];
				int ty = tmp.y + dy[d];
				
				if(tx<0 || tx>=W || ty<0 || ty>=H || v[tmp.horse][ty][tx] || map[ty][tx] == 1)
					continue;
				v[tmp.horse][ty][tx] = true;
				q.add(new Monkey(tx, ty, tmp.horse, tmp.cnt+1));
			}
			if(tmp.horse == 0)
				continue;
			
			for(int d=0; d<8; d++) {
				int tx = tmp.x + jumpX[d];
				int ty = tmp.y + jumpY[d];
				
				if(tx<0 || tx>=W || ty<0 || ty>=H || v[tmp.horse-1][ty][tx] || map[ty][tx] == 1)
					continue;
				v[tmp.horse-1][ty][tx] = true;
				q.add(new Monkey(tx, ty, tmp.horse-1, tmp.cnt+1));
			}
		}
	}
}
