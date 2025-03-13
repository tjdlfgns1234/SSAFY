import java.io.*;
import java.util.*;

class Node{
	int en;
	int weight;
	
	Node(int en, int weight) {
		this.en = en;
		this.weight = weight;
	}
}

public class Main {
	static ArrayList<Node>[] nodes;
	static int N;
	static int X;
	static int max;
	static int[] targetToHome;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		max = 0;
		
		nodes = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodes[sn].add(new Node(en, weight));
		}
		dijkstra(X, 0, true);
		for(int i=1; i<=N; i++) {
			if(i==X) continue;
			max = Math.max(dijkstra(i, 0, false), max);
		}
		System.out.println(max);
	}
	
	
	public static int dijkstra(int sn, int target, boolean save) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[sn] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			return o1[1] - o2[1];
		});
		pq.add(new int[] {sn, 0});
		
		while(!pq.isEmpty()) {
			int[] top = pq.poll();
			int vertex = top[0];
			int distance = top[1];
			if(dist[vertex] < distance)
				continue;
			for(Node n : nodes[vertex]) {
				if(dist[n.en] > dist[vertex] + n.weight) {
					dist[n.en] = dist[vertex] + n.weight;
					pq.add(new int[] {n.en, dist[n.en]});
				}
			}
		}
		
		if(save)
			targetToHome = dist;
		return targetToHome[sn]+dist[X];
	}
}
