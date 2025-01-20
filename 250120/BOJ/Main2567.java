import java.util.*;
import java.lang.*;
import java.io.*;

class Main2567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[100][100];
        for (int n=0; n<N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i=r; i<r+10; ++i) {
                for (int j=c; j<c+10; ++j) {
                    map[i][j] = 1;
                }
            }
        }

        int result = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        for (int i=0; i<100; ++i) {
            for (int j=0; j<100; ++j) {
                if ((i == 0 || j == 0 || i == (100-1) || j == (100-1)) && map[i][j] == 1) {
                    ++result;
                    if ((i == 0 && j == 0) || (i == 0 && j == (100-1)) || (i == (100-1) && j == 0) || (i == (100-1) && j == (100-1))) {
                        ++result;
                    }
                    continue;
                }

                if (map[i][j] == 0) {
                    for (int d=0; d<4; ++d) {
                        if (isValid(map, i+dr[d], j+dc[d])) {
                            ++result;
                        }
                    }
                }
            }
        }



        System.out.println(result);
    }

    public static boolean isValid(int[][] map, int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length && map[r][c] == 1;
    }
}