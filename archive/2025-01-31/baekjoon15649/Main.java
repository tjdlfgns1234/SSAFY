package solving.baekjoon15649;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int arrNum = sc.nextInt();
            int selectLimit = sc.nextInt();

            int[] naturalNumArray = new int[arrNum + 1];
            for (int i = 0; i < naturalNumArray.length; i++) {
                naturalNumArray[i] = i;
            }
            // combination(1, 0, new int[selectLimit], naturalNumArray, selectLimit);
            permutaion(0, new boolean[arrNum + 1], new int[selectLimit], naturalNumArray, selectLimit);
        }
        sc.close();
    }

    private static void combination(int index, int selIdx, int[] selArr, int[] naturalNumArray, int selectLimit) {
        // basis part
        if (selIdx == selectLimit) {
            for (int i = 0; i < selArr.length; i++) {
                System.out.print(selArr[i] + " ");
            }
            System.out.println();
            return;
        }
        if (index == naturalNumArray.length) {
            return;
        }

        // recursive part
        combination(index + 1, selIdx, selArr, naturalNumArray, selectLimit);
        selArr[selIdx] = naturalNumArray[index];
        combination(index + 1, selIdx + 1, selArr, naturalNumArray, selectLimit);
    }

    private static void permutaion(int selIdx, boolean[] visited, int[] selArr, int[] naturalNumArray,
            int selectLimit) {
        // basis part
        if (selIdx == selectLimit) {
            // 출력
            for (int i : selArr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        // recursive part
        for (int index = 1; index < naturalNumArray.length; index++) {
            if (visited[index] == false) {
                visited[index] = true;
                selArr[selIdx] = naturalNumArray[index];
                permutaion(selIdx + 1, visited, selArr, naturalNumArray, selectLimit);
                visited[index] = false;
            }
        }
    }
}