package swea.solving.s4615;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("swea/solving/s4615/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            String[] line = br.readLine().trim().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            // 첫 게임판 만들기
            int[][] board = generateBoard(N);

            // 플레이어 입력받고 입력 받는대로 게임수행
            for (int j = 0; j < M; j++) {
                line = br.readLine().trim().split(" ");
                int[] coordinate = new int[3];
                for (int k = 0; k < 3; k++) {
                    coordinate[k] = Integer.parseInt(line[k]);
                }
                gamePlay(board, N, coordinate[0] - 1, coordinate[1] - 1, coordinate[2]);
            }
            // System.out.println(Arrays.deepToString(board));

            // 돌 수 세고 출력
            int[] result = countStones(board, N);
            System.out.println("#" + testCase + " " + result[0] + " " + result[1]);
        }
    }

    // 들어온 board를 직접수정
    private static void gamePlay(int[][] board, int N, int x, int y, int player) {
        // 돌을 놓은 뒤 팔방탐색을 해 가장 멀리 있는 돌들의 좌표를 구하고
        // 그 사이에 있는 모든 돌들을 내 색으로 바꾼다.
        // 팔방탐색 위부터 시계방향
        int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

        board[x][y] = player;

        for (int d = 0; d < 8; d++) {
            int maxDistance = 0;
            boolean hasOpponent = false;
            for (int i = 1; i < N; i++) {
                int nr = x + dr[d] * i;
                int nc = y + dc[d] * i;
                // 보드판을 벗어나지 않고
                if (!checkValidCoordinate(N, nr, nc))
                    break;
                // 0이 나온다면 종료
                if (board[nr][nc] == 0)
                    break;
                // 상대방 돌 발견 시
                if (board[nr][nc] != player) {
                    hasOpponent = true;

                    // 상대방의 돌 발견 후 발견한 돌이 플레이어의 돌이라면
                } else if (hasOpponent) {
                    maxDistance = i;
                    break;
                    // 상대방 돌 없이 자신의 돌만 발견 -> 종료
                } else {
                    break;
                }
            }

            // 저장했던 가장 먼 좌표까지 내 돌로 싹 바꾸기
            for (int i = 1; i <= maxDistance; i++) {
                int nr = x + dr[d] * i;
                int nc = y + dc[d] * i;
                board[nr][nc] = player;

            }
        }
    }

    private static boolean checkValidCoordinate(int N, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    private static int[][] generateBoard(int N) {
        int[][] board = new int[N][N];
        int half = N / 2;

        board[half - 1][half] = 1;
        board[half][half - 1] = 1;

        board[half - 1][half - 1] = 2;
        board[half][half] = 2;

        return board;
    }

    private static int[] countStones(int[][] board, int N) {
        int black = 0;
        int white = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switch (board[i][j]) {
                    case 1:
                        black += 1;
                        break;

                    case 2:
                        white += 1;
                        break;

                    default:
                        break;
                }
            }
        }
        int[] result = { black, white };
        return result;
    }
}
