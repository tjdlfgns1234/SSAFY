import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1949 {
    static int maxH;
    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] map;
    static List<Point> maxList;
    static int N, K;
    static int max;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxH = Integer.MIN_VALUE;
            max = Integer.MIN_VALUE;
            visited = new boolean[N][N];

            for (int i=0; i<N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxH = Math.max(maxH, map[i][j]);
                }
            }

            maxList = new ArrayList<>();

            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    if (map[i][j] == maxH) {
                        maxList.add(new Point(i, j));
                    }
                }
            }

            for (int i=0; i<maxList.size(); ++i) {
                Point p = maxList.get(i);
                visited[p.r][p.c] = true;
                dfs(p.r, p.c, 1, 0, map[p.r][p.c]);
                visited[p.r][p.c] = false;
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(max);
            System.out.println(sb);
        }
    }

    public static void dfs(int r, int c, int length, int state, int currH) {
        for (int i=0; i<4; ++i) {
            int nextR = r+dr[i];
            int nextC = c+dc[i];
            if (isValid(nextR, nextC) && !visited[nextR][nextC]) {
                int nextH = map[nextR][nextC];
                if (state == 0) { // 깎을 수 있음
                    if (nextH >= currH) {
                        if (nextH - K < currH) {
                            visited[nextR][nextC] = true;
                            dfs(nextR, nextC, length+1, state+1, currH-1);
                            visited[nextR][nextC] = false;
                        }
                    }
                }

                if (nextH < currH) {
                    visited[nextR][nextC] = true;
                    dfs(nextR, nextC, length+1, state, nextH);
                    visited[nextR][nextC] = false;
                }

            }
        }

        max = Math.max(max, length);
    }


    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}