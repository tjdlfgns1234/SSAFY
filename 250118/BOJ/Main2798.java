import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            int sum = 0;
            if (cards[i] > M) {
                continue;
            }

            sum += cards[i];
            for (int j=i+1; j<N; ++j) {
                if (sum + cards[j] > M) {
                    continue;
                }

                sum += cards[j];
                for (int k=j+1; k<N; ++k) {
                    if (sum + cards[k] > M) {
                        continue;
                    }

                    max = Math.max(max, sum+cards[k]);
                }
                sum -= cards[j];
            }
        }

        System.out.println(max);
    }
}
