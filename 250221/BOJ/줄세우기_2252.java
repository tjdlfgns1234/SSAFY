import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬? -> 차수가 0인 애부터 출력
 */
public class 줄세우기_2252 {
    static class Node {
        int n;
        int d;

        Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    static List<List<Integer>> graph;
    static int[] degree;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList<>();
        q = new ArrayDeque<>();

        for (int i=0; i<=N; ++i) {
            graph.add(new ArrayList<>());
        }

        degree = new int[N+1];
        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ++degree[e];
            graph.get(s).add(e);
        }

        for (int i=1; i<degree.length; ++i) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        find(sb);

        for (int i=1; i<degree.length; ++i) {
            if (degree[i] != -1) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void find(StringBuilder sb) {
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");
            degree[curr] = -1;

            List<Integer> list = graph.get(curr);
            for (int i=0; i<list.size(); ++i) {
                --degree[list.get(i)];
                if (degree[list.get(i)] == 0) {
                    q.add(list.get(i));
                }
            }
        }
    }
}
