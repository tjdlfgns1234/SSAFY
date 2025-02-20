package solving.swea1974;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("solving/swea1974/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] board = new int[9][9];
        for (int testCase = 1; testCase <= T; testCase++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            int result = sudokuCheck(board) ? 1 : 0;
            System.out.printf("#%d %d\n", testCase, result);
        }
        sc.close();
    }

    private static boolean sudokuCheck(int[][] board) {
        return sudokuCheck1(board) && sudokuCheck2(board) && sudokuCheck3(board);
    }

    private static boolean sudokuCheck1(int[][] board) {
        // check row
        for (int i = 0; i < 9; i++) {
            boolean[] exist = new boolean[board.length];
            for (int j = 0; j < 9; j++) {
                if (exist[board[i][j] - 1] == false) {
                    exist[board[i][j] - 1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean sudokuCheck2(int[][] board) {
        // check col
        for (int i = 0; i < 9; i++) {
            boolean[] exist = new boolean[board.length];
            for (int j = 0; j < 9; j++) {
                if (exist[board[j][i] - 1] == false) {
                    exist[board[j][i] - 1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean sudokuCheck3(int[][] board) {
        // check sub square

        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                boolean[] exist = new boolean[board.length];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (exist[board[x + i][y + j] - 1] == false) {
                            exist[board[x + i][y + j] - 1] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
