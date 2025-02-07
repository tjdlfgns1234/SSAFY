import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N*N, 맛있는 정도 1~100
 * x번째 날에는 맛있는 정도가 x인 칸을 먹음
 * 가장 많은 덩어리의 수
 */

class Point {
    public int r;
    public int c;

    public Point() {}

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution7733 {

    static int[][] cheese;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];

            List<Integer> scores = new ArrayList<>();
            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    int score = Integer.parseInt(st.nextToken());
                    cheese[i][j] = score;
//                  scores.add(score);
                }
            }

            int max = 1;
            for (int i=1; i<=100; ++i) {
                max = Math.max(max, find(i));
            }

//          Collections.sort(scores);
//          for (int score : scores) {
//              max = Math.max(max, find(score));
//          }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(max);
            System.out.println(sb);


        }

    }

    //day번째 날에 day맛을 먹음 -> day번째 날 덩어리 -> 다 day보다 큰 맛
    public static int find(int day) {

        int count = 0;
        boolean[][] v = new boolean[cheese.length][cheese[0].length];


        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};
        Queue<Point> q = new ArrayDeque<>();
        for (int i=0; i<cheese.length; ++i) {
            for (int j=0; j<cheese[i].length; ++j) {
                if (isValid(i, j, v, day)) {
                    ++count;
                    v[i][j] = true;

                    Point p = new Point(i, j);
                    q.offer(p);
                    while (!q.isEmpty()) {
                        ++cnt;
                        Point currP = q.poll();

                        for (int k=0; k<4; ++k) {
                            int r = currP.r+rd[k];
                            int c = currP.c+cd[k];
                            Point tmp;

                            if (isValid(r, c, v, day)) {
                                v[r][c] = true;
                                tmp = new Point(r, c);
                                q.offer(tmp);
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static boolean isValid(int i, int j, boolean[][] v, int day) {
        return i >= 0 && j >= 0 && i < cheese.length && j < cheese[i].length && !v[i][j] && cheese[i][j] > day;
    }
}