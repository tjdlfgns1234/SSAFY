package baekjoon.baekjoon2999;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("solving/baekjoon2999/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            String encryptedEmail = sc.next();
            int mailLength = encryptedEmail.length();
            int row = 0, col = 0;

            // 정인이가 만든 배열의 행, 열 계산산
            for (int i = (int) Math.sqrt(mailLength); i > 0; i--) {
                if (mailLength % i == 0) {
                    row = i;
                    col = mailLength / i;
                    break;
                }
            }

            // 내가 받은 배열은 정인이가 만든 배열의 Transpose
            char[][] arr = new char[col][row];

            // 입력 받고고
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    arr[i][j] = encryptedEmail.charAt(i * row + j);
                }
            }

            // 다시 좌측부터 세로로 출력
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(arr[j][i]);
                }
            }
            System.out.println();

        }

        sc.close();
    }
}