import java.util.*;
import java.io.*;

public class Boj_2470_두용액 {
    public static void main(String[] args) throws Exception {
        //산성 1 ~ 1_000_000_000
        //알칼리성 -1 ~ -1_000_000_000

        //2개 합이 0에 가장 가깝게
        //two sum

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] acid = new int[N];
        for (int i = 0; i < N; i++) {
            acid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(acid);
        int start = 0;
        int end = N-1;
        int ans = Integer.MAX_VALUE;
        int s1 = start, s2 = end;
        int sum;
        while (start < end) {
            sum = acid[start] + acid[end];

            if (Math.abs(sum) < ans) {
                ans = Math.abs(sum);
                s1 = start;
                s2 = end;
                if (sum == 0) break;
            }
            if (sum < 0) {
                start += 1;
            }

            else {
                end -=1;
            }
        }
        System.out.println(acid[s1] + " " + acid[s2]);
    }
}

/**
 5
 -99999999 -99999 0 1 2
 */
