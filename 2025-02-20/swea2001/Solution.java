package swea.swea2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            int[][] flies = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 1; j <= N; j++) {
                    flies[i][j] = Integer.parseInt(line[j - 1]);
                    flies[i][j] += flies[i - 1][j] + flies[i][j - 1] - flies[i - 1][j - 1];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N + 1 - M; i++) {
                for (int j = 0; j < N + 1 - M; j++) {
                    int now = flies[i + M][j + M] - flies[i][j + M] - flies[i + M][j] + flies[i][j];
                    max = Math.max(max, now);
                }
            }
            sb.append("#" + tc + " " + max + "\n");
        }
        System.out.print(sb.toString());
    }
}
