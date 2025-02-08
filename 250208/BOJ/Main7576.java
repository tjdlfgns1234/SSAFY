import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 30분
 */

public class Main7576 {

    static class Point {
        int r;
        int c;

        public Point() {}
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int days;
    static Queue<Point> q = new ArrayDeque<>();
    static int zeroCount = 0;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[N][M];
        days = 0;

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 0) ++zeroCount;
                else if (tomato[i][j] == 1) {
                    Point p = new Point(i, j);
                    q.add(p);
                }
            }
        }

        if (zeroCount == 0) {
            result = 0;
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

    public static void bfs(int[][] tomato) {
        int[] rd = {0, 1, 0 , -1};
        int[] cd = {1, 0, -1, 0};

        int count = q.size();

        while (!q.isEmpty()) {
            if (count == 0) {
                ++days;
                count = q.size();
            }
            Point curr = q.poll();
            for (int i=0; i<4; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];
                if (isValid(tomato, nextR, nextC)) {
                    tomato[nextR][nextC] = 1;
                    Point p = new Point(nextR, nextC);
                    q.offer(p);
                    --zeroCount;
                }
            }
            --count;
        }

    }

    public static boolean isValid(int[][] tomato, int r, int c) {
        return r >= 0 && c >= 0 && r < tomato.length && c < tomato[r].length && tomato[r][c] == 0;
    }
}
