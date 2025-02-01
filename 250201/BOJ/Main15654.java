import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0, new int[M], 0, new boolean[N]);

        System.out.println(sb);
    }

    public static void recursive(int idx, int[] sel, int depth, boolean[] v) {
        if (depth == sel.length) {
            for (int i=0; i<depth; ++i) {
                sb.append(sel[i]);
                sb.append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i=0; i<N; ++i) {
            if (!v[i]) {
                v[i] = true;
                sel[depth] = arr[i];
                recursive(idx + 1, sel, depth + 1, v);
                v[i] = false;
            }
        }
    }
}
