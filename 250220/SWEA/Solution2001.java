import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2001 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N+1][N+1];

            for (int i=1; i<=N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j=1; j<=N; ++j) {
                    int curr = Integer.parseInt(st.nextToken());
                    int prev = map[i-1][j] + map[i][j-1] - map[i-1][j-1];
                    map[i][j] = prev + curr;
                }
            }

            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i=M; i<=N; ++i) {
                for (int j=M; j<=N; ++j) {
                    sum = map[i][j] - map[i][j-M] - map[i-M][j] + map[i-M][j-M];
                    max = Math.max(max, sum);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(max);
            System.out.println(sb);
        }
    }

}