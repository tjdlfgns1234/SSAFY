import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 산악 구조 로봇 - 다익스트라
 */

public class Main3 {

    static int[][] map;
    static int N;
    static class Point implements Comparable<Point> {
        int r;
        int c;
        int value;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.value, o.value);
        }
    }


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

            solve();


        }
    }

    public static void solve() {
        int[][] dist = new int[N+1][N+1];
        for (int i=1; i<=N; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[1][1] = 0;
        pq.add(new Point(1, 1, dist[1][1]));

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        boolean[][] visited = new boolean[N+1][N+1];

        while (!pq.isEmpty()) {
            Point curr = pq.poll();

            if (curr.r == N && curr.c == N) {
                break;
            }

            if (visited[curr.r][curr.c]) {
                continue;
            }

            visited[curr.r][curr.c] = true;

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + dr[i];
                int nextC = curr.c + dc[i];

                if (isValid(nextR, nextC) && !visited[nextR][nextC]) {
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
                        pq.add(new Point(nextR, nextC, dist[nextR][nextC]));
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
