package solving.baekjoon1244;

import java.util.Scanner;

// 남학생은 스위치 번호가 자기가 받은 수의 배수이면 스위치의 상태를 바꾼다
// 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아 그 구간에 속한 스위치의 상태를 모두 바꾼다

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int numOfSwitches = sc.nextInt();
        int[] switches = new int[numOfSwitches + 1];
        for (int i = 1; i <= numOfSwitches; i++) {
            switches[i] = sc.nextInt();
        }
        int numOfStudents = sc.nextInt();
        for (int i = 0; i < numOfStudents; i++) {
            int gender = sc.nextInt();
            int givenIndex = sc.nextInt();
            controlSwitches(switches, gender, givenIndex);
        }
        for (int i = 1; i < switches.length; i++) {
            System.out.printf("%d ", switches[i]);
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        if (numOfSwitches % 20 != 0) {
            System.out.println();
        }
        sc.close();
    }

    private static void controlSwitches(int[] switches, int gender, int givenIndex) {
        if (gender == 1) {
            // 남학생
            for (int i = 1; i * givenIndex < switches.length; i++) {
                switches[i * givenIndex] = activateSwitch(switches[i * givenIndex]);
            }
        } else if (gender == 2) {
            // 여학생
            switches[givenIndex] = activateSwitch(switches[givenIndex]);
            for (int i = 1; givenIndex - i > 0 && givenIndex + i < switches.length; i++) {
                if (switches[givenIndex - i] == switches[givenIndex + i]) {
                    switches[givenIndex - i] = activateSwitch(switches[givenIndex - i]);
                    switches[givenIndex + i] = activateSwitch(switches[givenIndex + i]);
                } else if (switches[givenIndex - i] != switches[givenIndex + i]) {
                    break;
                } else {
                    // 이곳은 들어오면 안되는 분기!
                    System.err.println("controlSwitches 잘못된 분기2 진입!!");
                }
            }
        } else {
            // 이곳은 들어오면 안되는 분기!
            System.err.println("controlSwitches 잘못된 분기1 진입!!");
        }
    }

    private static int activateSwitch(int lever) {
        return 1 - lever;
    }
}
