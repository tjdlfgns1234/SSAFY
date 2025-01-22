import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6730 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i=0; i<N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int upMax = 0;
            int downMax = 0;

            for (int i=0; i<N-1; ++i) {
                if (arr[i] < arr[i+1]) {
                    upMax = Math.max(upMax, arr[i+1] - arr[i]);
                }
                else {
                    downMax = Math.max(downMax,  arr[i] - arr[i+1]);
                }
            }

            System.out.println("#" + t + " " + upMax + " " + downMax);

        }

    }

}