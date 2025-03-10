import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {

    static class pair implements Comparable<pair>{
        int e;
        int w;
        public pair(int e , int w){
            this.e=e;
            this.w=w;
        }

        @Override
        public int compareTo(pair o) {
            return w - o.w;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int dist[];
    static List<pair>[] adj;

    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        int V =  Integer.parseInt(st.nextToken());
        int E =  Integer.parseInt(st.nextToken());
        dist = new int[V+1];
        adj = new List[V+1];
        for(int i=1;i< adj.length;i++){
            adj[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine());
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            int w =  Integer.parseInt(st.nextToken());
            adj[s].add(new pair(e,w));
        }

        boolean visited[] = new boolean[V+1];
        for(int i=1;i< dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start]=0;

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(start,0));

        while (!pq.isEmpty()){
            int node=-1;
            while (!pq.isEmpty()){
                pair p = pq.poll();
                if(!visited[p.e]){
                    node = p.e;
                    break;
                }
            }

            if(node==-1)continue;
            visited[node]=true;

            for(int i=0;i<adj[node].size();i++){
                pair p = adj[node].get(i);
                if(visited[p.e] || dist[node]+p.w>=dist[p.e])continue;
                dist[p.e] = dist[node]+p.w;
                pq.add(new pair(p.e , dist[p.e]));
            }

        }

        for(int i=1;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }




    }

}
