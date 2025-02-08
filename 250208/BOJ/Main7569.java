import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {

    static class Point {
        int h;
        int r;
        int c;

        public Point() {}
        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    static int days = 0;
    static int zeroCount = 0;
    static int result = 0;
    static Queue<Point> q = new ArrayDeque<>();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[H][N][M];

        for (int i=0; i<H; ++i) {
            for (int j=0; j<N; ++j) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; ++k) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 0) {
                        ++zeroCount;
                    }
                    else if (tomato[i][j][k] == 1) {
                        Point p = new Point(i, j, k);
                        q.add(p);
                    }
                }
            }
        }

        if (zeroCount == 0) {
            result = days;
        }
        else {
            bfs(tomato);
            if (zeroCount == 0) {
                result = days;
            }
            else {
                result = -1;
            }
        }

        System.out.println(result);
    }

    public static void bfs(int[][][] tomato) {
        // 높이 위 아래 -> 평면에서 4방
        int[] hd = {1, -1, 0, 0, 0, 0};
        int[] rd = {0, 0, 0, 1, 0, -1};
        int[] cd = {0, 0, 1, 0, -1, 0};

        int count = q.size();

        while (!q.isEmpty()) {
            if (count == 0) {
                ++days;
                count = q.size();
            }

            Point curr = q.poll();
            for (int i=0; i<6; ++i) {
                int nextH = curr.h + hd[i];
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];

                if (isValid(tomato, nextH, nextR, nextC)) {
                    tomato[nextH][nextR][nextC] = 1;
                    Point p = new Point(nextH, nextR, nextC);
                    q.offer(p);
                    --zeroCount;
                }
            }
            --count;
        }

    }

    public static boolean isValid(int[][][] tomato, int h, int r, int c) {
        return h >= 0 && r >= 0 && c >= 0 && h < tomato.length && r < tomato[h].length && c < tomato[h][r].length && tomato[h][r][c] == 0;
    }
}
