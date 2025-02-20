import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사과 먹기
 * 시뮬레이션도 가능?
 * 재귀?
 */

public class Main {

    static class Point implements Comparable<Point> {
        int r;
        int c;
        int num;
        Point(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.num, o.num);
        }
    }

    static int[][] rotateNum = {{3, 3, 3, 3, 0, 2, 1, 1},
            {2, 3, 3, 1, 3, 1, 0, 3},
            {1, 1, 2, 0, 3, 3, 3, 3},
            {3, 0, 1, 3, 1, 3, 3, 2}
    };

    static int state;
    static int result;
    static List<Point> apples;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            apples = new ArrayList<>();
            state = 0;
            result = 0;

            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] != 0) {
                        apples.add(new Point(i, j, map[i][j]));
                    }
                }
            }

            Collections.sort(apples);

            solve();

            System.out.println(result);

        }
    }

    public static void solve() {
        int currR = 0;
        int currC = 0;
        int currState = 0;

        for (Point apple : apples) {
            int idx = getIdx(currR, currC, apple);

            result += rotateNum[currState][idx];
            currState = (currState + rotateNum[currState][idx]) % 4;
            currR = apple.r;
            currC = apple.c;
        }
    }

    public static int getIdx(int r, int c, Point p) {
        int idx;

        if (r > p.r) {
            idx = 0;
            if (c > p.c) {
                idx += 0;
            }
            else if (c == p.c) {
                idx += 1;
            }
            else {
                idx += 2;
            }
        }
        else if (r == p.r) {
            idx = 3;
            if (c > p.c) {
                idx += 0;
            }
            else if (c < p.c) {
                idx += 1;
            }
        }
        else {
            idx = 5;
            if (c > p.c) {
                idx += 0;
            }
            else if (c == p.c) {
                idx += 1;
            }
            else {
                idx += 2;
            }
        }

        return idx;
    }
}
