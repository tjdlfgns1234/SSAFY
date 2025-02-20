package swea.swea6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static int myWin, vsWin;
    static int[] myCards, vsCards; // 내 카드 순서대로

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            boolean[] cards = new boolean[19]; // 총 카드중에 내가 받은 카드 표시
            myCards = new int[9];
            vsCards = new int[9];
            for (int i = 0; i < line.length; i++) {
                int nowCard = Integer.parseInt(line[i]);
                cards[nowCard] = true;
                myCards[i] = nowCard;
            }
            int idx = 0;
            for (int i = 1; i < cards.length; i++) {
                if (cards[i] == false) {
                    vsCards[idx] = i;
                    idx += 1;
                }
            }
            myWin = vsWin = 0;
            permutation(0, 0, new boolean[vsCards.length], 0);
            // permutation2(0, new int[9], new boolean[9]);
            sb.append("#" + tc + " " + myWin + " " + vsWin + "\n");
        }
        System.out.print(sb.toString());
    }

    private static void permutation(int mySum, int vsSum, boolean[] v, int idx) {
        // 순열을 만들면서 계산해 (사실 DFS)
        if (idx == vsCards.length) {
            if (mySum > vsSum) {
                myWin += 1;
            } else if (vsSum > mySum) {
                vsWin += 1;
            }
            return;
        }
        for (int i = 0; i < vsCards.length; i++) {
            if (v[i] == false) {
                v[i] = true;
                int score = myCards[idx] + vsCards[i];
                if (myCards[idx] > vsCards[i]) {
                    permutation(mySum + score, vsSum, v, idx + 1);
                } else {
                    permutation(mySum, vsSum + score, v, idx + 1);
                }
                v[i] = false;
                // permutaion(myCards, vsCards, mySum, vsSum, v, idx);
            }
        }
    }

    private static void permutation2(int idx, int[] cards, boolean[] v) {
        // 일단 순열을 만들어, 그리고 계산해
        if (idx == cards.length) {
            int mySum = 0;
            int vsSum = 0;
            for (int i = 0; i < cards.length; i++) {
                int score = myCards[i] + cards[i];
                if (myCards[i] > cards[i]) {
                    mySum += score;
                } else {
                    vsSum += score;
                }
            }
            if (mySum > vsSum) {
                myWin += 1;
            } else if (mySum < vsSum) {
                vsWin += 1;
            }
            return;
        }

        for (int i = 0; i < v.length; i++) {
            if (v[i] == false) {
                v[i] = true;
                cards[idx] = vsCards[i];
                permutation2(idx + 1, cards, v);
                v[i] = false;
                // permutation2(idx, cards, v);
            }
        }
    }
}
