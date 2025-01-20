import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1707 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        boolean isRow = false;
        int unit = 1;

        int[][] map = new int[N][N];
//		for (int[] arr : map) {
//			Arrays.fill(arr, -1);
//		}

        int idxR = 0;
        int idxC = 0;

        while (count <= Math.pow(N, 2)) {
            if (isRow) {
                if (isValid(map, idxR, idxC)) {
                    map[idxR][idxC] = count++;
                    idxR += unit;
                }
                else {
                    isRow = !isRow;
                    idxR -= unit;
                    idxC += unit;
                }
            }
            else {
                if (isValid(map, idxR, idxC)) {
                    map[idxR][idxC] = count++;
                }
                else {
                    isRow = !isRow;
                    unit *= -1;
                    idxR += unit;
                }
                idxC += unit;
            }
        }

        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean isValid(int[][] map, int idxR, int idxC) {
        return idxR >= 0 && idxC >= 0 && idxR < map.length && idxC < map.length && map[idxR][idxC] == 0;
    }

}
