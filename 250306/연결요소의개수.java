package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static List<Integer> l[];
	static int[] visited;
	
	static void dfs(int node) {
		visited[node]=1;
		for(int i=0;i<l[node].size();i++) {
			int n = l[node].get(i);
			if(visited[n]==1)continue;
			dfs(n);
		}
	}
	
	public static void main(String[] args)throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		l = new List[N+1];
		visited = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			l[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			l[s].add(e);
			l[e].add(s);
		}
		int count=0;
		for(int i=1;i<=N;i++) {
			if(visited[i]==1)continue;
			dfs(i);
			count++;
		}
		
		System.out.println(count);
	}
}
