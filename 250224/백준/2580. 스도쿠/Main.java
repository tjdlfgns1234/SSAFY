import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[9][9];
        for (int i = 0 ; i < 9 ; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0 ; j < 9 ; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (solve()) {
            for (int i = 0 ; i < 9 ; i++) {
                for (int j = 0 ; j < 9 ; j++) {
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
        } else {
            System.out.println("ERROR");
        }

        bw.flush();
        bw.close();
    }

    private static boolean solve() {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (map[i][j] == 0) {
                    for (int num = 1 ; num <= 9 ; num++) {
                        if (check(i, j, num)) {
                            map[i][j] = num;
                            if (solve()) { // 재귀
                                return true;
                            }
                            map[i][j] = 0; // 백트래킹
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check(int row, int col, int num) {
        for (int i = 0; i < 9; i++) { // 세로
            if (map[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) { // 가로
            if (map[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 3 * 3
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
