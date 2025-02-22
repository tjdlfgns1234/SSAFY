import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현_1717 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        init(parent);

        StringBuilder sb = new StringBuilder();
        // 0 이면 union / 1이면 find(a) == find(b) ?
        for (int i=0; i<m; ++i) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(parent, a, b);
            }
            else {
                if (find(parent, a) == find(parent, b)) {
                    sb.append("YES");
                }
                else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void init(int[] parent) {
        for (int i=0; i<parent.length; ++i) {
            parent[i] = i;
        }
    }

    public static void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa == pb) {
            return;
        }

        if (pa >= pb) {
            parent[pb] = pa;
        }
        else {
            parent[pa] = pb;
        }
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) { // 부모가 자신이면
            return x;
        }

        return (parent[x] = find(parent, parent[x]));
    }
}
