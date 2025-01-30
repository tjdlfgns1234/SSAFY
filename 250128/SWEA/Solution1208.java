import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1208 {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution1208.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int K = 100;
            int[] arr = new int[K];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<K; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<N; ++i) {
                Arrays.sort(arr);
                arr[K-1] -= 1;
                arr[0] += 1;
            }

            Arrays.sort(arr);
            System.out.println("#" + t + " " + (arr[K-1] - arr[0]));
        }


    }
}
