package solving.baekjoon16922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.HashSet;

/*
 * 4개 가지고 중복 조합 만들기?
 * N개의 원소로 R개를 뽑아 중복 조합 만들기
 * R개의 원소를 뽑는 자리, 그 속에 N개의 원소를 구분할 N-1개의 구분자(칸막이)
 * 총 R + N - 1 개의 자리에서, R 개의 원소를 뽑아 배치하거나, N-1개의 칸막이를 배치한다
 * 이는 R+N-1 개의 원소에서 R개를 뽑거나 N-1개를 뽑는것과 동일
 * R+N-1 Combination R == R+N-1 Combination N-1
 * 
 * 4 H n
 * n+3 C 3 or n+3 C n
 * 
 * 이라고 생각했는데, 다른 조합으로 같은 수가 나오는 경우가 존재할 것 같다. 중복조합보다 적다.
 * 조합을 다 만들고 계산할 필요 없이 계산하면서 조합을 만드는게 효율적이다.
 */
public class Main {
    static final int[] romeNums = { 1, 5, 10, 50 };
    static Set<Integer> resSet;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = toNum(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = toNum(br.readLine().trim());
            resSet = new HashSet<>();

            combinationRepetition(0, 0, 0);
            bw.write(resSet.size() + "");
            bw.newLine();
        }
        bw.flush();

    }

    private static void combinationRepetition(int idx, int sum, int idxStart) {
        if (idx == N) {
            resSet.add(sum);
            return;
        }

        // 중복 조합이기에 내 다음에 선택 될 원소는 나와 같거나 내 이후 원소여야 한다. 12222와 22221은 같다
        for (int i = idxStart; i < romeNums.length; i++) {
            combinationRepetition(idx + 1, sum + romeNums[i], i);
        }
    }

    private static int toNum(String trim) {
        return Integer.parseInt(trim);
    }
}
