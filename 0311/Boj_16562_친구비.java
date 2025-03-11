import java.util.*;
import java.io.*;

//mst 짬뽕? -> kruskal?
//친구비 젤 적은 놈 -> 루트
public class Boj_16562_친구비 {
    static int[] parent, money;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        money = new int[N+1];
        parent = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        //같은 친구 관계가 여러 번 주어질 수도 있다...
        //System.out.println(Arrays.toString(parent));
        int ans = 0;
        boolean[] v = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            int root = find(i);   //!!! 최신 부모 반영해야함 <- 경로압축 코드
            if (!v[root]) {
                ans += money[parent[i]];
                v[parent[i]] = true;
            }
        }

        System.out.println(ans <= K ? ans : "Oh no");
    }

    static void union(int a, int b) {
        int p_a = find(a);
        int p_b = find(b);
        if (p_a != p_b) {
            if (money[p_a] < money[p_b]) parent[p_b] = p_a;
            else parent[p_a] = p_b;
        }
    }
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
