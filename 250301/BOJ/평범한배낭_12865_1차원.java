import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865_1차원 {
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

        int[] dp = new int[K + 1];

        for (int i=1; i<=N; ++i) {
            // dp[] 배열은 이전 값의 최대 이득 상태로 초기화된 상태
            for (int j=K; j>=items[i].w; --j) {
                // (현재 + 남는 무게의 이전 값 중 최대 이득) vs 그냥 이전 값
                // dp[j] 자체가 이전 아이템까지 탐색 중 j만큼의 무게로 얻을 수 있는 최댓값임
                dp[j] = Math.max(items[i].v + dp[j-items[i].w], dp[j]);
            }
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[K]);
    }
}
