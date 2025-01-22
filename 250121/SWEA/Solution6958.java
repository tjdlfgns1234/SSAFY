import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6958 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

//          int[][] map = new int[N][M];

            int winnerCount = 0;
            int max = Integer.MIN_VALUE;

            for (int i=0; i<N; ++i) {
                int count = 0;
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; ++j) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        ++count;
                    }
                }

                if (count == max) {
                    ++winnerCount;
                }

                if (count > max) {
                    max = count;
                    winnerCount = 1;
                }
            }

            System.out.println("#" + t + " " + winnerCount + " " + max);
        }
    }

}