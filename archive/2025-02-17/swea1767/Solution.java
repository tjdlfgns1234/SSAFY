package solving.swea1767;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<Core> cores;
    static int[][] coreMap;
    static int N, minWire, maxCore;

    static class Core {
        int r, c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            coreMap = new int[N][N];
            cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    int core = Integer.parseInt(line[j]);
                    if (core == 1) {
                        coreMap[i][j] = core;
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            continue;
                        }
                        cores.add(new Core(i, j));
                    }
                }
            }

            minWire = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;

            dfs(0, 0, 0);
            sb.append("#" + tc + " " + minWire + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int idx, int coreCount, int wireCount) {
        if (idx == cores.size()) {
            if (maxCore < coreCount) {
                maxCore = coreCount;
                minWire = wireCount;
            } else if (maxCore == coreCount) {
                minWire = Math.min(wireCount, minWire);
            }
            return;
        }

        int r = cores.get(idx).r;
        int c = cores.get(idx).c;

        for (int direction = 0; direction < 4; direction++) {
            int count = 0, nr = r, nc = c;

            while (true) {
                nr += dr[direction];
                nc += dc[direction];
                if (!isInMap(nr, nc)) {
                    break;
                }
                if (coreMap[nr][nc] == 1) {
                    count = 0;
                    break;
                }
                count += 1;
            }

            int fillR = r;
            int fillC = c;
            for (int i = 0; i < count; i++) {
                fillR += dr[direction];
                fillC += dc[direction];
                coreMap[fillR][fillC] = 1;
            }

            if (count == 0) {
                dfs(idx + 1, coreCount, wireCount);
            } else {
                dfs(idx + 1, coreCount + 1, wireCount + count);
                fillR = r;
                fillC = c;
                for (int i = 0; i < count; i++) {
                    fillR += dr[direction];
                    fillC += dc[direction];
                    coreMap[fillR][fillC] = 0;
                }
            }
        }
    }

    private static boolean isInMap(int nr, int nc) {
        return (nr >= 0 && nc >= 0 && nr < N && nc < N);
    }
}
