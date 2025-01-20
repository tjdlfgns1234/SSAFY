import java.util.*;
import java.lang.*;
import java.io.*;

class Main2563 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];
        int N = Integer.parseInt(br.readLine());

        for (int n=0; n<N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int i=r; i<r+10; ++i) {
                for (int j=c; j<c+10; ++j) {
                    arr[i][j] = 1;
                }
            }
        }

        int result = 0;
        for (int[] row : arr) {
            for (int i : row ) {
                result += i;
            }
        }

        System.out.println(result);
    }
}