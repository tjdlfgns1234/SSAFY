import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2206_dfs_fail {

    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] map = new String[N];
        int count = 1;
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine();
        }

        boolean[][] visited = new boolean[N][M];
        boolean isCrashed = false;

        dfs(0, 0, map, visited, isCrashed, count);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void dfs(int r, int c, String[] map, boolean[][] visited, boolean isCrashed, int count) {
        if (r == N - 1 && c == M - 1) {
            min = Math.min(min, count);
            return;
        }

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        for (int i = 0; i < 4; ++i) {
            int nextR = r + rd[i];
            int nextC = c + cd[i];

            if (isValid(nextR, nextC, visited)) {
                visited[nextR][nextC] = true;
                if (!isCrashed) { // 한 번도 안 부숨
                    if (map[nextR].charAt(nextC) == '1') {
                        dfs(nextR, nextC, map, visited, !isCrashed, count + 1);
                    }
                    else {
                        dfs(nextR, nextC, map, visited, isCrashed, count + 1);
                    }
                }
                else { // 한 번 부숨
                    if (map[nextR].charAt(nextC) == '0') {
                        dfs(nextR, nextC, map, visited, isCrashed, count + 1);
                    }
                }
                visited[nextR][nextC] = false;
            }
        }
    }

    public static boolean isValid(int r, int c, boolean[][] visited) {
        return r >= 0 && r < N && c >= 0 && c < M && !visited[r][c];
    }
}
