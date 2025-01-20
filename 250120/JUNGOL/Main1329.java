import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1329 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 1 || N > 100 || N % 2 == 0) {
            System.out.println("INPUT ERROR!");
            return;
        }

        for (int i=0; i<N/2; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<i; ++j) {
                sb.append(" ");
            }
            for (int k=0; k<2*i+1; ++k) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i=N/2; i<N; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<N-i-1; ++j) {
                sb.append(" ");
            }
            for (int k=0; k<2*(N-i)-1; ++k) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}
