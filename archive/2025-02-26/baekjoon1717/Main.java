package solving.baekjoon1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().trim().split(" ");

        int setCount = toNum(line[0]);
        int operationCount = toNum(line[1]);
        int[] set = new int[setCount + 1];

        for (int i = 1; i <= setCount; i++) {
            set[i] = i;
        }

        for (int i = 0; i < operationCount; i++) {
            line = br.readLine().trim().split(" ");
            int num1 = toNum(line[1]);
            int num2 = toNum(line[2]);

            if (toNum(line[0]) == 0) {
                // 아 여기에서 어떻게 타고 가는 코드 필요한데
                union(set, num1, num2);
                // int min = Math.min(set[num1], set[num2]);
                // set[num1] = min;
                // set[num2] = min;
            } else if (toNum(line[0]) == 1) {
                if (find(num1, set) == find(num2, set)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            } else {
                System.out.println("잘못된 분기 진입");
            }
        }
        bw.flush();
    }

    private static void union(int[] set, int num1, int num2) {
        int x = find(num1, set);
        int y = find(num2, set);
        int min = Math.min(x, y);
        set[x] = min;
        set[y] = min;
        // if (x != y) {
        // set[y] = x;
        // }
    }

    private static int find(int num1, int[] set) {
        if (set[num1] == num1) {
            return num1;
        }
        return set[num1] = find(set[num1], set);
    }

    private static int toNum(String string) {
        return Integer.parseInt(string);
    }
}
