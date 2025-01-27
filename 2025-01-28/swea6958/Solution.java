package solving.swea6958;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int peopleCount = sc.nextInt();
            int problemCount = sc.nextInt();
            int[] scoreTable = new int[peopleCount];
            // 1등한 사람의 수와 1등이 푼 문제의 수
            int maxScore = 0;
            int winnerCount = 0;

            for (int i = 0; i < peopleCount; i++) {
                int score = 0;
                for (int j = 0; j < problemCount; j++) {
                    score += sc.nextInt();
                }
                maxScore = Math.max(maxScore, score);
                scoreTable[i] = score;
            }
            for (int score : scoreTable) {
                if (score == maxScore) {
                    winnerCount += 1;
                }
            }
            System.out.printf("#%d %d %d\n", tc, winnerCount, maxScore);
        }
        sc.close();
    }
}
