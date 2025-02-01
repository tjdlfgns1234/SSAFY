import java.util.*;
import java.lang.*;
import java.io.*;


class Main15651 {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(0, new int[M]);

        System.out.println(sb);
    }

    public static void recursive(int idx, int[] sel) {
        if (idx == sel.length) {
            for (int i=0; i<idx; ++i) {
                sb.append(sel[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; ++i) {
            sel[idx] = i;
            recursive(idx+1, sel);
        }
    }
}