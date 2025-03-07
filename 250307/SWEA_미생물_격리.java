import java.util.Arrays;
import java.util.Scanner;

public class SWEA_미생물_격리 {
    static class Asso {
        int name;
        int x;
        int y;
        int num;
        int direction;

        Asso(int name, int x, int y, int num, int direction) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.num = num;
            this.direction = direction;
        }
    }

    // 이동 방향
    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 1; t <= testCase; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            // map 만들기
            int[][] v = new int[n][n];

            // 미생물 군집 클래스
            Asso[] assos = new Asso[k];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int num = sc.nextInt();
                int direction = sc.nextInt() - 1;
                assos[i] = new Asso(i, x, y, num, direction);
            }

            for (int time = 0; time < m; time++) {
                // 맵 초기화
                v = new int[n][n];

                for (int i = 0; i < assos.length; i++) {
                    // 전체 이동 map에 안줌
                    Asso cAsso = assos[i];
                    if (cAsso.x != -1 && cAsso.y != -1) {
                        int nx = cAsso.x + dx[cAsso.direction];
                        int ny = cAsso.y + dy[cAsso.direction];
                        cAsso.x = nx;
                        cAsso.y = ny;
                        v[nx][ny] += 1;
                    }
                }

                // 약품 처리 걸린애들 처리
                for (Asso asso : assos) {
                    int cx = asso.x;
                    int cy = asso.y;
                    if (cx != -1) {
                        if (cx == 0 || cx == n - 1 || cy == 0 || cy == n - 1) {
                            if (asso.num == 1) {
                                asso.x = -1;
                                asso.y = -1;
                                asso.num = 0;
                            } else {
                                asso.num /= 2;
                                int direction = asso.direction;
                                if(direction == 0){
                                    asso.direction = 1;
                                }else if(direction == 1){
                                    asso.direction = 0;
                                }else if(direction == 2){
                                    asso.direction = 3;
                                }else{
                                    asso.direction = 2;
                                }
                            }
                        }
                    }
                }

                // 군집이 겹치는 경우
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (v[i][j] > 1) {
                            int[] overlap = new int[v[i][j]];
                            int count = 0;
                            int maxName = 0;
                            int max = 0;
                            for (Asso asso : assos) {
                                if (count == overlap.length)
                                    break;
                                if (asso.x != -1) {
                                    if (asso.x == i && asso.y == j) {
                                        overlap[count] = asso.name;
                                        if (max < asso.num) {
                                            max = asso.num;
                                            maxName = asso.name;
                                        }
                                        count += 1;
                                    }
                                }
                            }

                            // 겹치는 애들 합치는 작업
                            Asso winnerAsso = assos[0];
                            for (Asso asso : assos) {
                                if (asso.name == maxName) {
                                    winnerAsso = asso;
                                    break;
                                }
                            }
                            for (int q = 0; q < overlap.length; q++) {
                                if (overlap[q] == maxName)
                                    continue;

                                Asso target = assos[0];
                                // target 찾기
                                for (Asso asso : assos) {
                                    if (overlap[q] == asso.name) {
                                        target = asso;
                                        break;
                                    }
                                }

                                winnerAsso.num += target.num;
                                target.x = -1;
                                target.y = -1;
                                target.num = 0;
                            }
                        }
                    }
                }

            }

            int result = 0;
            for (Asso asso : assos) {
                result += asso.num;
            }

            System.out.println("#" + t + " " + result);

        }

    }
}
