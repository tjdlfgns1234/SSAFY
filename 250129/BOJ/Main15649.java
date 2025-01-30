import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M - 1
 * 1~N중 M개를 선택하는 경우 (순서 있음) -> 순열 nPm
 */

public class Main15649 {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(new boolean[N+1], 0, new int[M]);
    }

    public static void recursive(boolean[] v, int depth, int[] sel) {
        if (depth == sel.length) {
            for (int i=0; i<sel.length; ++i) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<=N; ++i) {
            if (!v[i]) {
                v[i] = true;
                sel[depth] = i;
                recursive(v, depth+1, sel);
                v[i] = false;
            }

        }

    }
}
