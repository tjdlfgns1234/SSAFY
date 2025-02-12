import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {

    static class Edge implements Comparable<Edge> {
        int e;
        int w;

        Edge() {}
        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int V, E, K;
    static List<List<Edge>> graph;
    static int[] dist;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine())-1;

        graph = new ArrayList<>();
        for (int i=0; i<V; ++i) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i=0; i<E; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, w));
        }

        dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[V];

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<V; ++i) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            }
            else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra() {
        dist[K] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.e]) continue;

            visited[curr.e] = true;
            for (Edge edge : graph.get(curr.e)) {
                if (!visited[edge.e] && (dist[edge.e] > dist[curr.e] + edge.w)) {
                    dist[edge.e] = dist[curr.e] + edge.w;
                    pq.add(new Edge(edge.e, dist[edge.e]));
                }
            }
        }

    }
}
