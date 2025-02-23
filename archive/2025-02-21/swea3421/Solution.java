package solving.swea3421;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 파워 셋 문제, 공집합도 가능하다.
 * 비트 연산으로 한번 해보자
 */

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            // 비트 연산을 해보자
            int[] bitGraph = new int[N];
            for (int i = 0; i < M; i++) {
                line = br.readLine().trim().split(" ");
                int ingredient1 = Integer.parseInt(line[0]) - 1;
                int ingredient2 = Integer.parseInt(line[1]) - 1;
                bitGraph[ingredient1] = (bitGraph[ingredient1] | (1 << ingredient2));
                bitGraph[ingredient2] = (bitGraph[ingredient2] | (1 << ingredient1));
            }

            int res = powerSet(bitGraph, 0, 0);
            sb.append("#" + tc + " " + res + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 버거를 만들어 가며 하고 싶은데 그러면 필터링을 어떻게 해야하나
    // 재귀를 가지치기 하고싶다는 뜻입니다.
    private static int powerSet(int[] bitGraph, int idx, int choose) {
        if (idx == bitGraph.length) {
            // 여기서 버거가 Valid 한지 검사하지 말고 만들면서 하자
            return 1;
        }

        int res = 0;
        // 선택 안한경우를 먼저해서 연산량을 줄여볼까
        res += powerSet(bitGraph, idx + 1, choose);

        if (valid(bitGraph, idx, choose)) {
            choose = choose | (1 << idx);
            res += powerSet(bitGraph, idx + 1, choose);
        }
        return res;
    }

    private static boolean valid(int[] bitGraph, int idx, int choose) {
        // idx 에 대해서 이미 선택된 choose에 이 idx와 함께 사용하면 안되는 재료가 있는지
        // 없을 때 true 반환
        return (0 == (bitGraph[idx] & choose));
    }
}
