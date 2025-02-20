package solving.baekjoon15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().split(" ");
            int arrNum = Integer.parseInt(line[0]);
            int selLimit = Integer.parseInt(line[1]);
            int[] arr = new int[arrNum];
            permutaionWithRepetition(0, new int[selLimit], arr);
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void permutaionWithRepetition(int selIdx, int[] sel, int[] arr) throws Exception {
        // basis
        if (selIdx == sel.length) {
            for (int i : sel) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        // recursive
        for (int i = 1; i <= arr.length; i++) {
            sel[selIdx] = i;
            permutaionWithRepetition(selIdx + 1, sel, arr);
        }
    }
}
