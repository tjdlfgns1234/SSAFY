import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main8320 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i=0; i<N; ++i) {
//            int solve = solve(i+1);
//            System.out.println(solve);
            result += solve(i+1);
        }

        System.out.println(result);
    }

    public static int solve(int num) {
        if (num == 1) return 1;

        int count = 0;
        for (int i=1; i<=Math.sqrt(num); ++i) {
            count += num % i == 0 ? 1 : 0;
        }

        return count;
    }
}
