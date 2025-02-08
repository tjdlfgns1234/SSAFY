import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {

    static int count;

    static class Point {
        int r;
        int c;

        public Point() {
        }

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) break;

            count = 0;

            int[][] map = new int[H][W];
            for (int i = 0; i < H; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < H; ++i) {
                for (int j = 0; j < W; ++j) {
                    if (map[i][j] == 1) {
                        map[i][j] = 0;
                        bfs(map, i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void bfs(int[][] map, int r, int c) {
        ++count;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(r, c));

        // 12시부터 시계방향
        int[] rd = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] cd = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            Point curr = q.poll();
            for (int i = 0; i < 8; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];
                if (isValid(map, nextR, nextC)) {
                    map[nextR][nextC] = 0;
                    q.offer(new Point(nextR, nextC));
                }
            }
        }
    }

    // 섬인지 판단
    public static boolean isValid(int[][] map, int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length && map[r][c] == 1;
    }
}
