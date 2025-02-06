package baekjoon.baekjoon11729;

import java.util.Scanner;

/*
 * 하노이탑
 * 2^n-1이 총 이동 횟수
 * 
 * 그 아래는 재귀로 하나 작은 타워를 경유지에 옮기고
 * 제일 큰 원판을 옮긴다.
 * 그리고 경유지에 있는 하나 작은 타워를 목적지에 옮긴다.
 * 
 * 그런데 왜 아직도 하나 작은 타워를 생각하면 제일 작은 원판을 뗀 타워를 생각했을까.
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int towerHeight = sc.nextInt();

        System.out.println((long) Math.pow(2, towerHeight) - 1);
        recursive(towerHeight, 1, 2, 3);
        System.out.print(sb.toString());
        sc.close();
    }

    private static void recursive(int towerHeight, int start, int by, int target) {
        if (0 == towerHeight)
            return;
        else {
            recursive(towerHeight - 1, start, target, by);
            sb.append(start + " " + target + "\n");
            recursive(towerHeight - 1, by, start, target);
        }
    }
}