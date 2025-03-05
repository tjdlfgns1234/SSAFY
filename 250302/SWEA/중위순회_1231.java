import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중위순회_1231 {

    static class Node {
        String value;
        int left;
        int right;
        Node (String value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t=1; t<=10; ++t) {
            N = Integer.parseInt(br.readLine()); // 정점 수
            tree = new Node[N+1];
            sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int curr = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                int left = -1;
                int right = -1;
                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    right = Integer.parseInt(st.nextToken());
                }
                tree[curr] = new Node(value, left, right);
            }

            inorder(1);
            System.out.println(sb);
        }
    }

    public static void inorder(int idx) {
        if (idx == -1) {
            return;
        }

        Node curr = tree[idx];

        if (curr.left == -1) {
            sb.append(curr.value);
            return;
        }

        inorder(curr.left);
        sb.append(curr.value);
        inorder(curr.right);
    }
}
