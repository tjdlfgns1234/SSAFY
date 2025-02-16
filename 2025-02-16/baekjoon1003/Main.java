package baekjoon.baekjoon1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 피보나치 수 0, 1, 호출 횟수 세기
 * 당연히 재귀는 시간 초과가 날 것
 * 1이 더 많이 호출 될 것, 1, 2, 3 호출 시 재귀로 다 불림
 * 0의 경우 1, 2의 경우에만 호출
 * 
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int inputNum = Integer.parseInt(br.readLine().trim());
            for (int in = 0; in < inputNum; in++) {
                int n = Integer.parseInt(br.readLine().trim());
                int[] result = fibbo01Count(n);
                System.out.printf("%d %d\n", result[0], result[1]);
            }
        }
    }

    private static int[] fibbo01Count(int n) {
        // 0이거나 1인 경우 반환
        if (n == 0)
            return new int[] { 1, 0 };
        if (n == 1)
            return new int[] { 0, 1 };

        // 기록하면서 count를 셀 준비
        int[] count0 = new int[n + 1];
        int[] count1 = new int[n + 1];

        // 0 또는 1인 경우에 카운트 생성
        count0[0] = 1;
        count0[1] = 0;
        count1[0] = 0;
        count1[1] = 1;

        // n까지 0,1이 얼마나 불렸는지 저장
        for (int i = 2; i <= n; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        // 반환
        return new int[] { count0[n], count1[n] };

    }
}
