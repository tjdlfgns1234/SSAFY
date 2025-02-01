package solving.baekjoon15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 중복순열, 오름차순만 허용
 */
public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int arrNum = Integer.parseInt(line[0]);
            int selLimit = Integer.parseInt(line[1]);
            asceRedundantPermution(0, new int[selLimit], arrNum);
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void asceRedundantPermution(int selIdx, int[] selArr, int arrNum) throws Exception {
        if (selIdx == selArr.length) {
            for (int i : selArr) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= arrNum; i++) {
            if (selIdx == 0) {
                selArr[selIdx] = i;
            }
            if (selIdx > 0 && selArr[selIdx - 1] <= i) {
                selArr[selIdx] = i;
            }
            if (selIdx > 0 && selArr[selIdx - 1] > i) {
                continue;
            }
            asceRedundantPermution(selIdx + 1, selArr, arrNum);
        }
    }
}
