package BAEKJOON.solving.b2991;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/b2991/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] dog = new int[2][3];
            // 0: 공격적 시간 1: 조용한 시간 2: 한 사이클 시간

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    dog[i][j] = sc.nextInt();
                }
                dog[i][2] = dog[i][0] + dog[i][1];
            }

            int[] visitor = new int[3];
            // 0 우체부
            // 1 우유배달부
            // 2 신문배달원

            for (int i = 0; i < visitor.length; i++) {
                int attack = 0;
                visitor[i] = sc.nextInt();
                // 개 1에게 공격 받는지 확인
                // % 연산의 결과가 0인 경우에는 조용할 시간이므로 제외 해야한다
                if (visitor[i] % dog[0][2] <= dog[0][0] && visitor[i] % dog[0][2] != 0) {
                    attack += 1;
                }
                // 개 2에게 공격 받는지 확인
                if (visitor[i] % dog[1][2] <= dog[1][0] && visitor[i] % dog[1][2] != 0) {
                    attack += 1;
                }
                // 개 몇마리에게 공격받는지 출력
                System.out.println(attack);
            }

        }

    }

}
