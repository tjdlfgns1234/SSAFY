package solving.swea1859;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int days = sc.nextInt();
            int[] prices = new int[days];
            int max = Integer.MIN_VALUE;
            long sumOfProfit = 0;
            boolean[] traded = new boolean[days];

            for (int i = 0; i < days; i++) {
                prices[i] = sc.nextInt();
                max = Math.max(max, prices[i]);
            }

            // max를 만나면 이전 날들을 거래
            for (int i = 0; i < days; i++) {
                if (prices[i] == max) {
                    for (int j = i; j >= 0; j--) {
                        // i 부터 시작하는 이유는 판 날도 거래했기 때문이고, 0을 더해주기 때문에 문제가 없을 것
                        if (traded[j] == false) {
                            sumOfProfit += (max - prices[j]);
                        } else if (traded[j] == true) {
                            // 이미 traded를 만났을 경우 그 이전에는 모두 거래했을 것이기 때문에 멈춘다.
                            break;
                        }
                        traded[j] = true;
                    }
                    // max 를 한번 만났으니 이제 남은 이후에서 max를 또 찾기
                    max = Integer.MIN_VALUE;
                    for (int j = i + 1; j < days; j++) {
                        max = Math.max(prices[j], max);
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, sumOfProfit);
        }

        sc.close();
    }
}
