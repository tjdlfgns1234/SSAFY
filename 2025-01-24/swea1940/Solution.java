package solving.swea1940;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("solving/swea1940/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int numOfCommand = sc.nextInt();
            int speed = 0;
            int sumOfDistance = 0;
            for (int i = 0; i < numOfCommand; i++) {
                int command = sc.nextInt();

                switch (command) {
                    case 0: // 속도유지
                        sumOfDistance += speed;
                        break;
                    case 1: // 가속
                        speed += sc.nextInt();
                        sumOfDistance += speed;
                        break;
                    case 2: // 감속
                        int acceleration = sc.nextInt();
                        if (speed < acceleration) {
                            speed = 0;
                        } else {
                            speed -= acceleration;
                        }
                        sumOfDistance += speed;
                        break;

                    default:
                        break;
                }

            }
            System.out.printf("#%d %d\n", testCase, sumOfDistance);
        }
        sc.close();
    }
}
