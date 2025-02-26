package solving.baekjoon2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static final int[] dr = { -1, 0, 1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = toNum(br.readLine().trim());
            int[][] map = new int[N][N];
            int maxHeight = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = toNum(line[j]);
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }

            // 처음 땅은 한덩이
            int areaCount = 1;
            for (int height = 1; height < maxHeight; height++) {
                // 물 높이가 1일때부터 maxHeight 전까지 maxHeight일 경우 땅이 없다
                areaCount = Math.max(areaSim(height, map), areaCount);
            }
            bw.write(areaCount + "\n");
        }
        bw.flush();
    }

    private static int areaSim(int height, int[][] map) {
        boolean[][] visit = new boolean[map.length][map.length];
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (!visit[i][j] && map[i][j] > height) {
                    dfs(i, j, map, visit, height);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(int i, int j, int[][] map, boolean[][] visit, int height) {
        for (int direction = 0; direction < dr.length; direction++) {
            int nr = i + dr[direction];
            int nc = j + dc[direction];
            if (isInMap(nr, nc, map.length) && !visit[nr][nc] && map[nr][nc] > height) {
                visit[nr][nc] = true;
                dfs(nr, nc, map, visit, height);
            }
        }
    }

    private static boolean isInMap(int nr, int nc, int length) {
        return nr >= 0 && nc >= 0 && nr < length && nc < length;
    }

    private static void print(int[][] map) {
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}