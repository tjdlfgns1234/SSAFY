package solving.baekjoon4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static byte[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static byte[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Point> dq = new ArrayDeque<>();
        while (true) {
            String[] line = br.readLine().trim().split(" ");
            int W = Integer.parseInt(line[0]);
            int H = Integer.parseInt(line[1]);

            if (W == 0 && H == 0) {
                break;
            }
            boolean[][] visit = new boolean[H][W];
            byte[][] jido = new byte[H][W];
            for (int i = 0; i < H; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 0; j < W; j++) {
                    jido[i][j] = Byte.parseByte(line[j]);
                }
            }

            int islandCount = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    islandCount = bfs(dq, W, H, visit, jido, islandCount, i, j);
                }
            }
            System.out.println(islandCount);
        }
    }

    private static int bfs(Deque<Point> dq, int W, int H, boolean[][] visit, byte[][] jido, int islandCount,
            int i, int j) {
        if (jido[i][j] == 1 && !visit[i][j]) {
            dq.add(new Point(i, j));
            while (!dq.isEmpty()) {
                Point now = dq.poll();
                int nr, nc;
                for (int k = 0; k < dr.length; k++) {
                    nr = now.r + dr[k];
                    nc = now.c + dc[k];
                    if (isInJido(nr, nc, H, W) && !visit[nr][nc] && jido[nr][nc] == 1) {
                        visit[nr][nc] = true;
                        dq.add(new Point(nr, nc));
                    }
                }
            }
            islandCount += 1;
        }
        return islandCount;
    }

    private static boolean isInJido(int nr, int nc, int h, int w) {
        return (nr >= 0 && nc >= 0 && nr < h && nc < w);
    }
}
