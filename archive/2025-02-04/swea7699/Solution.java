package solving.swea7699;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int[] dr = { -1, 0, 1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);

            char[][] islands = new char[row][col];
            for (int i = 0; i < row; i++) {
                islands[i] = br.readLine().toCharArray();
            }

            // 알파벳 갯수
            boolean[] seen = new boolean[26];

            int count = dfs(0, 0, seen, islands, 0);

            sb.append("#" + tc + " " + count);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    private static int dfs(int i, int j, boolean[] seen, char[][] islands, int count) {
        // 하나를 봤으니 count 증가 현재 본 유물 기록
        int maxCount = 0;
        count += 1;
        seen[islands[i][j] - 'A'] = true;

        // 사방탐색
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (isInIslands(nr, nc, islands) && !seen[islands[nr][nc] - 'A']) {
                // 좌표가 범위내고 유물이 보지 않은 유물이라면
                maxCount = Math.max(maxCount, dfs(nr, nc, seen, islands, count));
            }
        }

        // 보고 나서 탐색하지 않은 것으로 기록
        seen[islands[i][j] - 'A'] = false;
        return Math.max(maxCount, count);
    }

    private static boolean isInIslands(int nr, int nc, char[][] islands) {
        int row = islands.length;
        int col = islands[0].length;

        return (nr >= 0 && nr < row && nc >= 0 && nc < col);
    }

}
