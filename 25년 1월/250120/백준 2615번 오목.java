import java.util.Scanner;

public class Main {

    /*
        실수한 것
        4방향으로 간단하게 계산하기
        이전 방문 체크를 제대로 안했음.
        중복 연산에 주의하자.
        틀리지 않게 외우기
    */

    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] map = new int[21][21];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 19;

        // 지도 정보 입력 받기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve();
    }

    private static void solve() {
        int n = 19;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) { // 돌이 있는 경우만 확인
                    for (int d = 0; d < 4; d++) {
                        // 이전 좌표 확인 (중복 체크 방지)
                        int prevX = i - dx[d];
                        int prevY = j - dy[d];

                        if (prevX > 0 && prevX <= n && prevY > 0 && prevY <= n && map[prevX][prevY] == map[i][j]) {
                            continue; // 이전에 같은 방향으로 이어진 돌이 있으면 스킵
                        }

                        if (calc(i, j, d, map[i][j]) == 5) {
                            System.out.println(map[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static int calc(int x, int y, int dir, int color) {
        int count = 1;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx > 0 && nx <= 19 && ny > 0 && ny <= 19 && map[nx][ny] == color) {
            count++;
            nx += dx[dir];
            ny += dy[dir];
        }

        return count;
    }
}