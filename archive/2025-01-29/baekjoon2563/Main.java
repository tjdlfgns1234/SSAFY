package solving.baekjoon2563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        boolean[][] dohwaji = new boolean[100][100];
        int paperCount = sc.nextInt();
        for (int i = 0; i < paperCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    dohwaji[x + j][y + k] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < dohwaji.length; i++) {
            for (int j = 0; j < dohwaji[0].length; j++) {
                if (dohwaji[i][j] == true) {
                    area += 1;
                }
            }
        }
        System.out.println(area);
        sc.close();
    }
}
