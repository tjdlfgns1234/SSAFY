package test;

import java.io.*;
import java.util.*;

public class 친구비 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,k;
	static List<Integer>[] l;
	static int[] visited;
	static int[] A;
	static Long result=0L;
	
	static int dfs(int node) {
		visited[node]=1;
		int result = A[node];
		for(int i=0;i<l[node].size();i++) {
			int n = l[node].get(i);
			if(visited[n]==1)continue;
			result = Math.min(result, dfs(n));
		}
		
		return result;
	}
	
	
	public static void main(String[] args)throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		l = new List[N+1];
		visited = new int[N+1];
		
		for(int i=0;i<l.length;i++) {
			l[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			l[v].add(w);
			l[w].add(v);
		}
		
		Long result=0L;
		for(int i=1;i<=N;i++) {
			if(visited[i]==1)continue;
			result+=dfs(i);
		}
		
		if(result>k) {
			System.out.println("Oh no");
		}
		else {
			System.out.println(result);
		}
			
	}
}
