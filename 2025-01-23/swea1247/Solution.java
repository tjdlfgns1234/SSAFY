package solving.swea1247;

import java.io.FileInputStream;
import java.util.Scanner;

class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("solving/swea1247/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int numOfCustomer = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();
            Coordinate company = new Coordinate(x, y);

            x = sc.nextInt();
            y = sc.nextInt();
            Coordinate home = new Coordinate(x, y);

            Coordinate[] customers = new Coordinate[numOfCustomer];
            for (int i = 0; i < numOfCustomer; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                customers[i] = new Coordinate(x, y);
            }

            int minDist = recursive(0, new boolean[numOfCustomer], new int[numOfCustomer], customers, company, home);
            System.out.printf("#%d %d\n", testCase, minDist);

        }

        sc.close();
    }

    // 재귀
    private static int recursive(int idx, boolean[] visit, int[] sel,
            Coordinate[] customers, Coordinate company, Coordinate home) {
        // basis part
        if (idx == customers.length) {
            int sumOfDistance = 0;
            sumOfDistance += calcDistance(company, customers[sel[0]]);
            for (int i = 1; i < sel.length; i++) {
                sumOfDistance += calcDistance(customers[sel[i - 1]], customers[sel[i]]);
            }
            sumOfDistance += calcDistance(customers[sel[sel.length - 1]], home);
            return sumOfDistance;
        }
        int minDistance = Integer.MAX_VALUE;

        // inductive part
        for (int i = 0; i < customers.length; i++) {
            if (visit[i] != true) {
                visit[i] = true;
                sel[idx] = i;
                int temp = recursive(idx + 1, visit, sel, customers, company, home);
                visit[i] = false;
                minDistance = Math.min(minDistance, temp);
            }
        }
        return minDistance;
    }

    // 거리 계산
    private static int calcDistance(Coordinate a, Coordinate b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
