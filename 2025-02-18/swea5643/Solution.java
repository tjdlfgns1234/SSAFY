package solving.swea5643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 	일단 그래프를 만들어, 그리고 나와 확실한 크기 비교가 되는 경우를 배열에 세면 될 것 같은데
 *  나보다 큰 경우는 내가 DFS 그래프로 닿을 수 있는 숫자들,
 *  	set으로 만들어서 DFS 탐색으로 다 닿은거 저장 하며, 내 set을 내가 닿은 set에 저장?
 *  나보다 작은 경우는 나를 DFS 그래프로 닿을 수 있는 숫자들
 *  
 *  모든 노드에 대해 DFS를 해서 내가 바라보는것에 대해 기록을 해두고
 *  내가 바라보지 않는 경우, 그 학생들이 모두 나를 바라본다면 OK?
 */

public class Solution {
    static List<List<Integer>> graph;
    static int studentCount, graphCount;
    static List<Set<Integer>> setList;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            graph = new ArrayList<>();
            setList = new ArrayList<>();

            String[] line;

            studentCount = Integer.parseInt(br.readLine().trim());
            graphCount = Integer.parseInt(br.readLine().trim());

            visit = new boolean[studentCount];
            for (int i = 0; i < studentCount; i++) {
                graph.add(new ArrayList<>());
                setList.add(new HashSet<>());
            }
            for (int i = 0; i < graphCount; i++) {
                line = br.readLine().trim().split(" ");
                // 인풋은 1부터 제공되므로 1 빼서 저장하기
                int small = Integer.parseInt(line[0]) - 1;
                int large = Integer.parseInt(line[1]) - 1;
                graph.get(small).add(large);
            }
            // 입력 끝

            for (int i = 0; i < studentCount; i++) {
                if (!visit[i]) {
                    dfs(i);
                }
            }

            int res = 0;
            for (int i = 0; i < studentCount; i++) {
                if (check(i)) {
                    res += 1;
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }

    private static boolean check(int i) {
        for (int j = 0; j < studentCount; j++) {
            if (i == j)
                continue;
            // 내가 바라보지도, 나를 바라보지도 않으면
            if (!setList.get(i).contains(j) && !setList.get(j).contains(i))
                return false;
        }
        return true;
    }

    private static Set<Integer> dfs(int idx) {
        if (visit[idx])
            return setList.get(idx);

        visit[idx] = true;
        Set<Integer> nowSet = setList.get(idx);
        nowSet.add(idx);

        for (int i = 0; i < graph.get(idx).size(); i++) {
            nowSet.addAll(dfs(graph.get(idx).get(i)));
        }
        return nowSet;
    }
}
