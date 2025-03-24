import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] arr;
	static boolean[][] v;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		sb.append(see());
		sb.append(" ");
		sb.append(nosee());
		
		System.out.println(sb);
	}
	
	public static int see() {
		v = new boolean[N][N];
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v[i][j]) {
					bfs_s(j, i, arr[i][j]);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void bfs_s(int x, int y, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		v[y][x] = true;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				
				if(tx<0 || tx>=N || ty<0 || ty>=N || v[ty][tx] || arr[ty][tx]!=c)
					continue;
				
				v[ty][tx] = true;
				q.add(new int[] {tx, ty});
			}
		}
	}
	
	public static int nosee() {
		v = new boolean[N][N];
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!v[i][j]) {
					bfs_n(j, i, arr[i][j]);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void bfs_n(int x, int y, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		
		v[y][x] = true;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				
				if(tx<0 || tx>=N || ty<0 || ty>=N || v[ty][tx])
					continue;
				if(arr[ty][tx]!=c) {
					if(c=='B'||arr[ty][tx]=='B')
						continue;
				}
				
				v[ty][tx] = true;
				q.add(new int[] {tx, ty});
			}
		}
	}
}
