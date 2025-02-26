package solving.swea1486;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int workerNum = toNum(line[0]);
            int height = toNum(line[1]);
            int[] workerHeight = new int[workerNum];
            line = br.readLine().trim().split(" ");
            for (int i = 0; i < workerNum; i++) {
                workerHeight[i] = toNum(line[i]);
            }

            int res = findMin(0, 0, workerHeight, height);

            bw.write("#" + tc + " " + res);
            bw.newLine();
        }
        bw.flush();
    }

    private static int findMin(int idx, int sum, int[] workerHeight, int height) {
        if (sum >= height || idx == workerHeight.length) {
            if (sum >= height)
                return sum - height;
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE;
        // 선택안함
        res = Math.min(res, findMin(idx + 1, sum, workerHeight, height));
        // 선택함
        res = Math.min(res, findMin(idx + 1, sum + workerHeight[idx], workerHeight, height));
        return res;
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
