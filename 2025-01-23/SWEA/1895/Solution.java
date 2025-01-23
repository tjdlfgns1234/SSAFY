import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
          
            // 문제 조건 잘 확인하기 100만 * 1만 값이 저장될 수 있다
            long max_value = num[n - 1];
            long result = 0l;

            for (int i = n - 1; i >= 0; i--) {
                if (max_value <= num[i]) {
                    max_value = num[i];
                } else {
                    result += max_value - num[i];
                }
            }
            System.out.printf("#%d %d\n",t, result);
        }
    }
}
