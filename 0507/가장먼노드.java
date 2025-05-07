import java.util.*;

//1번 노드로부터 가장 멀리 떨어진 노드의 개수

class Solution {
    
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        ArrayList[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        Deque<Integer> dq = new ArrayDeque<>();

        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            if (e[0] == 1) dq.add(e[1]);
            if (e[1] == 1) dq.add(e[0]);
        }
                
        int level = 1;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int curr = dq.poll();
                if (dist[curr] > level) dist[curr] = level;
                for (int v : (ArrayList<Integer>) adj[curr]) {
                    if (!visited[v]) {
                        dq.add(v);
                        visited[v] = true;
                    }
                }
            }
            level++;
        }
        
        //System.out.println(Arrays.toString(dist));
        
        int max = -1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] > max) max = dist[i];
        }
        
        int cnt = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max) cnt++;
        }
        return cnt;
    }
}
