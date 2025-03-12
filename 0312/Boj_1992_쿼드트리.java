import java.util.*;
import java.io.*;

public class Boj_1992_쿼드트리 {
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }
        System.out.println(divide(0,0, N));
    }

    public static String divide(int r, int c, int n) {
        if (n == 1) return String.valueOf(map[r][c]);

        //체크
        int result = compactable(r,c,n);
        //압축가능
        if (result > -1)  return String.valueOf(result);
//        System.out.println(r + "," + c + "," + result + "," + n);

        //불가능
        //4분할 쪼개기
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        //왼위
        sb.append(divide(r,c,n/2));
        //오위
        sb.append(divide(r,c + n/2, n /2));
        //왼아래
        sb.append(divide(r + n/2, c, n / 2));
        //오아래
        sb.append(divide(r + n/2, c + n/2, n / 2));
        sb.append(")");
//        System.out.println(sb);
        return sb.toString();
    }

    static int compactable(int r, int c, int n) {
        int prev = map[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[i][j] != prev) return -1;
            }
        }
        return prev;
    }
}
