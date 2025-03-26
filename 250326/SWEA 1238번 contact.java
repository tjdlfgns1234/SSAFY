import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static final int INF = 987654321;
	static int vit[];
	static int n,start, ans = 0;
	static ArrayList<ArrayList<Integer>> arr;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t= 10;
		// t= 1;
		for(int testcase = 1; testcase<= t;testcase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList<>();
			for(int i = 0; i <= 100;i++)
				arr.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			vit= new int[101];
			
			for(int i = 0; i <= 100;i++)
				vit[i] = INF;
			
			int from, to;
			for(int i = 0; i < n/2;i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				// 단방향 처리
				arr.get(from).add(to);
			}
			
			solve();
		
			System.out.println("#" + testcase + " " + ans);
		}
		
	
		
		
	}

	private static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
			
		vit[start] = 0;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < arr.get(cur).size();i++) {
				int next = arr.get(cur).get(i);
				if(vit[next] == INF) {
					vit[next] = vit[cur] + 1; 
					q.add(next);
				}
			}
		}
		
		int v = 0;
		for(int i = 100; i >= 0;i--) 
			if(vit[i]!= INF) 
				if(vit[i] > v) {
					ans = i;
					v = vit[i];
			}
	}
}