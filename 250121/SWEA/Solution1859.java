import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1859 {

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

            long result = 0;
            int max = Integer.MIN_VALUE;

            for (int i=arr.length-1; i>=0; --i) {
                if (arr[i] > max) {
                    max = arr[i];
                    continue;
                }

                result += max - arr[i];
            }

            System.out.println("#" + t + " " + result);
        }
    }

}