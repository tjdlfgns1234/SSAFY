import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {

    static class Car {
        int r;
        int c;
        int direct;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            for (int i=0; i<H; ++i) {
                map[i] = br.readLine().toCharArray();
            }

            int N = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();

            int r, c; //전차 위치
            int direct; // 전차 방향 상1, 하2, 좌3, 우4
            Car car = new Car();
            for (int i=0; i<H; ++i) {
                for (int j=0; j<W; ++j) {
                    char curr = map[i][j];
                    if (curr == '^') {
                        car.direct = 1;
                        car.r=i;
                        car.c=j;
                    }
                    else if (curr == 'v') {
                        car.direct = 2;
                        car.r=i;
                        car.c=j;
                    }
                    else if (curr == '<') {
                        car.direct = 3;
                        car.r=i;
                        car.c=j;
                    }
                    else if (curr == '>') {
                        car.direct = 4;
                        car.r=i;
                        car.c=j;
                    }
                }
            }

            for (char command : commands) {
                play(map, command, car);
            }

            System.out.print("#" + t + " ");
            for (char[] m : map) {
                System.out.println(m);
            }

        }
    }

    public static void play(char[][] map, char command, Car car) {
        if (command == 'U') {
            car.direct = 1;
            if (movePossible(map, car.r-1, car.c)) {
                map[car.r][car.c] = '.';
                car.r -= 1;
            }
            map[car.r][car.c] = '^';
        }
        else if (command == 'D') {
            car.direct = 2;
            if (movePossible(map, car.r+1, car.c)) {
                map[car.r][car.c] = '.';
                car.r += 1;
            }
            map[car.r][car.c] = 'v';
        }
        else if (command == 'L') {
            car.direct = 3;
            if (movePossible(map, car.r, car.c-1)) {
                map[car.r][car.c] = '.';
                car.c -= 1;
            }
            map[car.r][car.c] = '<';
        }
        else if (command == 'R') {
            car.direct = 4;
            if (movePossible(map, car.r, car.c+1)) {
                map[car.r][car.c] = '.';
                car.c += 1;
            }
            map[car.r][car.c] = '>';
        }
        else if (command == 'S') {
            int rd = 0;
            int cd = 0;
            if (car.direct == 1) {
                rd = -1;
            }
            else if (car.direct == 2) {
                rd += 1;
            }
            else if (car.direct == 3) {
                cd -= 1;
            }
            else if (car.direct == 4) {
                cd += 1;
            }

            int nextR = car.r + rd;
            int nextC = car.c + cd;
            while(shotPossible(map, nextR, nextC)) {
                nextR += rd;
                nextC += cd;
            }

            if (isValid(map, nextR, nextC) && map[nextR][nextC] == '*') {
                map[nextR][nextC] = '.';
            }
        }
    }

    public static boolean isValid(char[][] map, int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[r].length;
    }

    public static boolean movePossible(char[][] map, int r, int c) {
        return isValid(map, r, c) && map[r][c] == '.';
    }

    public static boolean shotPossible(char[][] map, int r, int c) {
        return isValid(map, r, c) && !(map[r][c] == '#' || map[r][c] == '*');
    }
}
