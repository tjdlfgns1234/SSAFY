import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 깊이 n이면 복구하는 시간 n
 * 복구 시간이 가장 짧은 경로는? -> 가장 적은 가중치 = 그래프 탐색
 * 2차원 배열 형태? -> BFS + PQ?
 * 상하좌우 이동
 * (0, 0) -> (N-1, N-1)
 */


public class Solution1249 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static class Point implements Comparable<Point>{
        int r;
        int c;
        int w;
        Point() {}
        Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i=0; i<N; ++i) {
                String row = br.readLine();
                for (int j=0; j<row.length(); ++j) {
                    map[i][j] = row.charAt(j) - '0';
                }
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }


            bfs();

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(dist[N-1][N-1]);
            System.out.println(sb);
        }
    }

    public static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        dist[0][0] = 0;

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Point curr = pq.poll();

            if (visited[curr.r][curr.c]) {
                continue;
            }

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];

                if (isValid(nextR, nextC)) {
                    if (!visited[nextR][nextC] && dist[nextR][nextC] > curr.w + map[nextR][nextC]) {
                        Point next = new Point(nextR, nextC, curr.w + map[nextR][nextC]);
                        pq.add(next);
                        dist[nextR][nextC] = curr.w + map[nextR][nextC];
                    }
                }
            }

        }


    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
    }

}