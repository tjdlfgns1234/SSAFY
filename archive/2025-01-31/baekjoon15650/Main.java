package solving.baekjoon15650;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int arrNum = sc.nextInt();
            int selLimit = sc.nextInt();
            int[] arr = new int[arrNum];
            combination(0, 0, new int[selLimit], arr);
        }

        sc.close();
    }

    private static void combination(int idx, int selIdx, int[] selArr, int[] arr) {
        // basis part
        if (idx > arr.length) {
            return;
        }
        if (selIdx == selArr.length) {
            for (int i : selArr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        // recursive part
        selArr[selIdx] = idx + 1;
        combination(idx + 1, selIdx + 1, selArr, arr);
        combination(idx + 1, selIdx, selArr, arr);
    }
}
