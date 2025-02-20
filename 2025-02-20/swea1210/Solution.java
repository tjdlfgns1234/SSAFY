package swea.swea1210;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static final int T = 10;
    static final int LADDER = 100;

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int startR = LADDER - 1, startC = -1;
            int[][] ladder = new int[LADDER][LADDER];
            boolean[][] visit = new boolean[LADDER][LADDER];

            br.readLine().trim();
            for (int i = 0; i < LADDER - 1; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < LADDER; j++) {
                    ladder[i][j] = Integer.parseInt(line[j]);
                }
            }
            String[] line = br.readLine().trim().split(" ");
            for (int j = 0; j < LADDER; j++) {
                ladder[LADDER - 1][j] = Integer.parseInt(line[j]);
                if (ladder[LADDER - 1][j] == 2) {
                    startC = j;
                    visit[LADDER - 1][j] = true;
                }
            }

            while (startR > 0) {
                visit[startR][startC] = true;
                if (check(-1, startR, startC, ladder, visit)) {
                    // left
                    startC -= 1;
                    continue;
                } else if (check(1, startR, startC, ladder, visit)) {
                    // right
                    startC += 1;
                    continue;
                } else {
                    startR -= 1;
                }
            }
            sb.append("#" + tc + " " + startC + "\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean check(int i, int startR, int startC, int[][] ladder, boolean[][] visit) {
        int newCol = startC + i;
        return (isInLadder(startR, newCol) && ladder[startR][newCol] == 1 && !visit[startR][newCol]);
    }

    private static boolean isInLadder(int r, int c) {
        return (r >= 0 && c >= 0 && r < 100 && c < 100);
    }
}
