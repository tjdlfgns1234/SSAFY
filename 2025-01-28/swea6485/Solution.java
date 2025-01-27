package solving.swea6485;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int[] busStationCount = new int[5001];
            int N = sc.nextInt(); // 버스 노선의 수
            int start, end;
            for (int i = 0; i < N; i++) {
                start = sc.nextInt();
                end = sc.nextInt();
                for (int j = start; j <= end; j++) {
                    busStationCount[j] += 1;
                }
            }

            System.out.printf("#%d", tc);
            int P = sc.nextInt(); // 확인할 버스 노선의 수
            for (int i = 0; i < P; i++) {
                System.out.printf(" %d", busStationCount[sc.nextInt()]);
            }
            System.out.println();
        }

        sc.close();
    }
}
