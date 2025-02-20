package solving.baekjoon15666;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException {
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
            permutation(0, new int[selLimit], new boolean[arrNum], arr);
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void permutation(int selIdx, int[] selArr, boolean[] v, int[] arr) throws IOException {
        if (selIdx == selArr.length) {
            for (int i : selArr) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i])
                continue;

            if (selIdx == 0 || selArr[selIdx - 1] <= arr[i]) {
                v[i] = true;
                selArr[selIdx] = arr[i];
                prev = arr[i];
                permutation(selIdx + 1, selArr, v, arr);
                v[i] = false;
            }
        }
    }
}
