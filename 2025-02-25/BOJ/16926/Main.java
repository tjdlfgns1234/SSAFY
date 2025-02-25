import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R;
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			turn();
		}
		
		print();
		
	}
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void turn() {
		int u_l;
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			u_l = map[i][i];
			
			//위
			for (int j = i+1; j < M - i; j++) {
				map[i][j-1] = map[i][j];
			}
			
			// 오른
			for (int j = i+1; j < N - i; j++) {
				map[j-1][M-1-i] = map[j][M-1-i];
			}
			
			//아래
			for (int j = M-1-i; j > i; j--) {
				map[N-1-i][j] = map[N-1-i][j-1]; 
			}
			
			//왼
			for (int j = N-1-i; j > i+1; j--) {
				map[j][i] = map[j-1][i];
			}
			map[i+1][i] = u_l;
			
		}
	}
}
