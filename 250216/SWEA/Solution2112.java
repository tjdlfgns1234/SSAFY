import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2112 {

    static int D, W, K;
    static int[][] map;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = -1;

            map = new int[D][W];
            for (int i=0; i<D; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<W; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<D; ++i) {
                recursive(new int[i], new int[i], 0, 0);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(min);
            System.out.println(sb);
        }
    }

    // 0 ~ D-1까지 1~D-1개 고르기
    public static void recursive(int[] sel, int[] sel2, int idx, int curr) {
        if (min != -1) return;

        if (idx == sel.length) {
            // 약품 투입
            // 합격 기준 체크
            if (check(sel, sel2)) {
                min = sel.length;
            }

            return;
        }

        if (curr >= D) {
            return;
        }

        sel[idx] = curr;
        sel2[idx] = 0;
        recursive(sel, sel2, idx+1, curr+1);
        sel2[idx] = 1;
        recursive(sel, sel2, idx+1, curr+1);
        recursive(sel, sel2, idx, curr+1);
    }

    public static boolean check(int[] sel, int[] sel2) {
        for (int j=0; j<W; ++j) {
            int idx = 0;
            int prev = -1;
            int count = 0;
            for (int i=0; i<D; ++i) {
                if (idx < sel.length && i == sel[idx]) {
                    if (prev == sel2[idx]) {
                        ++count;
                    }
                    else {
                        count = 1;
                        prev = sel2[idx];
                    }
                    ++idx;
                }

                else if (map[i][j] != prev) {
                    count = 1;
                    prev = map[i][j];
                }
                else {
                    ++count;
                }
                if (count >= K) break;
            }
            if (count < K) return false;
        }

        return true;
    }
}