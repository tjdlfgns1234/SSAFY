import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 캐빈베이컨의수 {




    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visit;
    public static void main(String[] args)throws Exception {


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj= new List[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(adj[s].contains(e))continue;
            adj[s].add(e);
            adj[e].add(s);
        }
        int ansNode=0;
        int min = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            visit = new boolean[N+1];
            int temp = bfs(i );
            if(min>temp){
                ansNode=i; min = temp;
            }
        }

        System.out.println(ansNode);
    }

    static int bfs(int node){

        Queue<Integer> q = new ArrayDeque<>();
        visit[node]=true;
        q.add(node);
        int depth=1;
        int ans=0;
        while (!q.isEmpty()){
            Queue<Integer> locQ = new ArrayDeque<>();
            while (!q.isEmpty()){
                locQ.add(q.poll());
            }
            while (!locQ.isEmpty()){
                int n  = locQ.poll();
                for(int i=0;i<adj[n].size();i++){
                    int e = adj[n].get(i);
                    if(visit[e])continue;
                    ans+=depth;
                    visit[e]=true;
                    q.add(e);
                }
            }
            depth++;
        }
        return ans;
    }




}

