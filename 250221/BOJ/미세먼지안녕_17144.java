import java.util.*;
import java.lang.*;
import java.io.*;

/*
R*C, map[r][c] = 미세먼지 양 / (1, 1) ~ (R, C)
공기청정기 위치 = map[r][1]~map[r+1][1] (2칸 차지)

아래 일이 1초마다 순서대로 일어난다.
1. 미세먼지 확산 -> 모든 미세먼지 칸에서 동시에
- (r, c) 인접 4방향 확산
- 인접한 곳에 공청기 있으면 확산 X
- 환산되는 양은 map[r][c] / 5, 소수점 버림
- 기존 영역에 남아있는 양은 map[r][c] - (map[r][c] / 5)
2. 공청기 작동
- 위는 반시계 아래는 시계 방향 순환
- 바람이 불면 미세먼지가 바람 방향대로 한 칸씩 이동

T초 뒤에 상황은?
*/

public class 미세먼지안녕_17144 {

    static class AirCleaner {
        int r;
        int c;
        AirCleaner(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Dust {
        int r;
        int c;
        int w;
        Dust(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    static int[][] map;
    static boolean[][] isDust;
    static List<AirCleaner> airs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        airs = new ArrayList<>();

        map = new int[R][C];
        isDust = new boolean[R][C];

        for (int i=0; i<R; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    airs.add(new AirCleaner(i, j));
                }
                else if (map[i][j] > 0) {
                    isDust[i][j] = true;
                }
            }
        }

        for (int t=0; t<T; ++t) {
            // 1. 확산
            spread();
//            print();
//            System.out.println();
            // 2. 공청기 작동
            operate();
//            print();
//            System.out.println("-----------------------");
        }

        System.out.println(getResult());


    }

    public static void print() {
        for (int i=0; i<map.length; ++i) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static int getResult() {
        int count = 0;
        for (int i=0; i<map.length; ++i) {
            for (int j=0; j<map[i].length; ++j) {
                if (isDust[i][j]) {
                    count += map[i][j];
                }
            }
        }

        return count;
    }

    public static void spread() {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int[][] fix = new int[map.length][map[0].length];

        for (int r=0; r<map.length; ++r) {
            for (int c=0; c<map[r].length; ++c) {
                if (isDust[r][c]) {
                    int gap = 0;
                    for (int d=0; d<4; ++d) {
                        int nextR = r + dr[d];
                        int nextC = c + dc[d];
                        if (isValid(nextR, nextC) && map[nextR][nextC] != -1) {
                            // map[nextR][nextC] += (map[r][c]/5);
                            // map[r][c] -= (map[r][c]/5);
                            gap += (map[r][c]/5);
                            fix[nextR][nextC] += (map[r][c]/5);
                        }
                    }
                    // map[r][c] -= gap;
                    fix[r][c] -= gap;
                }
            }
        }

        for (int r=0; r<map.length; ++r) {
            for (int c=0; c<map[r].length; ++c) {
                map[r][c] += fix[r][c];
                if (map[r][c] > 0) {
                    isDust[r][c] = true;
                }
            }
        }
    }

    public static void operate() {
        int[] upDr = {-1, 0, 1, 0};
        int[] downDr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int upR = airs.get(0).r;
        int upC = airs.get(0).c;

        int idx = upR == 0 ? 1 : 0;
        int currR = upR;
        int currC = upC;
        int nextR = upR + upDr[idx];
        int nextC = upC + dc[idx];

        while (!(nextR == upR && nextC == upC)) {
            if (map[nextR][nextC] > 0) {
                if (map[currR][currC] == -1) {
                    map[nextR][nextC] = 0;
                    isDust[nextR][nextC] = false;
                }

                else {
                    map[currR][currC] = map[nextR][nextC];
                    isDust[currR][currC] = true;
                    map[nextR][nextC] = 0;
                    isDust[nextR][nextC] = false;
                }
            }

            if (!isValid(nextR+upDr[idx], nextC+dc[idx]) || (nextR+upDr[idx]) > upR) {
                idx = (idx + 1) % 4;
            }

            currR = nextR;
            currC = nextC;
            nextR += upDr[idx];
            nextC += dc[idx];
        }



        int downR = airs.get(1).r;
        int downC = airs.get(1).c;

        idx = downR == 0 ? 1 : 0;
        currR = downR;
        currC = downC;
        nextR = downR + downDr[idx];
        nextC = downC + dc[idx];

        while (!(nextR == downR && nextC == downC)) {
            if (map[nextR][nextC] > 0) {
                if (map[currR][currC] == -1) {
                    map[nextR][nextC] = 0;
                    isDust[nextR][nextC] = false;
                }

                else {
                    map[currR][currC] = map[nextR][nextC];
                    isDust[currR][currC] = true;
                    map[nextR][nextC] = 0;
                    isDust[nextR][nextC] = false;
                }
            }

            if (!isValid(nextR+downDr[idx], nextC+dc[idx]) || (nextR+downDr[idx]) < downR) {
                idx = (idx + 1) % 4;
            }

            currR = nextR;
            currC = nextC;
            nextR += downDr[idx];
            nextC += dc[idx];
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
    }
}