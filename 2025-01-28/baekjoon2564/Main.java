package solving.baekjoon2564;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();
        int height = sc.nextInt();

        int shopCount = sc.nextInt();

        int[][] shopPoint = new int[shopCount][2];
        for (int i = 0; i < shopCount; i++) {
            shopPoint[i][0] = sc.nextInt();
            shopPoint[i][1] = sc.nextInt();
        }

        int[] home = new int[2];
        home[0] = sc.nextInt();
        home[1] = sc.nextInt();

        int sumDistance = 0;
        for (int i = 0; i < shopCount; i++) {
            sumDistance += calculateDistance(home[0], home[1], shopPoint[i][0], shopPoint[i][1], height, width);
        }
        System.out.println(sumDistance);
        sc.close();
    }

    private static int calculateDistance(int homeDirection, int homeDistance, int storeDirection, int storeDistance,
            int height, int width) {
        int homeCoord = convert_to_1d_cordinate(height, width, homeDirection, homeDistance);
        int storeCoord = convert_to_1d_cordinate(height, width, storeDirection, storeDistance);
        int circumference = 2 * (height + width);
        int distance1 = Math.abs(storeCoord - homeCoord);
        int distance2 = circumference - distance1;
        int shortDistance = Math.min(distance1, distance2);

        return shortDistance;
    }

    private static int convert_to_1d_cordinate(int height, int width, int direction, int distance) {
        // 원점 부터 시계방향으로 움직였을 시의 거리 반환
        // direction: 1(북), 2(남), 3(서), 4(동)
        switch (direction) {
            case 1:
                return distance;
            case 2:
                return width + height + width - distance;
            case 3:
                return width + height + width + height - distance;
            case 4:
                return width + distance;
            default:
                return -1;
        }
    }
}
