import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	static final int INF = 987654321;
	static int vit[];
	static int n,m, ans = 0;
	static int p[];
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t= 10;
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		for(int testcase = 1; testcase<= t;testcase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			p = new int[n+1];
			sb = new StringBuilder();
			init();

			int x, y, z;
			for(int i = 0; i < m;i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());
				
				
				if(x == 0) {
					// 합집합 연산
					union(y,z);
				}
				if(x == 1) {
					// find 연산
					if(find(y) == find(z))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			
		
			System.out.println("#" + testcase + " " + sb);
		}
		
	
		
		
	}
	private static void init() {
		for(int i = 1; i < n+1;i++) p[i] = i;
	}
	private static int find(int x) {
		
		if(x == p[x])
			return x;
		
		return x = find(p[x]);
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)
			return false;
		
		if(x > y) 
			p[x] = y;
		else
			p[y] = x; 
		
		return true;
	}
}