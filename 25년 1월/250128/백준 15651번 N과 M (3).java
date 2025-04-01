import java.io.*;
import java.util.*;

public class Main {

    static int n = 1;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        recursive(new boolean[n + 1], new int[n + 1], 1, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void recursive(boolean[] sel, int[] arr, int idx, int cnt) {
        if (cnt == m) {
            for (int i = 1; i <= m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx >= arr.length) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
                arr[idx] = i;
                recursive(sel, arr, idx + 1, cnt + 1);
                arr[idx] = 0;
            
        }
    }
}