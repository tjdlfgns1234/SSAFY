import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7699 {

    static int max, R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            max = 1;

            String[] trips = new String[R];
            for (int i=0; i<R; ++i) {
                trips[i] = br.readLine();
            }

            boolean[] alpha = new boolean[26];

            dfs(0, 0, trips, alpha, 1);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(max);
            System.out.println(sb);
        }
    }

    public static void dfs(int r, int c, String[] trips, boolean[] alpha, int count) {
        char dest = trips[r].charAt(c);
        if (alpha[dest-'A']) {
            max = Math.max(max, count-1);
            return;
        }

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        alpha[dest-'A'] = true;

        for (int i=0; i<4; ++i) {
            int nextR = r + rd[i];
            int nextC = c + cd[i];
            if (isValid(nextR, nextC)) {
                dfs(nextR, nextC, trips, alpha, count+1);
            }
        }

        alpha[dest-'A'] = false;

    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
