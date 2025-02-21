import java.util.*;
import java.io.*;

public class Solution {

	static int N,M,result;
	static boolean[] isSelected;
	static boolean[][] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isSelected = new boolean[N+1];
			check = new boolean[N+1][N+1];
			int a, b;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				check[a][b] = true;
				check[b][a] = true;
				
			}
			
			result = 0;
			gen_subset(1);
			System.out.printf("#%d %d\n",t, result);
		}

	}
	private static void gen_subset(int cnt) {
		if(cnt == N+1) {
			if(check()) {
				result += 1;
			}
			return;
		}
		
		
		isSelected[cnt] = true;
		gen_subset(cnt+1);
		isSelected[cnt] = false;
		gen_subset(cnt+1);
	}
	private static boolean check() {
		
		for (int i = 1; i < N; i++) {
			if(isSelected[i]) {
				for (int j = i+1; j < N+1; j++) {
					if(isSelected[j] && check[i][j]) return false;
				}
			}
		}
		
		return true;
	}

}
