package BAEKJOON.solving.b16206;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/b16206/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt(); // 롤 케이크 개수
            int M = sc.nextInt(); // 자를 수 있는 횟수 -> 안자를 수도 있다.
            int eatAbleCakeCount = 0;

            /*
             * 대략 작은 케이크를 먼저 잘라야 1회의 칼질으로 2개의 먹을 케이크를 만들 수 있다. 10 이하의 나머지가 존재하면 제끼고 생각하자.
             * 나머지가 0 이면서 20이상의 작은 케이크부터 칼질한다. 나머지는 그냥 잘라서 10으로 싹싹 만든다. 1회 칼질 -> 1개의 롤케잌
             */

            Integer[] sizeOfRollCake = new Integer[N];
            for (int i = 0; i < N; i++) {
                sizeOfRollCake[i] = sc.nextInt();
            }

            Comparator<Integer> customComparator = (a, b) -> {
                boolean aDivisibleBy10 = (a % 10 == 0);
                boolean bDivisibleBy10 = (b % 10 == 0);

                if (aDivisibleBy10 && !bDivisibleBy10) {
                    return -1;
                } else if (!aDivisibleBy10 && bDivisibleBy10) {
                    return 1;
                } else {
                    return Integer.compare(a, b);
                }
            };
            Arrays.sort(sizeOfRollCake, customComparator);

            int cutCount = 0;
            for (int i = 0; i < sizeOfRollCake.length; i++) {
                if (cutCount >= M)
                    break;

                if (sizeOfRollCake[i] % 10 == 0) {
                    if (sizeOfRollCake[i] == 10) {
                        eatAbleCakeCount += 1;
                    } else if (sizeOfRollCake[i] != 10) {
                        int cutAbleMax = ((sizeOfRollCake[i] / 10) - 1);
                        for (int j = 0; j < cutAbleMax; j++) {
                            eatAbleCakeCount += 1;
                            cutCount += 1;
                            if (cutCount >= M) {
                                if (j != cutAbleMax - 1) {
                                    eatAbleCakeCount -= 1;
                                }
                                break;
                            }
                        }
                        eatAbleCakeCount += 1;
                    } else { // do nothing
                    }
                } else if (sizeOfRollCake[i] % 10 != 0) {
                    int cutAbleMax = ((sizeOfRollCake[i] / 10));
                    for (int j = 0; j < cutAbleMax; j++) {
                        eatAbleCakeCount += 1;
                        cutCount += 1;
                        if (cutCount >= M) {
                            break;
                        }
                    }
                }
            }

            System.out.println(eatAbleCakeCount);

            // System.out.println(Arrays.toString(sizeOfRollCake));
        }

        sc.close();
    }

}
