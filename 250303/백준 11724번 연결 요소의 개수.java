package main;

import java.io.*;
import java.util.*;

public class test {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int ans = 0;
	static int n,m;
	static boolean[] vit = new boolean[1001];
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <=n;i++)
			arr.add(new ArrayList<>());
		
		int x,y;
		for(int i = 0; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		
		solve();
		
		System.out.print(ans);
	}
	public static void solve() {	
		for(int i = 1;i <= n;i++) 
			if(!vit[i])
				bfs(i);
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		vit[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i = 0; i < arr.get(curr).size();i++) {
				if(!vit[arr.get(curr).get(i)]) {
					vit[arr.get(curr).get(i)] = true;
					q.offer(arr.get(curr).get(i));
				}
			}
		}
		ans++;
		
	}
}
