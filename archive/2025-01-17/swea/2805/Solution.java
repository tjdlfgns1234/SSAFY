import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// N은 항상 홀수입니다.
// 수확은 항상 정사각형 크기에 딱 맞는 마름모입니다.

public class Solution {
    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("./swea/solving/2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // T = 1;
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }

            // print2DArray(farm, N);

            int answer = harvestInDiamond(farm);

            System.out.println("#" + testCase + " " + answer);
        }
        br.close();
    }

    private static void print2DArray(int[][] arr, int N) {
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int harvestInDiamond(int[][] arr) {
        int yield = 0;
        int rows = arr.length;
        int cols = rows; // square
        int rowCenter = (int) (rows / 2);
        int colCenter = (int) (cols / 2);
        for (int i = 0; i < rowCenter; i++) {
            int start = colCenter - i;
            int end = colCenter + i;
            for (int j = start; j <= end; j++) {
                // System.out.print(arr[i][j] + " ");
                yield += arr[i][j];
            }
            // System.out.println();
        }
        for (int i = 0; i < cols; i++) {
            // System.out.print(arr[rowCenter][i] + " ");
            yield += arr[rowCenter][i];
        }
        // System.out.println();
        int count = 1;
        for (int i = rowCenter + 1; i < rows; i++) {
            int start = 0 + count;
            int end = cols - count;
            for (int j = start; j < end; j++) {
                // System.out.print(arr[i][j] + " ");
                yield += arr[i][j];
            }
            // System.out.println();
            count++;
        }

        return yield;
    }
}