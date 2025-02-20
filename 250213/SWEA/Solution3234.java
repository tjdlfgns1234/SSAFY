import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 <= N <= 9
 */

public class Solution3234 {

    static int[] weight;
    static int result, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            weight = new int[N];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            recursive(0, 0, 0, new boolean[N]);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb);
        }
    }

    // 순서 존재 -> 순열
    public static void recursive(int left, int right, int idx, boolean[] v) {
        if (idx == N) {
            ++result;
        }

        for (int i = 0; i < N; ++i) {
            if (!v[i]) {
                v[i] = true;
                recursive(left + weight[i], right, idx + 1, v);
                if (right + weight[i] <= left) {
                    recursive(left, right + weight[i], idx + 1, v);
                }
                v[i] = false;
            }
        }
    }
}
