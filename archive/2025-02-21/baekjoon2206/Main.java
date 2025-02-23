package solving.baekjoon2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 굳이 3차원 방문배열을 사용해야하나? 벽을 부순 뒤에도 돌아가는건 더 비효율적인 연산이 아닌가?
 * 큐에 넣을 때 목적지 여부를 판단하는 경우가 좀 더 합리적이고 불필요한 연산 이 적지만,
 *  탐색 없이 시작점이 곧 목적지일 경우에 예외가 발생한다.
 */

public class Main {
    static final int[] dr = { -1, 0, 1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, move, crush;

        public Point(int r, int c, int move, int crush) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.crush = crush;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 1 && M == 1) {
                // 시작지가 목적지일 경우 예외처리
                System.out.println(1);
                continue;
            }
            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                char[] line = br.readLine().trim().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line[j] - '0';
                }
            }
            int res = bfs(map, N, M);
            System.out.println(res);
        }
    }

    private static int bfs(int[][] map, int n, int m) {
        boolean[][][] visit = new boolean[2][n][m];

        Deque<Point> dq = new ArrayDeque<>();

        dq.offer(new Point(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!dq.isEmpty()) {
            Point now = dq.poll();
            int nm = now.move + 1;
            for (int direction = 0; direction < 4; direction++) {
                int nr = now.r + dr[direction];
                int nc = now.c + dc[direction];
                int crush = now.crush;
                if (isInMap(nr, nc, n, m)) {
                    if (visit[crush][nr][nc] == false) {
                        if (map[nr][nc] == 0) {
                            dq.offer(new Point(nr, nc, nm, crush));
                            visit[crush][nr][nc] = true;
                            if (nr == n - 1 && nc == m - 1) {
                                return nm;
                            }
                        } else if (map[nr][nc] == 1 && crush == 0) {
                            crush = 1;
                            dq.offer(new Point(nr, nc, nm, crush));
                            visit[crush][nr][nc] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isInMap(int nr, int nc, int n, int m) {
        return (nr >= 0 && nc >= 0 && nr < n && nc < m);
    }
}
