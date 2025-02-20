package solving.swea6730;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int numOfObstacles = sc.nextInt();
            int upMax = 0;
            int downMax = 0;
            int[] obstacles = new int[numOfObstacles];
            for (int i = 0; i < numOfObstacles; i++) {
                obstacles[i] = sc.nextInt();
                if (i > 0) {
                    upMax = Math.max(upMax, obstacles[i] - obstacles[i - 1]);
                    downMax = Math.max(downMax, obstacles[i - 1] - obstacles[i]);
                }
            }
            System.out.printf("#%d %d %d\n", tc, upMax, downMax);
        }
        sc.close();
    }
}
