import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4193 {

    static class Point {
        int r;
        int c;
        int time;

        Point() {
        }

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < map.length; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Point[] points = new Point[2]; // 0은 시작 1은 도착
            for (int i = 0; i < 2; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                points[i] = new Point(r, c);
            }

            int[][] visited = new int[N][N]; //해당 칸까지 도착하는 데 걸린 시간

            bfs(map, points, visited);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            if (visited[points[1].r][points[1].c] == 0) {
                sb.append(-1);
            } else {
                sb.append(visited[points[1].r][points[1].c]);
            }

            System.out.println(sb);
        }
    }

    public static void bfs(int[][] map, Point[] points, int[][] visited) {

        Queue<Point> q = new ArrayDeque<>();
        q.offer(points[0]);

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        int count = q.size();

        while (!q.isEmpty()) {

            if (count == 0) {
                count = q.size();
            }

            Point curr = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];

                if (isValid(nextR, nextC, map)) {

                    int nextTime;

                    if (map[nextR][nextC] == 2) {
                        nextTime = curr.time + (3 - (curr.time % 3));
                    } else {
                        nextTime = curr.time + 1;
                    }

                    if (visited[nextR][nextC] == 0 || visited[nextR][nextC] > nextTime) {
                        visited[nextR][nextC] = nextTime;
                        Point p = new Point(nextR, nextC, nextTime);
                        q.offer(p);
                    }

                }
            }

            --count;
        }

    }

    public static boolean isValid(int r, int c, int[][] map) {
        return r >= 0 && r < N && c >= 0 && c < N && map[r][c] != 1;
    }

}
