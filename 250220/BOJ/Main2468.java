import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {

    static int maxHeight, max;
    static int[][] map;

    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maxHeight = 0;
        max = 1;

        map = new int[N][N];
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        for (int i=1; i<maxHeight; ++i) {
            int count = 0;
            boolean[][] visited = new boolean[map.length][map[0].length];
            for (int r=0; r<map.length; ++r) {
                for (int c=0; c<map[r].length; ++c) {
                    if (!visited[r][c] && map[r][c] > i) {
                        bfs(r, c, i, visited);
                        ++count;
                    }
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static void bfs(int r, int c, int currH, boolean[][] visited) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int d=0; d<4; ++d) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] > currH) {
                    q.add(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >=0 && c < map[r].length;
    }

}
