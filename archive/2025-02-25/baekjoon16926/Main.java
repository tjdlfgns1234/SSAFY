package solving.baekjoon16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 바깥 껍질부터 아래로 한껍질 씩 회전시키기
 * 해당 반복문의 횟수는, row/col 중에 작은 수 / 2
 */

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int row = toNum(line[0]);
            int col = toNum(line[1]);
            int rotateTimes = toNum(line[2]);

            int[][] arr = new int[row][col];

            for (int i = 0; i < row; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 0; j < col; j++) {
                    arr[i][j] = toNum(line[j]);
                }
            }

            rotateArr(arr, row, col, rotateTimes, Math.min(row, col) / 2);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static void rotateArr(int[][] arr, int row, int col, int rotateTimes, int skinDepth) {
        int lastRow = row - 1;
        int lastCol = col - 1;
        // for (int i = 0; i < rotateTimes; i++) {
        for (int j = 0; j < skinDepth; j++) {
            int modRotateTimes = rotateTimes % ((row - (j * 2) - 1 + col - (j * 2) - 1) * 2);
            /*
             * 이만큼 시뮬레이션 안돌리고 N번 돌렸을때 이 값이 어디로 가야하는지 확인해서
             * 바로바로 대입하는 코드도 가능할 것 같은데.
             */
            for (int l = 0; l < modRotateTimes; l++) {
                int prev = arr[j][j];
                int temp;
                // down
                for (int k = j + 1; k < row - j; k++) {
                    temp = arr[k][j];
                    arr[k][j] = prev;
                    prev = temp;
                }
                // right
                for (int k = j + 1; k < col - j; k++) {
                    temp = arr[lastRow - j][k];
                    arr[lastRow - j][k] = prev;
                    prev = temp;
                }
                // up
                for (int k = row - j - 2; k >= j; k--) {
                    temp = arr[k][lastCol - j];
                    arr[k][lastCol - j] = prev;
                    prev = temp;
                }
                // left
                for (int k = col - j - 2; k >= j; k--) {
                    temp = arr[j][k];
                    arr[j][k] = prev;
                    prev = temp;
                }
            }
        }
        // }
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
