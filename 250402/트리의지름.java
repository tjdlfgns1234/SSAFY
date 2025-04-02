import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {
	
	static class pair{
		int e=0;
		int w=0;
		public pair(int e , int w) {
			this.e=e;
			this.w=w;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static List<pair>[] adj;
	static boolean[] visit;
	static int firstMaxNode=9;
	static int firstValue=0;
	static int value=0;
	
	static void dfs(int node , boolean fir , int size) {
		
		boolean ischeck=false;
		for(int i=0;i<adj[node].size();i++) {
			pair p = adj[node].get(i);
			if(visit[p.e])continue;
			ischeck=true;
			visit[p.e]=true;
			dfs(p.e , fir,size+p.w);
		}
		
		if(!ischeck) {
			if(fir && firstValue<size){
				firstMaxNode=node;
				firstValue = size;
			}
			else{
				value = Math.max(size, value);
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		adj = new List[N+1];
		
		if(N==1) {
			System.out.println(0);
			return;
		}
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new pair(e, w));
			adj[e].add(new pair(s, w));
		}
		
		
		//first
		visit = new boolean[N+1];
		visit[1]=true;
		dfs(1 , true , 0);
		//second
		visit = new boolean[N+1];
		visit[firstMaxNode]=true;
		dfs(firstMaxNode , false , 0);

		
		System.out.println(value);
	}
	
}
