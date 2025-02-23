package solving.swea1225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    static final byte T = 10;
    static final byte passwordCount = 8;

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringBuilder sb = new StringBuilder();
        // 단순 출력의 경우 StringBuilder을 사용할 이유가 없다. 어차피 BufferedWriter가 출력한다.
        // 다시한번 StringTokenizer 는 split보다 느리다!

        for (byte tc = 1; tc <= T; tc++) {
            br.readLine(); // 테케 번호가 주어지는 입력, 안쓴다. 버린다.

            Deque<Integer> queue = new ArrayDeque<>();
            String[] line = br.readLine().trim().split(" ");
            int min = Integer.MAX_VALUE;
            int[] arr = new int[passwordCount];

            for (int i = 0; i < passwordCount; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            for (int i : arr) {
                min = Math.min(i, min);
            }

            // 각 수에 1,2,3,4,5가 모두 돌아가는 시간은 8사이클
            // 8사이클 동안 각 수에 15씩 빠진다.
            // 한 사이클을 덜 빼는 이유는
            // 사이클을 다 뺐는데 바로 값이 0 이 되는 경우, 올바른 답을 출력하지 못하기 때문
            min = min - ((min % 15) + 15);

            for (int i = 0; i < passwordCount; i++) {
                // 사이클을 돌았다 가정하고 먼저 수를 빼준다.
                arr[i] -= min;
                queue.offer(arr[i]);
            }
            int minus = 1;
            while (true) {
                if (minus > 5) {
                    // 이게 모듈러 연산보다 효율적
                    minus = 1;
                }
                int now = queue.poll() - minus;
                if (now <= 0) {
                    now = 0;
                    queue.offer(now);
                    break;
                }
                queue.offer(now);
                minus += 1;
            }

            bw.write("#" + tc);
            while (!queue.isEmpty()) {
                bw.write(" " + queue.poll());
            }
            bw.newLine();
        }
        bw.flush();
    }
}
