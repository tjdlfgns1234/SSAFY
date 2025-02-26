package solving.baekjoon1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int len = toNum(br.readLine().trim());
            int[][] cost = new int[3][len];
            int[][] dp = new int[3][len];

            for (int i = 0; i < len; i++) {
                String[] line = br.readLine().trim().split(" ");
                cost[0][i] = toNum(line[0]);
                cost[1][i] = toNum(line[1]);
                cost[2][i] = toNum(line[2]);
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];
            dp[2][0] = cost[2][0];

            for (int i = 1; i < len; i++) {
                dp[0][i] = cost[0][i] + Math.min(dp[1][i - 1], dp[2][i - 1]);
                dp[1][i] = cost[1][i] + Math.min(dp[0][i - 1], dp[2][i - 1]);
                dp[2][i] = cost[2][i] + Math.min(dp[0][i - 1], dp[1][i - 1]);
            }
            int min = Math.min(dp[0][len - 1], Math.min(dp[1][len - 1], dp[2][len - 1]));
            bw.write(min + "\n");
        }
        bw.flush();
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
