package solving.swea1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point implements Comparable<Point> {
        int r, c, cost;

        public Point(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point obj) {
            return Integer.compare(this.cost, obj.cost);
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            // 지도 크기
            int N = Integer.parseInt(br.readLine().trim());
            int[][] jido = new int[N][N];
            boolean[][] visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split("");
                for (int j = 0; j < N; j++) {
                    jido[i][j] = Integer.parseInt(line[j]);
                }
            }

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.offer(new Point(0, 0, 0));
            visit[0][0] = true;
            while (!pq.isEmpty()) {
                Point now = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (inInMap(nr, nc, N) && !visit[nr][nc]) {
                        int newCost = now.cost + jido[nr][nc];
                        pq.offer(new Point(nr, nc, newCost));
                        visit[nr][nc] = true;

                        if (nr == N - 1 && nc == N - 1) {
                            System.out.printf("#%d %d\n", tc, newCost);
                            pq.clear();
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean inInMap(int nr, int nc, int n) {
        return (nr >= 0 && nc >= 0 && nr < n && nc < n);
    }
}
