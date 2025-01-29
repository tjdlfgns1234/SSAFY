package solving.baekjoon2567;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 배열 받고 배열 검사해서 현재는 true이지만 상하좌우가 false 이거나 도화지 밖인 경우 그 수만큼 둘레 ++
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        boolean[][] dohwaji = new boolean[100][100];
        int coloredPaperCount = sc.nextInt();

        for (int i = 0; i < coloredPaperCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    dohwaji[y + j][x + k] = true;
                }
            }
        }

        int sumOfCircumference = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (dohwaji[i][j] == true) {
                    sumOfCircumference += countNearFalse(dohwaji, i, j);
                } else if (dohwaji[i][j] == false) {
                    continue;
                } else {
                    // 잘못된 분기! 진입하면 안돼!
                    System.err.println("잘못된 분기1!");
                }
            }
        }
        System.out.println(sumOfCircumference);
    }

    private static void print(boolean[][] dohwaji) {
        for (int i = 0; i < dohwaji.length; i++) {
            System.out.println(Arrays.toString(dohwaji[i]));
        }
    }

    private static int countNearFalse(boolean[][] dohwaji, int i, int j) {
        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        int countFalse = 0;
        // 사방탐색
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (!inDohwaji(dohwaji, ni, nj) || (dohwaji[ni][nj] == false)) {
                // 사방이 도화지 밖이거나, false 일 경우 테두리로 판단
                countFalse += 1;
            }
        }
        return countFalse;
    }

    private static boolean inDohwaji(boolean[][] dohwaji, int i, int j) {
        // check i, j is in dohwaji
        // dowhaji is square or rectangle
        int height = dohwaji.length;
        int width = dohwaji[0].length;

        return i >= 0 && i < height && j >= 0 && j < width;
    }
}
