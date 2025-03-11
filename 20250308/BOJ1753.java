import java.util.*;
import java.io.*;

class Vertex {
	int e, w;
	Vertex(int e, int w) {
		this.e = e;
		this.w = w;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] dist = new int[V+1];
		boolean[] v = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int sn = Integer.parseInt(st.nextToken());
		dist[sn] = 0;
		
		ArrayList<Vertex>[] adjMat = new ArrayList[V+1];
		
		for(int i=1; i<V+1; i++) {
			adjMat[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjMat[s].add(new Vertex(e, w));
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b)->a.w-b.w);
		pq.add(new Vertex(sn, 0));
		
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			int curV = cur.e;
			if(v[curV]) continue;
			v[curV] = true;
			
			for(Vertex next : adjMat[curV]) {
				if(dist[curV] + next.w < dist[next.e]) {
					dist[next.e] = dist[curV] + next.w;
					pq.add(new Vertex(next.e, dist[next.e]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			System.out.println(dist[i]==Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
}
