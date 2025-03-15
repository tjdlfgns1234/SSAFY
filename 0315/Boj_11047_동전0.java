import java.util.*;
import java.io.*;

public class Boj_11047_동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  //N종류
        int K = Integer.parseInt(st.nextToken());  //목표 가치

        //동전개수 최소값

        int[] value = new int[N];
        for (int i = N-1; i >= 0; i--) {
            value[i] = Integer.parseInt(br.readLine());
        }


        //각 동전 개수 제한 X
        //필요한 동전 개수 최소값 -> 큰 동전부터

        int sum = K;
        int cnt = 0;
        int idx = 0;
        while (true) {
            while (sum >= value[idx]) {
                sum -= value[idx];
                cnt++;
            }

            if (sum == 0) {
                break;
            }
            idx++;
        }
        System.out.println(cnt);
    }
}
