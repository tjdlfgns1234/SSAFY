import java.util.*;
import java.io.*;

public class Boj_10026_적록색약 {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        //bfs 두번..?
        //적록색약 - 빨 / 초 같음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int not = 0;
        int yes = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int i = 0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                dq.add(new int[] {i,j});
                char color = map[i][j];
                visited[i][j] = true;
                while (!dq.isEmpty()) {
                    int[] curr = dq.pollFirst();
                    for (int d = 0; d < 4; d++) {
                        int nr = curr[0] + dr[d];
                        int nc = curr[1] + dc[d];
                        if (inRange(nr,nc) && !visited[nr][nc]) {
                            if (map[nr][nc] == color) {
                                visited[nr][nc] = true;
                                dq.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
                not++;
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                dq.add(new int[] {i,j});
                char color = map[i][j];
                visited[i][j] = true;
                while (!dq.isEmpty()) {
                    int[] curr = dq.pollFirst();
                    for (int d = 0; d < 4; d++) {
                        int nr = curr[0] + dr[d];
                        int nc = curr[1] + dc[d];
                        if (inRange(nr,nc) && !visited[nr][nc]) {
                            if (map[nr][nc] == color || isGreen(color,map[nr][nc])) {
                                visited[nr][nc] = true;
                                dq.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
                yes++;
            }
        }
        System.out.printf("%d %d", not, yes);
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static boolean isGreen(char c, char h) {
        return (c == 'R' && h == 'G') || (c == 'G' && h == 'R');
    }
}
