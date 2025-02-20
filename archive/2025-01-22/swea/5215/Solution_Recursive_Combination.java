package swea.solving.s5215;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_Recursive_Combination {

    // 최대 만족도를 저장하기위한 클래스 변수 (공유됨)
    private static int maxSatisfaction = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/solving/s5215/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int numOfFood = sc.nextInt();
            int calorieLimit = sc.nextInt();

            int[] satisfaction = new int[numOfFood];
            int[] foodCalorie = new int[numOfFood];

            // 새로운 테스트케이스마다 클래스 변수 초기화
            Solution.maxSatisfaction = 0;

            for (int i = 0; i < numOfFood; i++) {
                satisfaction[i] = sc.nextInt();
                foodCalorie[i] = sc.nextInt();
            }

            // recursive
            recursive(0, 0, 0, calorieLimit, satisfaction, foodCalorie);

            System.out.printf("#%d %d\n", testCase, maxSatisfaction);

        }
        sc.close();
    }

    // 변하는 값을 앞으로
    /**
     * 
     * @param idx               탐색할 인덱스
     * @param sumOfSatisfaction 만족도 합계
     * @param sumOfCalorie      칼로리 합계
     * @param calorieLimit      칼로리 제한
     * @param satisfaction      만족도 배열
     * @param foodCalorie       칼로리 배열
     */
    private static void recursive(int idx, int sumOfSatisfaction, int sumOfCalorie, int calorieLimit,
            int[] satisfaction, int[] foodCalorie) {
        // 탈출조건 1: 칼로리 제한을 넘었을 경우
        if (calorieLimit < sumOfCalorie) {
            return;
        }

        /*
         * 이미 최대 칼로리를 넘었을 경우에는 갱신 없이 반환하지만
         * 최대 칼로리 미만일 경우 최대 칼로리 여부를 확인해야합니다.
         * 인덱스 검사는 다음 재귀가 가능한지 확인하기 위함이므로
         * 현재 선택된 만족도에 대한 업데이트는 이전에 이루어져야합니다.
         * 
         * 예시가 마지막 재료를 선택하는 경우가 아니었다면 찾지 못했을 것 같습니다.
         */
        if (maxSatisfaction < sumOfSatisfaction) {
            Solution.maxSatisfaction = sumOfSatisfaction;
        }

        // 탈출조건 2: 다음 인덱스 진행이 불가할 때
        if (idx >= satisfaction.length) {
            return;
        }

        // 가지치기
        // 먹었을때
        recursive(idx + 1, (sumOfSatisfaction + satisfaction[idx]), (sumOfCalorie + foodCalorie[idx]), calorieLimit,
                satisfaction,
                foodCalorie);
        // 안먹었을때
        recursive(idx + 1, sumOfSatisfaction, sumOfCalorie, calorieLimit, satisfaction, foodCalorie);
    }
}