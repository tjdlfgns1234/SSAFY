import java.io.*;
import java.util.*;

public class Main {

    static class route{
        int path, weight;
        route(int path, int weight){
            this.path = path;
            this.weight = weight;
        }
    }

    static int N,M, left, right, temp;
    static ArrayList<route>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b, c, mid;
        left = 0;
        right = 0;
        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            right = Math.max(right, c);

            graph[a].add(new route(b, c));
            graph[b].add(new route(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        while(left <= right) {
            mid = (left + right) / 2;
            temp = -1;
            visit = new boolean[N+1];
            dfs(start, end, mid);
            if(temp != -1) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(right);

    }
    private static void dfs(int start, int end, int mid) {
        if(start == end) {
            temp = start;
            return;
        }
        visit[start] = true;
        for (route r : graph[start]) {
            if(!visit[r.path] && r.weight >= mid) {
                dfs(r.path, end, mid);
            }
        }
    }

}
