import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(1, 0, new int[M]);

        System.out.println(sb);
    }

    //이전 값보다 현재 값이 크거나 같아야 함
    public static void recursive(int prev, int idx, int[] sel) {
        if (idx == sel.length) {
            for (int i=0; i<idx; ++i) {
                sb.append(sel[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=prev; i<=N; ++i) {
            sel[idx] = i;
            recursive(i,idx+1, sel);
        }
    }
}
