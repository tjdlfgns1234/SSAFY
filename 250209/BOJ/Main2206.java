import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {

    static class Point {
        int r;
        int c;
        int isCrashed;

        Point() {}
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        Point(int r, int c, int isCrashed) {
            this.r = r;
            this.c = c;
            this.isCrashed = isCrashed;
        }
    }

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] map = new String[N];
        for (int i=0; i<N; ++i) {
            map[i] = br.readLine();
        }

        boolean[][][] visited = new boolean[2][N][M];

        int min = bfs(0, 0, map, visited);

        System.out.println(min);
    }

    public static int bfs(int r, int c, String[] map, boolean[][][] visited) {

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));
        visited[0][r][c] = true;

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        int count = q.size();
        int min = 1;

        while (!q.isEmpty()) {
            if (count == 0) {
                ++min;
                count = q.size();
            }

            Point curr = q.poll();
            if (curr.r == N-1 && curr.c == M-1) {
                return min;
            }

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];
                Point next = new Point(nextR, nextC, curr.isCrashed);
                if (isValid(nextR, nextC)) {
                    if (!visited[curr.isCrashed][nextR][nextC]) {
                        if (curr.isCrashed == 0) {
                            if (map[nextR].charAt(nextC) == '1') {
                                next.isCrashed = 1;
                            }
                            visited[next.isCrashed][nextR][nextC] = true;
                            q.offer(next);
                        }
                        else {
                            if (map[nextR].charAt(nextC) == '0') {
                                visited[next.isCrashed][nextR][nextC] = true;
                                q.offer(next);
                            }
                        }
                    }
                }
            }

            --count;
        }

        return -1;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 &&  c < M;
    }
}
