import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿼드트리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;

    static boolean isCheck(int y, int x, int size) {
        char first = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }

    static StringBuilder divide(int y, int x, int size) {
        if (isCheck(y, x, size)) {
            return new StringBuilder().append(map[y][x]);
        }

        int div = size / 2;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(divide(y, x, div));
        sb.append(divide(y, x + div, div));
        sb.append(divide(y + div, x, div));
        sb.append(divide(y + div, x + div, div));
        sb.append(")");

        return sb;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            map[i] = temp.toCharArray();
        }

        System.out.println(divide(0, 0, N));
    }
}
