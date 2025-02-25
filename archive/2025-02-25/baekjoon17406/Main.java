package solving.baekjoon17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 배열 돌리기 4
 * 특정 부분배열만 회전시키는 값 K개
 * 주어진 K 개의 수행의 순서를 자유롭게 시행해
 * 최종 배열의 각 행의 모든수의 합 중 최솟값을 찾아라
 * 
 * 순열 만들고 돌리기 vs 순열 만들면서 돌리고 다시 역으로 되돌리기
 * 
 * 순열 만들고 돌리기가 더 시간이 많이 걸릴 것 같아 후자로 짰습니다
 * 
 * 조합만들기
 * 주어진 조건 시계방향 돌리기, 되돌리기
 */

public class Main {
    static int minVal;

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");

        int row = toNum(line[0]);
        int col = toNum(line[1]);
        int rotateTimes = toNum(line[2]);

        int[][] arr = new int[row][col];
        int[][] rotateVariables = new int[rotateTimes][3];

        for (int i = 0; i < row; i++) {
            line = br.readLine().trim().split(" ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = toNum(line[j]);
            }
        }

        for (int i = 0; i < rotateTimes; i++) {
            line = br.readLine().trim().split(" ");
            for (int j = 0; j < 3; j++) {
                rotateVariables[i][j] = toNum(line[j]) - 1;
            }
            rotateVariables[i][2]++;
        }

        minVal = Integer.MAX_VALUE;
        permutation(rotateVariables, new boolean[rotateTimes], 0, arr);

        bw.write(minVal + "");
        bw.newLine();
        bw.flush();
    }

    private static void permutation(int[][] rotateVariables, boolean[] v, int idx, int[][] arr) {
        if (idx == v.length) {
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int temp : arr[i]) {
                    sum += temp;
                }
                minVal = Math.min(minVal, sum);
            }
            return;
        }

        for (int i = 0; i < v.length; i++) {
            if (!v[i]) {
                v[i] = true;
                rotate(arr, rotateVariables[i][0], rotateVariables[i][1], rotateVariables[i][2]);
                permutation(rotateVariables, v, idx + 1, arr);
                rotateReverse(arr, rotateVariables[i][0], rotateVariables[i][1], rotateVariables[i][2]);
                v[i] = false;
            }
        }
    }

    private static void print(int[][] arr) {
        for (int[] is : arr) {
            System.out.println(Arrays.toString(is));
        }
    }

    private static void rotate(int[][] arr, int r, int c, int s) {
        int startRow = r - s;
        int startCol = c - s;

        int endRow = r + s;
        int endCol = c + s;

        int temp = 0;

        for (int i = 0; i < s; i++) {
            int thisRowStart = startRow + i;
            int thisColStart = startCol + i;

            int thisRowEnd = endRow - i;
            int thisColEnd = endCol - i;

            int prev = arr[thisRowStart][thisColStart];

            // to right
            for (int j = thisColStart + 1; j <= thisColEnd; j++) {
                temp = arr[thisRowStart][j];
                arr[thisRowStart][j] = prev;
                prev = temp;
            }
            // to down
            for (int j = thisRowStart + 1; j <= thisRowEnd; j++) {
                temp = arr[j][thisColEnd];
                arr[j][thisColEnd] = prev;
                prev = temp;
            }
            // to left
            for (int j = thisColEnd - 1; j >= thisColStart; j--) {
                temp = arr[thisRowEnd][j];
                arr[thisRowEnd][j] = prev;
                prev = temp;
            }
            // to up
            for (int j = thisRowEnd - 1; j >= thisRowStart; j--) {
                temp = arr[j][thisColStart];
                arr[j][thisColStart] = prev;
                prev = temp;
            }
        }
    }

    private static void rotateReverse(int[][] arr, int r, int c, int s) {
        int startRow = r - s;
        int startCol = c - s;

        int endRow = r + s;
        int endCol = c + s;

        int temp = 0;

        for (int i = 0; i < s; i++) {
            int thisRowStart = startRow + i;
            int thisColStart = startCol + i;

            int thisRowEnd = endRow - i;
            int thisColEnd = endCol - i;

            int prev = arr[thisRowStart][thisColStart];

            // to down
            for (int j = thisRowStart + 1; j <= thisRowEnd; j++) {
                temp = arr[j][thisColStart];
                arr[j][thisColStart] = prev;
                prev = temp;
            }
            // to right
            for (int j = thisColStart + 1; j <= thisColEnd; j++) {
                temp = arr[thisRowEnd][j];
                arr[thisRowEnd][j] = prev;
                prev = temp;
            }
            // to up
            for (int j = thisRowEnd - 1; j >= thisRowStart; j--) {
                temp = arr[j][thisColEnd];
                arr[j][thisColEnd] = prev;
                prev = temp;
            }
            // to left
            for (int j = thisColEnd - 1; j >= thisColStart; j--) {
                temp = arr[thisRowStart][j];
                arr[thisRowStart][j] = prev;
                prev = temp;
            }
        }
    }

    private static int toNum(String string) {
        return Integer.parseInt(string);
    }
}
