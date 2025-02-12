import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 현재 상태에 따라 움직일 수 있음
 * 시작 위치부터 인접한 지역까지의 이동할 수 있는 경우의 수 -> 한 칸씩 늘리기
 *
 * 태인이형 코드 참고 -> 훨씬 깔끔
 */

public class Main17070_DFS {
    static int N;
    static int[][] house;
    static int result;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        house = new int[N][N];
        result = 0;
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(result);
    }

    public static void dfs(int r, int c, int state) {
        if (r == N-1 && c == N-1) {
            ++result;
            return;
        }

        if (state == 0 || state == 1) { // 가로
            if (isValid(r+dr[state], c+dc[state])) {
                dfs(r + dr[state], c + dc[state], state);
            }
        }

        if (state == 2) {
            for (int i=0; i<2; ++i) {
                if (isValid(r+dr[i], c+dc[i])) {
                    dfs(r + dr[i], c + dc[i], i);
                }
            }
        }

        boolean isPossible = true;
        for (int i=0; i<3; ++i) {
            if (!isValid(r+dr[i], c+dc[i])) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            dfs(r+dr[2], c+dc[2], 2);
        }


    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N && house[r][c] == 0;
    }

}