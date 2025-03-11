import java.util.*;
import java.io.*;

public class Boj_12865_평범한배낭 {
    public static void main(String[] args) throws Exception {
        //냅색
        //무게 W, 가치 V 물건 개수 N
        //최대 K 무게
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] info = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());  //무게
            info[i][1] = Integer.parseInt(st.nextToken());  //가치
        }

        int[][] dp = new int[N+1][K+1];  //dp[i][j] = 최대 무게가 j인 가방에 i번째 물건까지 탐색했을 때의 최대가치

        //물건을 담거나 안담거나
        //dp[K][W] = K번째 물건 안담았을 때 최대 가치, K번째 물건 담았을 때 최대 가치
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                //K번째 물건 넣을 수 있을 정도로 배낭 무게 남음
                if (j >= info[i][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], info[i][1] + dp[i-1][j-info[i][0]]);
                }

                //못 넣음 -> 이전 탐색 값 그대로
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}
