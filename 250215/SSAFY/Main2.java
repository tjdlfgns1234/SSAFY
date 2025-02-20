import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 산악 구조 로봇 - BFS
 * DFS 가능? -> N의 범위가 최대 30이라 터질 수 있음
 * BFS로만? / 다익스트라 불가능? value 기준으로 하면 됨
 */

public class Main2 {

    static int[][] map;
    static int N;
    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int chk = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];

            for (int i=1; i<=N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=1; j<=N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            chk = 0;
            solve();

            System.out.println("chk: " + chk);
        }
    }

    public static void solve() {
        int[][] dist = new int[N+1][N+1];
        for (int i=1; i<=N; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Point> q = new ArrayDeque<>();
        dist[1][1] = 0;
        q.add(new Point(1, 1));

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            ++chk;
            Point curr = q.poll();

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + dr[i];
                int nextC = curr.c + dc[i];

                if (isValid(nextR, nextC)) {
                    int value;
                    int currH = map[curr.r][curr.c];
                    int nextH = map[nextR][nextC];
                    if (currH == nextH) {
                        value = 1;
                    }
                    else if (currH > nextH) {
                        value = 0;
                    }
                    else {
                        value = (nextH - currH) * 2;
                    }

                    if (dist[nextR][nextC] > dist[curr.r][curr.c] + value) {
                        dist[nextR][nextC] = dist[curr.r][curr.c] + value;
                        q.add(new Point(nextR, nextC));
                    }
                }
            }

        }

        System.out.println(dist[N][N]);

    }

    public static boolean isValid(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
}
