import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());

            int currV = 0;
            int d = 0;

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                if (c == 1) {
                    currV += Integer.parseInt(st.nextToken());
                }
                else if (c == 2) {
                    currV -= Integer.parseInt(st.nextToken());
                    if (currV < 0) {
                        currV = 0;
                    }
                }
                d += currV;
            }

            System.out.println("#" + t + " " + d);
        }
    }
}
