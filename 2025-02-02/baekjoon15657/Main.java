package solving.baekjoon15657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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

            line = br.readLine().trim().split(" ");
            int[] arr = new int[arrNum];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(arr);
            asceRedundentPermutation(0, new int[selLimit], arr);
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void asceRedundentPermutation(int selIdx, int[] selArr, int[] arr) throws Exception {
        if (selIdx == selArr.length) {
            for (int i : selArr) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (selIdx <= 0) {
                selArr[selIdx] = arr[i];
            } else {
                if (arr[i] >= selArr[selIdx - 1]) {
                    selArr[selIdx] = arr[i];
                } else {
                    continue;
                }
            }
            asceRedundentPermutation(selIdx + 1, selArr, arr);
        }
    }

}
