import java.io.*;
import java.util.*;

public class 파티 {

    static class pair implements Comparable<pair>{
        int e;
        int t;
        public pair(int e ,int t){
            this.e =e;
            this.t =t;
        }

        @Override
        public int compareTo(pair o) {
            return t-o.t;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<pair>[] adj;
    static int[] distMy;
    static int N,M,X;

    public static void main(String[] args)throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new List[N+1];

        for(int i=0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[s].add(new pair(e,t));
        }

        int result=0;
        myDij();

        for(int i=1;i<=N;i++){
            result = Math.max(dijstra(i) + distMy[i] ,result);
        }
        System.out.println(result);

    }

    static void myDij(){
        distMy = new int[N+1];
        boolean[] visited = new boolean[N+1];
        for(int i=0;i<distMy.length;i++){
            distMy[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(X,0));
        distMy[X]=0;

        while(!pq.isEmpty()){
            int minV=0;
            while(!pq.isEmpty()){
                pair p = pq.poll();
                if(!visited[p.e]){
                    minV = p.e;
                    break;
                }
            }

            if(minV==0)continue;
            visited[minV]=true;
            for(int i=0;i<adj[minV].size();i++){
                pair p = adj[minV].get(i);
                if(visited[p.e] || distMy[p.e] < distMy[minV]+p.t)continue;
                distMy[p.e] = distMy[minV]+p.t;
                pq.add(new pair(p.e , distMy[minV]+p.t));
            }
        }

    }

    static int dijstra(int start){
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            int minV=0;
            while(!pq.isEmpty()){
                pair p = pq.poll();
                if(!visited[p.e]){
                    minV = p.e;
                    break;
                }
            }

            if(minV==0)continue;
            visited[minV]=true;
            for(int i=0;i<adj[minV].size();i++){
                pair p = adj[minV].get(i);
                if(visited[p.e] || dist[p.e] < dist[minV]+p.t)continue;
                dist[p.e] = dist[minV]+p.t;
                pq.add(new pair(p.e , dist[minV]+p.t));
            }
        }
        return dist[X];
    }

}
