import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main1941 {
    static int result = 0;
    static String[] students;
    static int N;

    static class Point {
        int r;
        int c;
        Point() {}
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Point[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = 5;
        students = new String[N];
        arr = new Point[N*N];

        for (int i=0; i<N; ++i) {
            students[i] = br.readLine();
            for (int j=0; j<N; ++j) {
                arr[5*i + j] = new Point(i, j);
            }
        }

        recursive(N*N, new int[7], 0, 0);

        System.out.println(result);

    }

    /**
     *
     * @param n 0~n-1까지 숫자 중 7개를 고른다
     * @param sel // 선택한 수가 있는 배열 -> 배열의 각 값은 arr의 idx로 작용
     * @param count // 고른 개수
     * @param curr // 현재 숫자
     */
    public static void recursive(int n, int[] sel, int count, int curr) {
        if (count == sel.length) {
            //조건 검사
//			System.out.println(Arrays.toString(sel));
            if (isPossible(sel)) {
                ++result;
            }
            return;
        }

        if (curr >= n) {
            return;
        }

        recursive(n, sel, count, curr+1);
        sel[count] = curr;
        recursive(n, sel, count+1, curr+1);


    }

    public static boolean isPossible(int[] idx) {

        Point p = arr[idx[0]];
        boolean[] used = new boolean[7];
        used[0] = true;

        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};

        Queue<Point> q = new ArrayDeque<>();
        q.add(p);

        int countS = 0;
        int countNum = 1;
        while(!q.isEmpty()) {
            Point curr = q.poll();
            if (students[curr.r].charAt(curr.c) == 'S') {
                ++countS;
            }

            for (int i=0; i<4; ++i) {
                int nextR = curr.r + rd[i];
                int nextC = curr.c + cd[i];
                if (isValid(nextR, nextC)) {
                    for (int j=0; j<7; ++j) {
                        if (!used[j] && nextR == arr[idx[j]].r && nextC == arr[idx[j]].c) {
                            ++countNum;
                            q.add(arr[idx[j]]);
                            used[j] = true;
                        }
                    }
                }
            }
        }


        return countNum == 7 && countS >= 4;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
