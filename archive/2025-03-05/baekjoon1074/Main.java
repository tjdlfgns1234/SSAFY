package solving.baekjoon1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 분할정복 문제
 */
public class Main {
    static final int[] POW2N = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768 };

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = toNum(st.nextToken());
            int r = toNum(st.nextToken());
            int c = toNum(st.nextToken());

            int result = dq(N, r, c);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    private static int dq(int n, int r, int c) {
        if (n == 1) {
            return ((r << 1) | c);
        }
        // 현재 사이즈는 2^n * 2^n
        // 이전 사이즈는 2^(n-1) * 2^(n-1)
        // 현재 위치가 몇 이전 기준 + 인지 확인해야합니다.
        int prevSize = POW2N[n - 1];
        int prevVisitCount = prevSize * prevSize;

        int res = (((r >> (n - 1)) << 1) | (c >> n - 1)) * prevVisitCount;
        res += dq(n - 1, r % prevSize, c % prevSize);

        return res;
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
