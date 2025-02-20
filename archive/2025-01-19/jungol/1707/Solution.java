import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        fillAndPrint(N);
    }

    public static void fillAndPrint(int N) {
        int[][] output = new int[N][N];
        int number = 1; // 채울 숫자
        int M = N; // 채울 횟수
        int x = 0, y = -1;
        while (M > 0) {
            for (int i = 0; i < M; i++) {
                y += 1;
                output[x][y] = number;
                number += 1;
            }
            M -= 1;
            for (int i = 0; i < M; i++) {
                x += 1;
                output[x][y] = number;
                number += 1;
            }
            for (int i = 0; i < M; i++) {
                y -= 1;
                output[x][y] = number;
                number += 1;
            }
            M -= 1;
            for (int i = 0; i < M; i++) {
                x -= 1;
                output[x][y] = number;
                number += 1;
            }
        }
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < N; j++) {
                sb.append(output[i][j] + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
