import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
    static class Item {
        int w;
        int v;

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new Item(w, v);
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                if (items[i].w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - items[i].w] + items[i].v, dp[i - 1][j]);
                }
            }
        }

//        for (int i = 0; i <= N; ++i) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[N][K]);
    }
}
