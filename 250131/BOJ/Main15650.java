import java.util.*;
import java.lang.*;
import java.io.*;


class Main15650 {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(1, 0, new int[M]);

    }

    public static void recursive(int curr, int idx, int sel[]) {
        if (idx == sel.length) {
            for (int i=0; i<idx; ++i) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        if (curr > N) {
            return;
        }

        sel[idx] = curr;
        recursive(curr+1, idx+1, sel);
        recursive(curr+1, idx, sel);
    }
}