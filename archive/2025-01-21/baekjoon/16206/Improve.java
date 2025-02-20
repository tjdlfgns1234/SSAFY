package BAEKJOON.solving.b16206;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Improve {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/b16206/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(); // 롤 케이크 개수
            int M = sc.nextInt(); // 자를 수 있는 횟수
            Integer[] rollCakes = new Integer[N];

            for (int i = 0; i < N; i++) {
                rollCakes[i] = sc.nextInt();
            }

            // 케이크 정렬: 나머지 0 우선, 크기 오름차순
            Arrays.sort(rollCakes, getCakeComparator());

            int result = getMaxEatableCakes(rollCakes, M);
            System.out.println(result);
        }

        sc.close();
    }

    // 케이크 정렬을 위한 Comparator
    private static Comparator<Integer> getCakeComparator() {
        return (a, b) -> {
            boolean aDivisibleBy10 = (a % 10 == 0);
            boolean bDivisibleBy10 = (b % 10 == 0);

            if (aDivisibleBy10 && !bDivisibleBy10) {
                return -1; // 나머지가 0인 케이크 우선
            } else if (!aDivisibleBy10 && bDivisibleBy10) {
                return 1;
            } else {
                return Integer.compare(a, b); // 크기 순 정렬
            }
        };
    }

    // 최대 먹을 수 있는 케이크 개수 계산
    private static int getMaxEatableCakes(Integer[] rollCakes, int maxCuts) {
        int cutCount = 0; // 사용한 칼질 횟수
        int eatableCakes = 0; // 먹을 수 있는 케이크 개수

        for (int cake : rollCakes) {
            if (cutCount >= maxCuts)
                break;

            if (cake % 10 == 0) { // 나머지가 0인 경우
                eatableCakes += handleDivisibleCake(cake, maxCuts, cutCount);
                cutCount += (cake / 10) - 1;
            } else { // 나머지가 0이 아닌 경우
                int cutsNeeded = cake / 10;
                if (cutCount + cutsNeeded <= maxCuts) {
                    eatableCakes += cutsNeeded;
                    cutCount += cutsNeeded;
                } else {
                    eatableCakes += (maxCuts - cutCount);
                    cutCount = maxCuts;
                }
            }
        }
        return eatableCakes;
    }

    // 나머지가 0인 케이크를 처리하는 메서드
    private static int handleDivisibleCake(int cake, int maxCuts, int cutCount) {
        int pieces = cake / 10; // 나눌 수 있는 조각 수
        int cutsNeeded = pieces - 1;

        if (cutCount + cutsNeeded <= maxCuts) {
            return pieces; // 모든 조각을 만들 수 있음
        } else {
            return maxCuts - cutCount; // 일부만 만들 수 있음
        }
    }
}
