package solving.baekjoon17144;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 확산과 순환 두개의 함수
 * 확산의 경우는 순차적으로 탐색하며 확산 시키고 다음 칸을 보는 경우
 * 원하지 않는 결과가 나올 수 있기 때문에 배열을 복사하여 증감연산을 저장 후
 * 모든 공간을 탐색한 이후에 원래 배열에 더해준다.
 * 순환은 반시계, 시계를 만들어 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int R = toNum(line[0]);
            int C = toNum(line[1]);
            int sec = toNum(line[2]);
            int[] aircleaner = new int[2];
            int cleaner = 0;
            int[][] map = new int[R][C];

            for (int i = 0; i < R; i++) {
                line = br.readLine().trim().split(" ");
                if (toNum(line[0]) == -1) {
                    aircleaner[cleaner++] = i;
                }
                for (int j = 0; j < C; j++) {
                    map[i][j] = toNum(line[j]);
                }
            }
            // ----- input -----

            timeSpend(sec, map, R, C, aircleaner);
            int sum = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        sum += map[i][j];
                    }
                }
            }
            // ----- solution -----

            bw.write(sum + "");
            bw.newLine();
        }
        bw.flush();
    }

    private static void timeSpend(int sec, int[][] map, int r, int c, int[] aircleaner) {
        for (int i = 0; i < sec; i++) {
            spread(map, r, c);
            circulation(map, r, c, aircleaner);
        }
    }

    private static void circulation(int[][] map, int r, int c, int[] aircleaner) {
        upperCirculation(map, r, c, aircleaner[0]);
        lowerCirculation(map, r, c, aircleaner[1]);
    }

    private static void lowerCirculation(int[][] map, int r, int c, int aircleaner) {
        int prev = 0;
        int temp = 0;
        // 오른쪽
        for (int i = 1; i < c; i++) {
            temp = map[aircleaner][i];
            map[aircleaner][i] = prev;
            prev = temp;
        }
        // 아래쪽
        for (int i = aircleaner + 1; i < r; i++) {
            temp = map[i][c - 1];
            map[i][c - 1] = prev;
            prev = temp;
        }
        // 왼쪽
        for (int i = c - 2; i >= 0; i--) {
            temp = map[r - 1][i];
            map[r - 1][i] = prev;
            prev = temp;
        }
        // 위쪽
        for (int i = r - 2; i > aircleaner; i--) {
            temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    private static void upperCirculation(int[][] map, int r, int c, int aircleaner) {
        int prev = 0;
        int temp = 0;
        // 오른쪽
        for (int i = 1; i < c; i++) {
            temp = map[aircleaner][i];
            map[aircleaner][i] = prev;
            prev = temp;
        }
        // 위쪽
        for (int i = aircleaner - 1; i >= 0; i--) {
            temp = map[i][c - 1];
            map[i][c - 1] = prev;
            prev = temp;
        }
        // 왼쪽
        for (int i = c - 2; i >= 0; i--) {
            temp = map[0][i];
            map[0][i] = prev;
            prev = temp;
        }
        // 아래쪽
        for (int i = 1; i < aircleaner; i++) {
            temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    private static void spread(int[][] map, int r, int c) {
        // 탐색하며 바로바로 증감연산을 수행하면 다음 탐색에서 문제가 생길 수 있으니
        // 증감연산을 저장하고 마지막에 더해준다.

        // 증감연산 저장 배열
        int[][] addArr = new int[r][c];
        // 사방탐색
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    for (int direction = 0; direction < 4; direction++) {
                        int nr = i + dr[direction];
                        int nc = j + dc[direction];
                        if (spreadable(map, r, c, nr, nc)) {
                            int temp = map[i][j] / 5;
                            addArr[i][j] -= temp;
                            addArr[nr][nc] += temp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += addArr[i][j];
            }
        }
    }

    private static boolean spreadable(int[][] map, int r, int c, int nr, int nc) {
        return isInMap(nr, nc, r, c) && map[nr][nc] != -1;
    }

    private static boolean isInMap(int nr, int nc, int r, int c) {
        return nr >= 0 && nc >= 0 && nr < r && nc < c;
    }

    private static int toNum(String string) {
        return Integer.parseInt(string);
    }
}