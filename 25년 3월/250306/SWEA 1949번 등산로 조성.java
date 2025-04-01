import java.io.*;
import java.util.*;

class Pair {
    int x, y, boom, sum;

    Pair() {
    }

    Pair(int x, int y, int boom, int sum) {
        this.x = x;
        this.y = y;
        this.boom = boom;
        this.sum = sum;
    }

}

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] a, b;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int mp[][] = new int[8][8];
    static boolean chk[][];
    static int n, k, T, ans, top = 0;
    static int ax, ay, bx, by;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            top = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    mp[i][j] = Integer.parseInt(st.nextToken());
                    top = Math.max(top, mp[i][j]);
                }
            }

            chk = new boolean[n][n]; // 방문배열
            ans = 0;

            solve();

            System.out.println("#" + testcase + " " + ans);
        }
    }

    private static void solve() {
        // 사용자는 초기 위치부터 충전할 수 있다.
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (top == mp[i][j]) {
                    chk[i][j] = true;
                    dfs(i, j, 1, 0);
                    chk[i][j] = false;
                }
            }
    }

    private static void dfs(int x, int y, int sum, int boom) {
        ans = Math.max(ans, sum);

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || chk[nx][ny])
                continue;

            if (mp[nx][ny] < mp[x][y]) {
                // 조건에 맞으면 탐색
                chk[nx][ny] = true;
                dfs(nx, ny, sum + 1, boom);
                chk[nx][ny] = false;

            } else if (boom == 0) {
                // 공사 가능하면
                for (int j = 1; j <= k; j++) {
                    int tmp = mp[nx][ny];
                    chk[nx][ny] = true;
                    mp[nx][ny] -= j;
                    if (mp[nx][ny] < mp[x][y])
                        dfs(nx, ny, sum + 1, boom + 1);
                    mp[nx][ny] = tmp;
                    chk[nx][ny] = false;
                }

            }
        }

    }

}
