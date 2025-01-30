import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4615 {
    static int[] rd = {-1, -1, 0, 1, 1, 1, 0, -1}; //12시부터 시계방향
    static int[] cd = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int i=N/2-1; i<=N/2; ++i) {
                for (int j=N/2-1; j<=N/2; ++j) {
                    map[i][j] = 1; //1은 흑돌
                }
                map[i][i] = 2; //2는 백돌
            }

            for (int i=0; i<M; ++i) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                play(map, r-1, c-1, color);
            }

            int blackCount = 0;
            int whiteCount = 0;
            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    if (map[i][j] == 1) {
                        ++blackCount;
                    }
                    else if (map[i][j] == 2) {
                        ++whiteCount;
                    }
                }
            }

            System.out.println("#" + t + " " + blackCount + " " + whiteCount);

        }
    }

    public static void play(int[][] map, int r, int c, int color) {
        map[r][c] = color;
        for (int i=0; i<8; ++i) {
            int nextR = r;
            int nextC = c;
            if (isPossible(map, r, c, color, i)) {
                nextR += rd[i];
                nextC += cd[i];
                while (isValid(map, nextR, nextC) && map[nextR][nextC] != color) {
                    map[nextR][nextC] = color;
                    nextR += rd[i];
                    nextC += cd[i];
                }
            }
        }

    }

    public static boolean isValid(int[][] map, int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[r].length && map[r][c] != 0;
    }

    public static boolean isPossible(int[][] map, int r, int c, int color, int idx) {
        int nextR = r+rd[idx];
        int nextC = c+cd[idx];

        while (isValid(map, nextR, nextC) && map[nextR][nextC] != color) {
            nextR += rd[idx];
            nextC += cd[idx];
        }

        return isValid(map, nextR, nextC);
    }
}
