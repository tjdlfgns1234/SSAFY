import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 8방 탐색
 * 검은 돌은 1 / 흰 돌은 2 / 빈 자리는 0
 * 검은 돌 승리 1 / 흰 돈 승리 2 / 승부 X 0
 * 승부가 났다면 가장 왼쪽 위에 있는 돌의 가로줄 번호와 세로줄 번호를 출력
 */

public class Main2615 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[19][19];

        for (int i=0; i<19; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<19; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[] dr = {1, 1, 0, -1}; //아래 / 오른쪽 아래 대각선 / 오른쪽 / 오른쪽 위 대각선 방향
        int[] dc = {0, 1, 1, 1};

        int[] unitR = {-1, -1, 0, 1}; //위 / 왼쪽 위 대각선 / 왼쪽 / 왼쪽 아래 대각선 방향
        int[] unitC = {0, -1, -1, -1};  //반대가 있는지 없는지 검사하는 것이기 때문에 탐색하려는 방향과 반대쪽 검사하도록 순서를 맞춰야 함

        int black = 1;
        int white = 2;
        boolean finished = false;
        int winner = 0;
        int resultR = -1;
        int resultC = -1;

        for (int i=0; i<19; ++i) {
            if (finished) {
                break;
            }
            for (int j=0; j<19; ++j) {
                if (finished) {
                    break;
                }
                if (map[i][j] == black) {
                    for (int d=0; d<4; ++d) {
                        if (isValid(map, i+unitR[d], j+unitC[d]) && map[i+unitR[d]][j+unitC[d]] == black) {
                            continue;
                        }

                        int count = 0;
                        int r = i;
                        int c = j;
                        while (r >= 0 && c >= 0 && r < 19 && c < 19 && map[r][c] == black) {
//                            if (r >= 0 && c >= 0 && map[r][c] == black) {
                            ++count;
                            r += dr[d];
                            c += dc[d];
//                            }
                        }
                        if (count == 5) {
                            winner = black;
                            finished = true;
                            resultR = i+1;
                            resultC = j+1;
                        }
                    }
                }

                else if (map[i][j] == white) {
                    for (int d=0; d<4; ++d) {
                        if (isValid(map, i+unitR[d], j+unitC[d]) && map[i+unitR[d]][j+unitC[d]] == white) {
                            continue;
                        }
                        int count = 0;
                        int r = i;
                        int c = j;
                        while (r >= 0 && c >= 0 && r < 19 && c < 19 && map[r][c] == white) {
//                            if (r >= 0 && c >= 0 && map[r][c] == white) {
                            ++count;
                            r += dr[d];
                            c += dc[d];
//                            }
                        }
                        if (count == 5) {
                            winner = white;
                            finished = true;
                            resultR = i+1;
                            resultC = j+1;
                        }
                    }
                }
            }
        }

        System.out.println(winner);
        if (winner != 0) {
            System.out.println(resultR + " " + resultC);
        }

    }

    public static boolean isValid(int[][] map, int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length;
    }

}