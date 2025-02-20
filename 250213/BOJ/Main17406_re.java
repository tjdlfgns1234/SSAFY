import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시계 방향으로 돌린다고 해서 꼭 시계 방향으로 접근할 필요는 없다.
 */

public class Main17406_re {

    static int N, M, K;
    static int rowMin, min;
    static int[][] rotation;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rowMin = Integer.MAX_VALUE; // (배열의 대표값)
        min = Integer.MAX_VALUE;

        arr = new int[N+1][M+1];

        for (int i=1; i<N+1; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<M+1; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotation = new int[K][3];
        for (int i=0; i<K; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; ++j) {
                rotation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(new int[K], new boolean[K], 0);

        System.out.println(min);
    }

    public static void recursive(int[] sel, boolean[] v, int depth) { // kPk
        if (depth == sel.length) {
            // 1. 선택된 순서대로 배열 돌리기
            start(sel);
            // 2. 배열의 대표값(=rowMin) 구하기
            // 3. 현재 min과 비교
            return;
        }

        for (int i=0; i<K; ++i) {
            if (!v[i]) {
                sel[depth] = i;
                v[i] = true;
                recursive(sel, v, depth+1);
                v[i] = false;
            }
        }

    }

    public static void start(int[] sel) {
        int[][] tmpArr = new int[arr.length][arr[0].length];
        for (int i=1; i<tmpArr.length; ++i) {
            for (int j=1; j<tmpArr[i].length; ++j) {
                rowMin = Integer.MAX_VALUE;
                tmpArr[i][j] = arr[i][j];
            }
        }

        for (int i=0; i<sel.length; ++i) {
            rotate(tmpArr, rotation[sel[i]]);
        }

        findRowMin(tmpArr);
        min = Math.min(min, rowMin);

    }

    public static void rotate(int[][] tmp, int[] rotateInfo) {
        for (int s=1; s<=rotateInfo[2]; ++s) {
            int r = rotateInfo[0];
            int c = rotateInfo[1];

            int tmpNum1 = tmp[r-s][c+s];
            for (int currC = c + s; currC > c-s; --currC) {
                int currR = r - s;
                tmp[currR][currC] = tmp[currR][currC-1];
            }

            int tmpNum2 = tmp[r+s][c+s];
            for (int currR = r + s; currR > r-s; --currR) {
                int currC = c + s;
                tmp[currR][currC] = tmp[currR-1][currC];
            }
            tmp[r-s+1][c+s] = tmpNum1;

            tmpNum1 = tmp[r+s][c-s];
            for (int currC = c - s; currC < c+s; ++currC) {
                int currR = r + s;
                tmp[currR][currC] = tmp[currR][currC+1];
            }
            tmp[r+s][c+s-1] = tmpNum2;


            for (int currR = r - s; currR < r+s; ++currR) {
                int currC = c - s;
                tmp[currR][currC] = tmp[currR+1][currC];
            }
            tmp[r+s-1][c-s] = tmpNum1;
        }
    }

    public static void findRowMin(int[][] tmp) {
        for (int i=1; i<=N; ++i) {
            int count = 0;
            for (int j=1; j<=M; ++j) {
                count += tmp[i][j];
            }
            rowMin = Math.min(rowMin, count);
        }
    }

}