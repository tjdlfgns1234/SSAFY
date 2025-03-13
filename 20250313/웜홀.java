import java.io.*;
import java.util.*;

class Edge {
	int sn, en;
	int weight;
	Edge(int sn, int en, int weight) {
		this.sn = sn;
		this.en = en;
		this.weight = weight;
	}
}

public class Main {
	static Edge[] e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			int hole = Integer.parseInt(st.nextToken());
			
			HashSet< Integer> set = new HashSet<>();
			
			e = new Edge[edge*2+hole];
			for(int i=0; i<edge*2; i+=2) {
				st = new StringTokenizer(br.readLine());
				int sn = Integer.parseInt(st.nextToken());
				int en = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				e[i] = new Edge(sn,en,weight);
				e[i+1] = new Edge(en, sn, weight);
			}
			for(int i=edge*2; i<edge*2+hole; i++) {
				st = new StringTokenizer(br.readLine());
				int sn = Integer.parseInt(st.nextToken());
				e[i] = new Edge(sn,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())*-1);
				set.add(sn);
			}
			
			int[] dist = new int[node+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Iterator<Integer> it = set.iterator();
			
			boolean flag = false;
			while(it.hasNext()) {
				dist[it.next()] = 0;
				for(int i=0; i<node; i++) {
					for(int j=0; j<edge*2+hole; j++) {
						if(dist[e[j].sn]!=Integer.MAX_VALUE && dist[e[j].sn]+e[j].weight < dist[e[j].en]) {
							if(i==node-1)
								flag = true;
							dist[e[j].en] = dist[e[j].sn]+e[j].weight;
						}
					}
				}
			}
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
