package solving.baekjoon2252;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            List<List<Integer>> graph = new ArrayList<>();
            String[] line = br.readLine().trim().split(" ");
            int studentCount = Integer.parseInt(line[0]);
            int compareCount = Integer.parseInt(line[1]);
            int[] inEdgeCount = new int[studentCount + 1];

            for (int i = 0; i < studentCount + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < compareCount; i++) {
                line = br.readLine().trim().split(" ");
                int small = Integer.parseInt(line[0]);
                int large = Integer.parseInt(line[1]);
                graph.get(small).add(large);
                inEdgeCount[large] += 1;
                // 인접 리스트 생성 및 진입 차수 리스트 초기 데이터 저장
            }
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 1; i <= studentCount; i++) {
                if (inEdgeCount[i] == 0) {
                    dq.offer(i);
                }
            }
            while (!dq.isEmpty()) {
                int now = dq.poll();
                bw.write(now + " ");
                for (Integer i : graph.get(now)) {
                    inEdgeCount[i] -= 1;
                    if (0 == inEdgeCount[i]) {
                        dq.offer(i);
                    }
                }
            }
            bw.newLine();
        }
        bw.flush();
    }
}