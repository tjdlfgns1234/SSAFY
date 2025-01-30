import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */

public class Main16206 {
    static int count = 0;
    static int piece = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cakes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i){
            cakes[i] = Integer.parseInt(st.nextToken());
//            getPiece(Integer.parseInt(st.nextToken()), M);
        }

        Arrays.sort(cakes);

        for (int i=0; i<N; ++i) {
            if (cakes[i] % 10 == 0) {
                getPiece(cakes[i], M);
            }
        }

        for (int i=0; i<N; ++i) {
            if (cakes[i] % 10 != 0) {
                getPiece(cakes[i], M);
            }
        }

        System.out.println(piece);

    }

    public static void getPiece(int cake, int M) {
        while (cake > 10 && count < M) {
            ++piece;
            ++count;
            cake -= 10;
        }

        if (cake == 10) {
            ++piece;
        }
    }
}
