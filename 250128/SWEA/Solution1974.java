import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 모든 가로줄, 세로줄, 3*3 검사
 */

public class Solution1974 {

    public static int N = 9;

    public static void main(String[] args) throws Exception {
//        System.setIn(Solution1974.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int[][] sudoku = new int[N][N];
            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.print("#" + t + " ");
            if (!verifyRow(sudoku)) {
                System.out.println(0);
            }
            else if (!verifyCol(sudoku)) {
                System.out.println(0);
            }
            else if (!verifyCube(sudoku)) {
                System.out.println(0);
            }
            else {
                System.out.println(1);
            }
        }
    }

    public static boolean verifyRow(int[][] sudoku) {
        for (int i=0; i<N; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<N; ++j) {
                set.add(sudoku[i][j]);
            }
            if (set.size() != N) {
                return false;
            }
        }

        return true;
    }

    public static boolean verifyCol(int[][] sudoku) {
        for (int i=0; i<N; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<N; ++j) {
                set.add(sudoku[j][i]);
            }
            if (set.size() != N) {
                return false;
            }
        }

        return true;
    }

    public static boolean verifyCube(int[][] sudoku) {
        for (int i=0; i<N; i+=3) {
            for (int j=0;j<N; j+=3) {
                if (!verify(sudoku, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean verify(int[][] sudoku, int r, int c) {
        Set<Integer> set = new HashSet<>();
        for (int i=r; i<r+3; ++i) {
            for (int j=c; j<c+3; ++j) {
                set.add(sudoku[i][j]);
            }
        }

        return set.size() == N;
    }
}
