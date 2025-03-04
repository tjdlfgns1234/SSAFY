package solving.swea1861;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    static final int[] dr = { -1, 0, 1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br);
        for (int tc = 1; tc <= T; tc++) {
            int squareSize = toNum(br);
            int[][] square = new int[squareSize][];
            for (int i = 0; i < squareSize; i++) {
                square[i] = toNumLine(br, squareSize);
            }
            int[] result = findBest(square);

            bw.write("#" + tc + " " + result[0] + " " + result[1] + "\n");
        }
        bw.flush();
    }

    private static int[] findBest(int[][] square) {
        int bestStartNum = -1;
        int bestRoomMove = -1;
        int[] dp = new int[(square.length * square.length) + 1];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                int moveRoomCount = dfs(square, i, j, dp);
                if (bestRoomMove < moveRoomCount) {
                    bestRoomMove = moveRoomCount;
                    bestStartNum = square[i][j];
                } else if (bestRoomMove == moveRoomCount) {
                    bestStartNum = Math.min(bestStartNum, square[i][j]);
                }
            }
        }
        return new int[] { bestStartNum, bestRoomMove };
    }

    private static int dfs(int[][] square, int i, int j, int[] dp) {
        if (dp[square[i][j]] != 0) {
            return dp[square[i][j]];
        }
        int result = 0;
        for (int direction = 0; direction < dr.length; direction++) {
            int nr = i + dr[direction], nc = j + dc[direction];
            if (isInMap(nr, nc, square.length) && (square[i][j] + 1 == square[nr][nc])) {
                result = dfs(square, nr, nc, dp);
                dp[square[i][j]] = result + 1;
                return dp[square[i][j]];
            }
        }
        dp[square[i][j]] = 1;
        return 1;
    }

    private static boolean isInMap(int nr, int nc, int length) {
        return nr >= 0 && nc >= 0 && nr < length && nc < length;
    }

    private static int[] toNumLine(BufferedReader br, int squareSize) throws Exception {
        String[] line = br.readLine().trim().split(" ");
        int[] result = new int[squareSize];
        for (int i = 0; i < squareSize; i++) {
            result[i] = Integer.parseInt(line[i]);
        }
        return result;
    }

    private static int toNum(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

}
