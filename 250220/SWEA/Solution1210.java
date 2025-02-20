import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1210 {

    static int resultC;
    static int[][] map;
    static int currR, currC, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; ++t) {
            br.readLine();
            N = 100;
            map = new int[N][N];
            resultC = -1;

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        currR = i-1;
                        currC = j;
                    }
                }
            }

            bfs();
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(currC);
            System.out.println(sb);
        }
    }

    public static void bfs() {
        int[] dc = {1, -1};

        while (currR > 0) {
            boolean isMoved = false;
            int nextR = currR;
            int nextC = currC;
            for (int d=0; d<2; ++d) {
                int tmpC = nextC;

                while (isValid(nextR, tmpC + dc[d])) {
                    tmpC += dc[d];
                    isMoved = true;
                }

                if (isMoved) {
                    nextC = tmpC;
                    break;
                }
            }

            currR = nextR-1;
            currC = nextC;
        }

    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length && map[r][c] == 1;
    }

}