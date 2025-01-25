package solving.baekjoon17471;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] adj;
    static int[] pop;

    public static void main(String[] args) throws Exception {
        URL input = Main.class.getResource("input.txt");
        System.setIn(new FileInputStream(input.getPath()));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // T = 1;
        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            pop = new int[N + 1];
            adj = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                pop[i] = sc.nextInt();
            }
            for (int i = 1; i <= N; i++) {
                int n = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    int m = sc.nextInt();
                    adj[i][m] = 1;
                    adj[m][i] = 1;
                }
            }
            diff = Integer.MAX_VALUE;
            powerSet(1, new boolean[N + 1]);
            System.out.println(diff == Integer.MAX_VALUE ? -1 : diff);
        }
        sc.close();
    }

    static int diff = Integer.MAX_VALUE;

    private static void powerSet(int idx, boolean[] sel) {
        if (idx == N + 1) {
            // System.out.println(Arrays.toString(sel));
            // 두개의 구역으로 나누기
            // solving
            // 각 구역이 연결되어 있는지 확인(dfs, bfs)
            if (check(sel)) {
                // 각 구역이 연결되어 있다면
                // 두 구역의 값의 차가 최소가 되도록
                int sumA = 0, sumB = 0;
                for (int i = 1; i < sel.length; i++) {
                    if (sel[i])
                        sumA += pop[i];
                    else
                        sumB += pop[i];
                }
                diff = Math.min(diff, Math.abs(sumA - sumB));
            }
            return;
        }

        sel[idx] = true;
        powerSet(idx + 1, sel);
        sel[idx] = false;
        powerSet(idx + 1, sel);
    }

    private static boolean check(boolean[] sel) {
        // 두 선거구가 연결되었는지 확인
        ArrayList<Integer> areaA = new ArrayList<>();
        ArrayList<Integer> areaB = new ArrayList<>();
        for (int i = 1; i < sel.length; i++) {
            if (sel[i])
                areaA.add(i);
            else
                areaB.add(i);
        }
        // 두 선거구의 구역의 숫자가 0이면 안된다
        if (areaA.size() == 0 || areaB.size() == 0)
            return false;

        // 구역 연결 확인
        boolean[] v = new boolean[N + 1];
        dfs(areaA, areaA.get(0), v);
        dfs(areaB, areaB.get(0), v);

        for (int i = 1; i < v.length; i++) {
            if (!v[i])
                return false;
        }
        return true;
    }

    private static void dfs(ArrayList<Integer> area, Integer idx, boolean[] v) {
        v[idx] = true;
        for (int i = 0; i < area.size(); i++) {
            if (adj[idx][area.get(i)] == 1 && !v[area.get(i)])
                dfs(area, area.get(i), v);
        }
    }

    private static void print(int[][] adj) {
        for (int i = 0; i < adj.length; i++) {
            System.out.println(Arrays.toString(adj[i]));
        }
    }
}
