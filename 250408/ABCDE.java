import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABCDE {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static List<Integer>[] adj;
	static boolean[] visited;
	static boolean isPossible=false;
	
	static void dfs(int node , int cnt) {
		if(cnt==4 || isPossible) {
			isPossible=true;
			return;
		}

		
		for(int i=0;i<adj[node].size();i++) {
			int n = adj[node].get(i);
			if(visited[n])continue;
			visited[n] = true;
			dfs(n, cnt+1);
			visited[n] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new List[N];
		
		for(int i=0;i<N;i++) {
			adj[i] = new ArrayList<>();
			
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s].add(e);
			adj[e].add(s);
		}
		

		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			visited[i]=true;
			dfs(i,0);
			if(isPossible)break;
		}
		
		if(isPossible) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
	}
	
}
