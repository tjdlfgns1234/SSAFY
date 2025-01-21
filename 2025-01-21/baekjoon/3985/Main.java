package BAEKJOON.solving.b3985;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/b3985/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int cakeLen = sc.nextInt();
            int watcher = sc.nextInt();
            int maxGreedy = 0;
            int greedyWatcher = 0;
            int[] rollCake = new int[cakeLen + 1];
            int[] numOfCakeForWatcher = new int[watcher + 1];
            int realMaxCakeCount = 0;
            int realMaxCakeWacher = 0;

            for (int i = 1; i <= watcher; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                if (maxGreedy < end - start + 1) {
                    greedyWatcher = i;
                    maxGreedy = end - start + 1;
                }
                for (int j = start; j <= end; j++) {
                    if (rollCake[j] == 0) {
                        rollCake[j] = i;
                    }
                }
            }
            for (int i = 1; i < rollCake.length; i++) {
                if (rollCake[i] == 0)
                    continue;
                numOfCakeForWatcher[rollCake[i]] += 1;
                if (realMaxCakeCount < numOfCakeForWatcher[rollCake[i]]) {
                    realMaxCakeCount = numOfCakeForWatcher[rollCake[i]];
                    realMaxCakeWacher = rollCake[i];
                } else if (realMaxCakeCount == numOfCakeForWatcher[rollCake[i]]) {
                    if (realMaxCakeWacher > rollCake[i]) {
                        realMaxCakeWacher = rollCake[i];
                    }
                }
            }

            System.out.println(greedyWatcher);
            System.out.println(realMaxCakeWacher);
        }
    }
}