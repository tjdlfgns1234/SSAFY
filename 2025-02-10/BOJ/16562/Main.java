import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Cost implements Comparable<Cost>{
		int person, fee;
		public Cost(int person, int fee) {
			this.person = person;
			this.fee = fee;
		}
		
		@Override
		public int compareTo(Cost o) {
			return this.fee - o.fee;

		}
	}
	
	static int N, M, K;
	static boolean[][] graph;
	static boolean[] visited;
	static Cost[] costs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		costs = new Cost[N]; 
		visited = new boolean[N+1];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = new Cost(i+1, Integer.parseInt(st2.nextToken()));
		}
		
		
		int a, b;
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st3.nextToken());
			b = Integer.parseInt(st3.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		Arrays.sort(costs);
		
		int result = 0;
		boolean flag = false; 
		
		for (int i = 0; i < N; i++) {
			if(!visited[costs[i].person]) {
				bfs(costs[i].person);
				result += costs[i].fee;
			}
			
			if(check()) {
				flag = true;
				break;
			}
		}
		
		if(!flag || result > K) {
			System.out.println("Oh no");
		}
		else {
			System.out.println(result);
		}
		
	}
	private static boolean check() {
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx] = true;
		
		int x;
		while(!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i < N; i++) {
				if(graph[x][i+1] && !visited[i+1]) {
					visited[i+1] = true;
					q.add(i+1);
				}
			}
		}
	}
	
}
