import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R, ord;
    static int[][] map;
    static int[][] result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            ord = Integer.parseInt(st.nextToken());
            switch(ord) {
                case 1:
                    turn1();
                    break;
                case 2:
                    turn2();
                    break;
                case 3:
                    turn3();
                    break;
                case 4:
                    turn4();
                    break;
                case 5:
                    turn5();
                    break;
                case 6:
                    turn6();
                    break;
            }
        }



        print();

    }

    static void print() {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 상하
    static void turn1() {
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[N-1-i][j] = map[i][j];
            }
        }
        map = result;
    }

    //좌우
    static void turn2() {
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][M-1-j] = map[i][j];
            }
        }
        map = result;
    }

    //오른쪽 90
    static void turn3() {
        result = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[j][N-1-i] = map[i][j];
            }
        }
        map = result;
        int temp = N;
        N = M;
        M = temp;
    }

    //왼쪽 90
    static void turn4() {
        result = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M; j++) {
                result[M - 1 -j][i] = map[i][j];
            }
        }
        map = result;
        int temp = N;
        N = M;
        M = temp;
    }

    //1->2, 2->3, 3->4, 4->1
    static void turn5() {
        int x_center = N / 2;
        int y_center = M / 2;
        result = new int[N][M];
        // 1 -> 2
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[i][y_center+j] = map[i][j];
            }
        }

        // 2 -> 3
        for (int i = 0; i < x_center; i++) {
            for (int j = y_center; j < M; j++) {
                result[x_center + i][j] = map[i][j];
            }
        }

        // 3 -> 4
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[x_center + i][j] = map[x_center + i][y_center + j];
            }
        }

        // 4 -> 1
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[i][j] = map[x_center + i][j];
            }
        }
        map = result;
    }

    // 1->4, 4->3, 3->2, 2->1
    static void turn6() {
        int x_center = N / 2;
        int y_center = M / 2;

        result = new int[N][M];

        // 1 <- 2
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[i][j] = map[i][y_center + j];
            }
        }

        // 2 <- 3
        for (int i = 0; i < x_center; i++) {
            for (int j = y_center; j < M; j++) {
                result[i][j] = map[x_center + i][j];
            }
        }

        // 3 <- 4
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[x_center + i][y_center + j] = map[x_center + i][j];
            }
        }

        // 4 <- 1
        for (int i = 0; i < x_center; i++) {
            for (int j = 0; j < y_center; j++) {
                result[x_center + i][j] = map[i][j];
            }
        }
        map = result;
    }
}
