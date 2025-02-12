import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17471 {
    static int N;
    static int[] person;
    static List<List<Integer>> graph;
    static int min;
    static int countA, countB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        person = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        min = Integer.MAX_VALUE;

        for (int i=1; i<N+1; ++i) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i=0; i<N+1; ++i) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=1; i<N+1; ++i) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j=0; j<c; ++j) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        //------------ 입력 끝

        // 1개 ~ N-1개를 고르는 경우 뽑기
        for (int s=1; s<N; ++s) {
            recursive(new boolean[N+1], 1, 0, s);
        }

        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    public static void recursive(boolean[] sel, int curr, int idx, int targetCount) {
        if (idx == targetCount) {
            // 1. 연결 됐는지 검사 (선택 된 애, 선택 안 된 애 둘 다)
            if (isPossible(sel)) {
                // 2. 인구 수 차이 구하기
                min = Math.min(min, Math.abs(countA - countB));
            }

            return;
        }

        if (curr > N) {
            return;
        }

        sel[curr] = true;
        recursive(sel, curr+1, idx+1, targetCount);
        sel[curr] = false;
        recursive(sel, curr+1, idx, targetCount);
    }

    public static boolean isPossible(boolean[] sel) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        countA = 0;
        for (int i=1; i<sel.length; ++i) {
            if (sel[i]) {
                listA.add(i);
            }
            else {
                listB.add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(listA.get(0));
        boolean[] used = new boolean[sel.length];
        used[listA.get(0)] = true;

        int chk = 0;
        while (!q.isEmpty()) {
            ++chk;
            int curr = q.poll();
            countA += person[curr];

            for (int next : graph.get(curr)) {
                if (!used[next] && sel[next]) {
                    q.add(next);
                    used[next] = true;
                }
            }
        }

        q = new ArrayDeque<>();
        q.add(listB.get(0));
        countB = 0;
        used[listB.get(0)] = true;

        while (!q.isEmpty()) {
            ++chk;
            int curr = q.poll();
            countB += person[curr];

            for (int next : graph.get(curr)) {
                if (!used[next] && !sel[next]) {
                    q.add(next);
                    used[next] = true;
                }
            }
        }




        return chk == N;
    }


}