import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int e, cost;
	
	Edge(){}
	
	Edge(int e, int cost) {
		this.e = e;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
	 return this.cost - o.cost; // 오름차순 정렬
	}
	
}

public class Main {
    static int n, m, s,e, cnt = 1;
    static ArrayList <ArrayList<Edge>> arr = new ArrayList<>();
    static int ans = 0;
    static int[] cost = new int[1001];
    static int[] idx = new int[1001];
    static final int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    m = Integer.parseInt(st.nextToken());
	    ans = 0;

	    for(int i = 0; i <= n;i++) {
	    	arr.add(new ArrayList<>());
	    	cost[i] = INF;
	    }
	    
	    int x, y, c;
	    for(int i = 0; i < m;i++) {
	    	st = new StringTokenizer(br.readLine());
	 	
	    	x = Integer.parseInt(st.nextToken());
	    	y = Integer.parseInt(st.nextToken());
	    	c = Integer.parseInt(st.nextToken());
	    	
	    	arr.get(x).add(new Edge(y,c));
	    }
	 	st = new StringTokenizer(br.readLine());
	    
    	s = Integer.parseInt(st.nextToken());
    	e = Integer.parseInt(st.nextToken());
	 	
	    solve();
		  
	    System.out.print(sb);
	    
    }

    public static void solve() throws IOException {
       // 자바는 min-heap
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
	  //  PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);	
    	
    	
    	pq.add(new Edge(s,0));
    	cost[s] = 0;
    	while(!pq.isEmpty()){
    		int cur = pq.peek().e;
    		
    		if(cost[e] < pq.poll().cost)
    			continue;
    			
    		for(Edge next : arr.get(cur)) {  			
    			if(cost[cur] + next.cost < cost[next.e]) {
    				idx[next.e] = cur;
    				cost[next.e] = cost[cur] + next.cost;
    				pq.add(new Edge(next.e,next.cost));
    				// min heap이기에 -설정해줌
    			}
    		}
    	}
    	 
    	sb.append(cost[e]+ "\n");
    	// System.out.println(cost[e]);
    	
    	Stack <Integer> roads = new Stack<>();
    	int x = e;
    	while(x != 0) {
    		roads.add(x);
    		x = idx[x];
    	}
    	
     	 
    	sb.append(roads.size()+ "\n");
    	// System.out.println(roads.size());

    	while(!roads.isEmpty()) 
    		sb.append(roads.pop() + " ");

   }
}