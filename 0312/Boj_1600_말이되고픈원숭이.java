import java.util.*;
import java.io.*;

//bfs
public class Boj_1600_말이되고픈원숭이 {
    static int K,W,H;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        //원숭이 K번 -> 말처럼, 그 외 인접칸 (상하좌우)
        //맨 왼쭉 위 -> 맨 오른쪽 아래 이동
        //최소한 동작으로 이동
        //장애물 이동 불가 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); //가로
        H = Integer.parseInt(st.nextToken()); //세로

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(ans < Integer.MAX_VALUE ? ans : -1);
    }

    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0,0,0,0});
        boolean[][][] visited = new boolean[H][W][K+1];
        visited[0][0][0] = true;
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            int move = curr[3];


            if (r == H-1 && c == W-1) {
                ans = move;
                return;
            }

            int[] horsemove_r = {-2,-2,-1,-1,1,1,2,2};
            int[] horsemove_c = {-1,1,-2,2,-2,2,-1,1};

            //말이동
            if (cnt < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + horsemove_r[i];
                    int nc = c + horsemove_c[i];
                    if (!inRange(nr,nc) || map[nr][nc] == 1 || visited[nr][nc][cnt+1]) continue;

                    visited[nr][nc][cnt+1] = true;
                    dq.add(new int[] {nr,nc,cnt+1,move+1});
                }
            }

            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!inRange(nr,nc) || map[nr][nc] == 1 || visited[nr][nc][cnt]) continue;
                if (nr == H-1 && nc == W-1) {
                    ans = move+1;
                    return;
                }
                visited[nr][nc][cnt] = true;
                dq.add(new int[] {nr,nc,cnt,move+1});
            }
        }
    }
    static boolean inRange(int r, int c) {
        return 0<= r && r < H && 0 <= c && c < W;
    }
}
