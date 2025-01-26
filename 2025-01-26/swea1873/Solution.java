package solving.swea1873;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    static Character[] tankArr = { '^', '<', '>', 'v' };
    static Set<Character> tankSet = new HashSet<>(Arrays.asList(tankArr));

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int tankx, tanky;

    public static void main(String[] args) {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        T = 3;
        for (int tc = 1; tc <= T; tc++) {
            int hight = sc.nextInt();
            int width = sc.nextInt();

            char[][] map = new char[hight][width];

            for (int i = 0; i < hight; i++) {
                String line = sc.next();
                for (int j = 0; j < width; j++) {
                    map[i][j] = line.charAt(j);
                    if (tankSet.contains(map[i][j])) {
                        tankx = i;
                        tanky = j;
                    }
                }
            }
            int userInputCount = sc.nextInt();
            char[] userInput = new char[userInputCount];
            String line = sc.next();
            for (int i = 0; i < userInputCount; i++) {
                userInput[i] = line.charAt(i);
            }
            playGame(map, userInput);
            System.out.printf("#%d ", tc);
            print(map);
        }
        sc.close();
    }

    private static void playGame(char[][] map, char[] userInput) {
        for (char c : userInput) {
            userAct(map, c);
        }
    }

    private static void userAct(char[][] map, char c) {
        switch (c) {
            case 'U':
                // 전차의 형태를 위로 && 한칸 위가 평지라면 이동
                map[tankx][tanky] = '^';
                if (checkMoveable(map, c, tankx, tanky)) {
                    map[tankx + dx[0]][tanky + dy[0]] = '^';
                    map[tankx][tanky] = '.';
                    tankx += dx[0];
                    tanky += dy[0];
                }
                break;
            case 'R':
                map[tankx][tanky] = '>';
                if (checkMoveable(map, c, tankx, tanky)) {
                    map[tankx + dx[1]][tanky + dy[1]] = '>';
                    map[tankx][tanky] = '.';
                    tankx += dx[1];
                    tanky += dy[1];
                }
                break;
            case 'D':
                map[tankx][tanky] = 'v';
                if (checkMoveable(map, c, tankx, tanky)) {
                    map[tankx + dx[2]][tanky + dy[2]] = 'v';
                    map[tankx][tanky] = '.';
                    tankx += dx[2];
                    tanky += dy[2];
                }
                break;
            case 'L':
                map[tankx][tanky] = '<';
                if (checkMoveable(map, c, tankx, tanky)) {
                    map[tankx + dx[3]][tanky + dy[3]] = '<';
                    map[tankx][tanky] = '.';
                    tankx += dx[3];
                    tanky += dy[3];
                }
                break;
            case 'S':
                shoot(map, tankx, tanky);
                break;

            default:
                break;
        }
    }

    private static void shoot(char[][] map, int x, int y) {
        int direction = -1;
        switch (map[x][y]) {
            case '^':
                direction = 0;
                break;
            case '>':
                direction = 1;
                break;
            case 'v':
                direction = 2;
                break;
            case '<':
                direction = 3;
                break;
            default:
                break;
        }
        int canonBallX = -1, canonBallY = -1;
        canonBallX = x + dx[direction];
        canonBallY = y + dy[direction];
        int i = 1;
        while (insideMap(canonBallX, canonBallY, map)) {
            if (map[canonBallX][canonBallY] == '*') {
                map[canonBallX][canonBallY] = '.';
                break;
            } else if (map[canonBallX][canonBallY] == '#') {
                break;
            } else {
                i += 1;
                canonBallX = x + dx[direction] * i;
                canonBallY = y + dy[direction] * i;
            }
        }
    }

    private static boolean checkMoveable(char[][] map, char direction, int x, int y) {
        int xAfterMove = -1;
        int yAfterMove = -1;

        switch (direction) {
            case 'U':
                xAfterMove = x + dx[0];
                yAfterMove = y + dy[0];
                break;
            case 'R':
                xAfterMove = x + dx[1];
                yAfterMove = y + dy[1];
                break;
            case 'D':
                xAfterMove = x + dx[2];
                yAfterMove = y + dy[2];
                break;
            case 'L':
                xAfterMove = x + dx[3];
                yAfterMove = y + dy[3];
                break;
            default:
                System.out.println("Wrong direction! :" + direction);
                return false;
        }
        if (insideMap(xAfterMove, yAfterMove, map)) {
            if (map[xAfterMove][yAfterMove] == '.') {
                return true;
            }
        }
        return false;
    }

    public static boolean insideMap(int x, int y, char[][] map) {
        int hight = map.length;
        int width = map[0].length;
        return (x >= 0 && x < hight && y >= 0 && y < width);
    }

    private static void print(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void print(char[] input) {
        System.out.println(Arrays.toString(input));

    }
}
