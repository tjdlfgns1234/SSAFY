package BAEKJOON.solving.s2615;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BAEKJOON/solving/s2615/input.txt"));
        int N = 19;
        int[][] board = new int[N][N];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();

            }
        }

        int[] result = findWinner(board, N);

        if (result[0] == 0) {
            System.out.println(result[0]);
        } else if (result[0] != 0) {
            System.out.println(result[0]);
            System.out.println(result[1] + " " + result[2]);
        } else {
            // do nothing on hear
        }

        sc.close();

    }

    private static int[] findWinner(int[][] board, int N) {
        int step = 6;
        // 팔방탐색 -> 우상, 우, 하, 우하
        // int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
        // int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dr = { -1, 0, 1, 1 };
        int[] dc = { 1, 1, 1, 0 };

        // 좌상단 부터 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 좌표 돌 확인
                int stoneColor = board[i][j];
                if (stoneColor != 0) {
                    // 돌이 있다면 각 좌표마다 우상, 우, 하, 우하 방향으로 오목 승리조건 확인
                    for (int d = 0; d < 4; d++) {
                        int sameStoneCount = 1;
                        for (int k = 1; k <= step; k++) {
                            int nr = i + dr[d] * k;
                            int nc = j + dc[d] * k;
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (board[nr][nc] == stoneColor) {
                                    sameStoneCount += 1;
                                    if (sameStoneCount == 5) {
                                        // 돌의 시작 이전 좌표도 확인
                                        int temp1 = i + dr[d] * -1;
                                        int temp2 = j + dc[d] * -1;
                                        if (temp1 >= 0 && temp1 < N && temp2 >= 0 && temp2 < N) {
                                            if (board[temp1][temp2] == stoneColor) {
                                                sameStoneCount += 1;
                                            }
                                        }
                                    }

                                } else if (board[nr][nc] != stoneColor) {
                                    // 돌 색이 다르다면 끝!
                                    break;
                                } else {
                                    // do nothing on here
                                }
                            } else {
                                // 보드 바깥으로 나갈 시
                                break;
                            }
                        }
                        if (sameStoneCount == 5) {
                            return new int[] { stoneColor, i + 1, j + 1 };
                        }
                    }
                }
            }
        }
        return new int[] { 0, 0, 0 };

    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
