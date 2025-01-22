import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6485 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int[] B = new int[N];

            int[] counts = new int[5001];

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
                for (int j=A[i]; j<=B[i]; ++j) {
                    ++counts[j];
                }
            }

            int P = Integer.parseInt(br.readLine());
            int[] arr = new int[P];
            for (int i=0; i<P; ++i) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            System.out.print("#" + t + " ");
            for (int a : arr) {
                System.out.print(counts[a] + " ");
            }
            System.out.println();


        }
    }

}