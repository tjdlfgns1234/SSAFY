import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1 <= W, H <= 200 -> DFS 불가능
 */

public class Main1600 {

    static class Point {
        int r;
        int c;
        int count;
        Point() {};
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    static int W, H, K;
    static int[][] board;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 말처럼 움직일 수 있는 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        for (int i=0; i<H; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<W; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[K+1][H][W];

        int min = bfs();

        System.out.println(min);

    }

    public static int bfs() {

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0));
        int count = q.size();
        visited[0][0][0] = true;

        int[] rdMonkey = {0, 1, 0, -1};
        int[] cdMonkey = {1, 0, -1, 0};

        int[] rdHorse = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] cdHorse = {1, 2, 2, 1, -1, -2, -2, -1};

        int num = 0;

        while (!q.isEmpty()) {
            if (count == 0) {
                count = q.size();
                ++num;
            }

            Point curr = q.poll();
            if (curr.r == H-1 && curr.c == W-1) {
                return num;
            }

            if (curr.count < K) {
                for (int i=0; i<8; ++i) {
                    int nextR = curr.r + rdHorse[i];
                    int nextC = curr.c + cdHorse[i];
                    if (isValid(nextR, nextC)) {
                        if (!visited[curr.count+1][nextR][nextC]) {
                            Point next = new Point(nextR, nextC, curr.count+1);
                            visited[next.count][nextR][nextC] = true;
                            q.add(next);
                        }
                    }
                }
            }

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + rdMonkey[i];
                int nextC = curr.c + cdMonkey[i];
                if (isValid(nextR, nextC)) {
                    if (!visited[curr.count][nextR][nextC]) {
                        Point next = new Point(nextR, nextC, curr.count);
                        visited[next.count][nextR][nextC] = true;
                        q.add(next);
                    }
                }
            }

            --count;
        }

        return -1;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W && board[r][c] == 0;
    }
}
