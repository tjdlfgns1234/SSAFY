import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] snail = new int[N][N];
            int row = 0, col = -1;
            int num = 1;
            while (N > 0) {
                // R
                for (int i = 1; i <= N; i++) {
                    col += 1;
                    snail[row][col] = num;
                    num++;
                }
                N--;
                // D
                for (int i = 1; i <= N; i++) {
                    row += 1;
                    snail[row][col] = num;
                    num++;
                }
                // L
                for (int i = 1; i <= N; i++) {
                    col -= 1;
                    snail[row][col] = num;
                    num++;
                }
                N--;
                // U
                for (int i = 1; i <= N; i++) {
                    row -= 1;
                    snail[row][col] = num;
                    num++;
                }
            }
            sb.append("#" + tc + "\n");
            for (int i = 0; i < snail.length; i++) {
                for (int j = 0; j < snail.length; j++) {
                    sb.append(snail[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
