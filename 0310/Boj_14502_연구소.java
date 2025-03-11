
import java.util.*;
import java.io.*;

public class Boj_14502_연구소 {
    static int N,M,ans;
    static int[][] map;
    static ArrayList<Point> virus, blank;
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        virus = new ArrayList<>();
        blank = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Point(i,j));
                }
                else if (map[i][j] == 0) {
                    blank.add(new Point(i,j));
                }
            }

        }

        //벽 세울 빈칸 3개 고르기
        ans = 0;
        choose(0,0,new Point[3]);
        System.out.println(ans);
    }

    //조합
    static void choose(int idx, int depth, Point[] sel) {
        if (depth == 3) {
            //탐색
            bfs(sel);
            return;
        }
        if (idx == blank.size()) {
            return;
        }

        //고르거나
        sel[depth] = blank.get(idx);
        choose(idx+1,depth+1,sel);

        choose(idx+1,depth,sel);
    }

    static void bfs(Point[] sel) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(map[i], M);
        }
        int danger = 0;

        for (int i = 0; i < sel.length; i++) {
            temp[sel[i].r][sel[i].c] = 1;
        }
//
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < virus.size(); i++) {
            Deque<Point> dq = new ArrayDeque<>();
            dq.add(virus.get(i));
            visited[virus.get(i).r][virus.get(i).c] = true;
            while (!dq.isEmpty()) {
                Point curr = dq.pollFirst();
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];
                    if (!inRange(nr,nc) || visited[nr][nc]) continue;
                    if (temp[nr][nc] == 0) {  //빈칸
                        danger++;
                        visited[nr][nc] = true;
                        temp[nr][nc] = 2;
                        dq.add(new Point(nr,nc));
                    }
                }
            }
        }

        int safe = N * M - (virus.size() + danger) - (N*M- virus.size() - blank.size() + 3);
        ans = Math.max(ans, safe);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && 0 <= c && c < M;
    }
}
