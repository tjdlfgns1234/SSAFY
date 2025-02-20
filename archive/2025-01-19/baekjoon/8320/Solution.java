import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * j <= N) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
